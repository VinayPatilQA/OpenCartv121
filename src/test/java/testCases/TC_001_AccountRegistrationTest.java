	package testCases;
	
	import org.testng.Assert;
	import org.testng.annotations.Test;
	
	import pageObjects.AccountRegisterPage;
	import pageObjects.HomePage;
	import testBase.BaseClass;
	
	public class TC_001_AccountRegistrationTest extends BaseClass {
	
		
		
		@Test(groups={"sanity","master"})
		public void myAccountClickPage()
		{
			
			logger.info("*******Starting the TC_001_AccountRegistrationTest******");
			
			HomePage hp = new HomePage(driver);
			
			try
			{
			logger.info("Clicking My ACcount link");
			hp.myAccountclick();
			
			
			logger.info("Clicking Register Account link");
			hp.registerClick();
	
			AccountRegisterPage rp = new AccountRegisterPage(driver);
	
			
			logger.info("sending information");
			rp.setFirstName(randomalpa());
	
			rp.setLastName(randomalpa());
	
			rp.setEmail(randomalpa() + "@gmail.com");
	
			rp.setTelnum(randomNum());
	
			String password = randomalphaNumeric();
	
			rp.setPassword(password);
	
			rp.setcnmpwd(password);
	
			logger.info("Clicking CheckBox ");
			rp.chkclick();
	
			logger.info("Clicking Continue Button ");
			rp.continueClick();
			logger.info("*******Completed the TC_001_AccountRegistrationTest******");
			Assert.assertEquals(rp.getTextFromPage(), "Your Account Has Been Created!");
			}

         catch (Exception e) {
            // Log the exception and fail the test
            logger.error("An error occurred: ", e);
            logger.debug("Debug Logs");
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }

			logger.info("Test is Finished");
		// Create Random data for name,last name, email,phNo and password
	
		// There is the predefiened class in java
	
	}
	}
