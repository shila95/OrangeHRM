package TestCase;

import org.testng.annotations.Test;

import PageObject.LoginPage;
import TestBase.BaseClass;

public class TC1_LogingTest extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verify_Lonin() {
		logger.info("Starting of TC1_LoginTest...");

		// LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(p.getProperty("Username"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickLogin();

		logger.info("Clicked on Login Button");

		logger.info("Finishing of TC1_LoginTest...");
	}

}
