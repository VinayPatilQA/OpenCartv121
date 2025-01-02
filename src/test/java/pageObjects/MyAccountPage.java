package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//*[@id='content' and @class='col-sm-9']/h2[text()='My Account']") WebElement header;

	@FindBy(xpath=("//a[@class='list-group-item'][normalize-space()='Logout']")) WebElement logout;
	
	public boolean getHeader()
	{
		try
		{
		return header.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public void logoutBtn()
	{
		logout.click();
	}
}
