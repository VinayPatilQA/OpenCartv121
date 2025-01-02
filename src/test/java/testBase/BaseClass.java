package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;

	public Logger logger;

	public Properties p;

	@Parameters({ "os", "browser" })
	@BeforeClass(groups = { "sanity", "regression", "master" })
	public void setUp(String os, String br) throws IOException {
		FileReader file = new FileReader("./src/test/resources/config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

	/*
		if (p.getProperty("execution_Env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			if (os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WIN10);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No Matiching OS");
				return;
			}

			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid broser name...");
				return;

				
				
			}

			
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid broser name...");
				return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		
		if (p.getProperty("execution_Env").equalsIgnoreCase("local"))
		{
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid broser name...");
				return;	
		}
		
		*/
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid broser name...");
			return;
		}
		driver.get(p.getProperty("appurl"));// reading value from the properties file
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}
	

	@AfterClass(groups = { "sanity", "regression,master" })
	public void tearDown() {
		driver.quit();
	}

	public String randomalpa() {
		String randomAlphabets = RandomStringUtils.randomAlphabetic(5);
		return randomAlphabets;

	}

	public String randomNum() {
		String randomnumerics = RandomStringUtils.randomNumeric(5);
		return randomnumerics;

	}

	public String randomalphaNumeric() {
		String randoalphaNum = RandomStringUtils.randomAlphanumeric(5);
		return randoalphaNum;
	}

}