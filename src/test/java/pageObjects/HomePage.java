package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	// in page objects classes we have 3 sections
	/*
	 * 1) Construction part 2) Locators 3) ACtions methods
	 */

	// Intilize Constructor

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//i[@class='fa fa-user']")
	WebElement myAccount;

	@FindBy(xpath = "//*[text()='Register']")
	WebElement register;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement login;

	// Action methods

	public void myAccountclick() {
		myAccount.click();
	}

	public void registerClick() {
		register.click();
	}

	public void loginClick() {
		login.click();
	}

}
