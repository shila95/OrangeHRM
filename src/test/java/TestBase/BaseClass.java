package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		FileReader file = new FileReader(".\\src\\test\\resources\\Config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			if (os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WINDOWS);
			}

			else if (os.equalsIgnoreCase("Linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}

			else if (os.equalsIgnoreCase("Mac")) {
				capabilities.setPlatform(Platform.MAC);
			}

			else {
				System.out.println("No Matching os");
				return;
			}

			switch (br) {
			case "Edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "Chrome":
				capabilities.setBrowserName("Chrome");
				break;
			default:
				System.out.println("Invalid Browser...");
				return;
			}
			driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), capabilities);
		}

		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br) {
			case "Edge":
				driver = new EdgeDriver();
				break;
			case "Chrome":
				driver = new ChromeDriver();
				break;
			default:
				System.out.println("Invalid Browser...");
				return;
			}

		}

		// driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {
		driver.quit();
	}

	public String captureScreen(String tname) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);

		String targetfilepath = System.getProperty("user.dir") + "\\screenshots\\" + tname + " " + timestamp + ".png";
		File targetfile = new File(targetfilepath);

		sourcefile.renameTo(targetfile);
		return targetfilepath;

	}

}
