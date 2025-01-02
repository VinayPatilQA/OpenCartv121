package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	//Locators 
	

	//input[@id='input-email']
	//input[@id='input-password']
	//input[@value='Login']
	
	@FindBy(xpath="//input[@id='input-email']") WebElement emailadd;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement lbgbtn;
	
	
	//Action methods
	public void setEmail(String em)
	{
		emailadd.sendKeys(em);
	}
	public void setPassword(String pd)
	{
		password.sendKeys(pd);
	}
	public void btnClcik()
	{
		lbgbtn.click();
	}
	
	
	
}
