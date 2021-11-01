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
	
	
WebDriver driver;	

	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) throws InterruptedException, IOException, AWTException {
			if (browser.equalsIgnoreCase("safari")) {		
				WebDriver driver = new SafariDriver();	
			} else if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();	
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
