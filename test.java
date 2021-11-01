package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	
	public String username = "vijipraveen18";
	  public String accesskey = "p95GzAfAc8KP218jOh0yMDmzR9oahrrzBYxSZxwFAYVkQHWRLo";
	  public RemoteWebDriver driver = null;
	  public String gridURL = "@hub.lambdatest.com/wd/hub";
	  boolean status = false;
// WebDriver driver;	

	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) throws InterruptedException, IOException, AWTException {
	      DesiredCapabilities capabilities = new DesiredCapabilities();
	      capabilities.setCapability("platform", "Windows 10");
	      capabilities.setCapability("browserName", "Chrome");
	      capabilities.setCapability("version", "95.0");
	      capabilities.setCapability("resolution","1024x768");
	      capabilities.setCapability("build", "LambdaTestSampleApp");
	      capabilities.setCapability("name", "LambdaTestJavaSample");
	      capabilities.setCapability("build", "First Test");
	      capabilities.setCapability("name", "Sample Test");
	      capabilities.setCapability("network", true); // To enable network logs
	      capabilities.setCapability("visual", true); // To enable step by step screenshot
	      capabilities.setCapability("video", true); // To enable video recording
	      capabilities.setCapability("console", true); // To capture console logs
	      try {
			if (browser.equalsIgnoreCase("safari")) {		
				WebDriver driver = new SafariDriver();	
			} else if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();	
	      } 
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
    		
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	  }
  }

	@Test
	public void Runner() throws InterruptedException, IOException, AWTException
	{
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/automation-demos");
		loginpage login = new loginpage(driver);
		lambdaTest lam = new lambdaTest(driver);
		lambdaTest2 lam2 = new lambdaTest2(driver);
		login.loginpage("lambda", "lambda123");
	    lam.lambdaTest("hey@gmail.com");
	    lam2.labmdaTest2();
	    lam.uploadimage();
        driver.quit();
	   
	}

  }
