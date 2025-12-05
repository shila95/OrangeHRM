package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PmiPage extends BasePage {

	// constructor
	public PmiPage(WebDriver driver) {
		super(driver);
	}

	// locators

	@FindBy(xpath = "//div[@class='oxd-layout-navigation']//li[2]")
	WebElement bttn_pmi;

	//Add Button to create new Employee
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement bttn_add;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement inpt_fname;
	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	WebElement inpt_mname;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement inpt_lname;

	@FindBy(xpath = "//div/label[contains(text(),'Employee Id')]/ancestor::div[1]/following-sibling::div/input")
	WebElement inpt_id;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement bttn_save1;

	//Employee Details
	@FindBy(xpath = "//label[text()=\"Driver's License Number\"]/ancestor::div[1]/following-sibling::div/input")
	WebElement inpt_licNo;

	@FindBy(xpath = "//label[text()='License Expiry Date']/parent::div[1]/following-sibling::div/div/div/input[@placeholder='yyyy-dd-mm']")
	//@FindBy(xpath = "//label[text()='License Expiry Date']/ancestor::div[2]/div/div")
	WebElement inpt_licdate;

	@FindBy(xpath = "//label[text()='Nationality']/ancestor::div[2]/div/div")
	WebElement dropdwn_nationlt;
	@FindBy(xpath = "//span[normalize-space()='Indian']")
	WebElement Option_nationlt;

	@FindBy(xpath = "//label[text()='Marital Status']/parent::div/following-sibling::div/div/div/div[text()='-- Select --']")
	WebElement dropdwn_maritlstatus;
	@FindBy(xpath="//span[normalize-space()='Married']")
	WebElement Option_maritlstatus;
	
	@FindBy(xpath="//label[text()='Date of Birth']/parent::div/following-sibling::div/div/div/input[@placeholder=\"yyyy-dd-mm\"]")
	WebElement inpt_DOB;
	
	@FindBy(xpath="//label[text()='Gender']/parent::div/following-sibling::div/div[2]/div[2]/div/label/span")
	WebElement rdBttn_Female;
	@FindBy(xpath="//label[text()='Gender']/parent::div/following-sibling::div/div[1]/div[2]/div/label/span")
	WebElement rdBttn_Male;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")
	WebElement bttn_save2;
	
	@FindBy(xpath="//label[text()='Blood Type']/parent::div/following-sibling::div/div/div/div[text()='-- Select --']")
	WebElement dropdwn_bloodType;
	@FindBy(xpath="//div[@role='listbox']//div[4]/span[text()='B+']")
	WebElement Option_BloodType;
	
	@FindBy(xpath="//form[@class='oxd-form']/div[2]/button[@type='submit']")
	WebElement bttn_save3;
	
	public void clickPMI() {
		bttn_pmi.click();
	}

	public void clickAdd() {
		bttn_add.click();
	}

	public void setFirstName(String Fname) {
		inpt_fname.sendKeys(Fname);
	}

	public void setMiddleName(String Mname) {
		inpt_mname.sendKeys(Mname);
	}

	public void setLastName(String Lname) {
		inpt_lname.sendKeys(Lname);
	}

	public void setID() {
		inpt_id.click();
		inpt_id.clear();
		inpt_id.sendKeys("098");
	}

	public void clickSave1() {
		bttn_save1.click();
	}

	public void setLicNo(String licNo) {
		inpt_licNo.click();
		inpt_licNo.sendKeys(licNo);
	}

	public void setLicDate(String date) {
		inpt_licdate.click();
		inpt_licdate.sendKeys(date);
	}

	public void setNationality() {
		dropdwn_nationlt.click();
		Option_nationlt.click();
	}

	public void setMaritalstatus() {
		dropdwn_maritlstatus.click();
		Option_maritlstatus.click();
	}
	
	public void setDOB(String date)
	{
		inpt_DOB.click();
		inpt_DOB.sendKeys(date);
	}
	
	public void selectGender()
	{
		rdBttn_Female.click();
	}

	public void clickSave2()
	{
		bttn_save2.click();
	}
	
	public void setBloodType()
	{
		dropdwn_bloodType.click();
		Option_BloodType.click();
	}
	
	public void clickSave3()
	{
		bttn_save3.click();
	}
	
}
