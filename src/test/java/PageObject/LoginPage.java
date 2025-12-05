package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
		
	//locators

@FindBy(xpath="//input[@placeholder='Username']")
//@FindBy(xpath="//i[@class='oxd-icon bi-person oxd-input-group__label-icon']/parent::div[1]/following-sibling::div/input[@placeholder='username']")
WebElement inpt_usrnm;

@FindBy(xpath="//input[@placeholder='Password']")
WebElement inpt_pswd;

@FindBy(xpath="//button[normalize-space()='Login']")
WebElement bttn_lgin;

public void setUsername(String usrname)
{
	inpt_usrnm.sendKeys(usrname);
}

public void setPassword(String pswd)
{
	inpt_pswd.sendKeys(pswd);
}

public void clickLogin()
{
	bttn_lgin.click();
}

}