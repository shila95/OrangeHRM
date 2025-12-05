package TestCase;

import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.PmiPage;
import TestBase.BaseClass;

public class TC2_PMITest extends BaseClass {

	@Test(groups = { "Regression", "Master" })

	public void addEployee() {
		logger.info("Starting of TC2_LoginTest...");

		// LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(p.getProperty("Username"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickLogin();

		logger.info("Clicked on Login Button");

		// PmiPage
		PmiPage pp = new PmiPage(driver);
		pp.clickPMI();
		pp.clickAdd();

		logger.info("Adding Employee details...");

		pp.setFirstName(p.getProperty("First_name"));
		pp.setMiddleName(p.getProperty("Middle_name"));
		pp.setLastName(p.getProperty("Last_name"));
		pp.setID();
		pp.clickSave1();

		pp.setLicNo(p.getProperty("License_Number"));
		pp.setLicDate(p.getProperty("Lic_Date"));
		pp.setNationality();
		pp.setMaritalstatus();
		pp.setDOB(p.getProperty("DOB"));
		pp.selectGender();
		pp.clickSave2();
		pp.setBloodType();
		pp.clickSave3();
		
		logger.info("Finishing of TC2_LoginTest...");
	}

}
