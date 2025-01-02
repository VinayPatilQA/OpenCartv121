package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginAccountTest extends BaseClass {

	// Home Page
	@Test(groups={"regression","master"})
	public void LoginTest1() {
		logger.info("Starting TC_002_LoginAccountTest Started");

		try {
			// Home Page action methods

			logger.info("Entering Home Page details ");
			HomePage hp = new HomePage(driver);
			hp.myAccountclick();
			hp.loginClick();

			// Login page methods calling
			logger.info("Entering Login Page details ");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.btnClcik();

			// My Account

			MyAccountPage mp = new MyAccountPage(driver);
			boolean headerStatus = mp.getHeader();

			Assert.assertEquals(headerStatus, true);
			logger.info("Completed Testcase execution ");

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
