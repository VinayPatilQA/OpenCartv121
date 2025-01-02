package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegisterPage extends BasePage 
    {

	public AccountRegisterPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Locators

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement Fname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement Lname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement Email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement TelNum;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Pwd;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement CmPwd;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkBox;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Continuebtn;
	@FindBy(xpath = "//*[@id='content']/h1")
	WebElement text;

	// Action Methods

	public void setFirstName(String name) {
		Fname.sendKeys(name);
	}

	public void setLastName(String LaName) {
		Lname.sendKeys(LaName);
	}

	public void setEmail(String mail) {
		Email.sendKeys(mail);
	}

	public void setTelnum(String num) {
		TelNum.sendKeys(num);
	}

	public void setPassword(String password) {
		Pwd.sendKeys(password);
	}

	public void setcnmpwd(String cmpassword) {
		CmPwd.sendKeys(cmpassword);
	}

	public void chkclick() {
		chkBox.click();
	}

	public void continueClick() {
		Continuebtn.click();
	}

	public String getTextFromPage() {
		String message = "";
		// Declare message variable to hold the result
		try {
			message = text.getText(); // Get the text from the element
		} catch (Exception e) {
			message = "Error: " + e.getMessage(); // If an exception occurs, return the error message
		}
		return message; // Return the text or the error message
	}

}
