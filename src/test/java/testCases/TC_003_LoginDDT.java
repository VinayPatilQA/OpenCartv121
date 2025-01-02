package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String emaail, String pasword, String exp)
	{
		try
		{
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.myAccountclick();
		hp.loginClick();

		// Login page 
		LoginPage rp=new LoginPage(driver);
		rp.setEmail(emaail);
		rp.setPassword(pasword);
		rp.btnClcik();

		// My Account

		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetPage=mp.getHeader();
		
		
		if(exp.equalsIgnoreCase("valid"))	
				{
			if(targetPage==true)
			{
			Assert.assertTrue(true);
			mp.logoutBtn();
			
				}
		else
		{
			Assert.assertTrue(false);
		}
				}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
				{
			Assert.assertTrue(false);
			}
			else
			{
			Assert.assertTrue(true);
			mp.logoutBtn();
			}
			}
	}
	catch(Exception e)
	{
		Assert.fail();
	}

	}
		
}
