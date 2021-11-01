package pages;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class lambdaTest {
	
	public static WebDriver driver;

	 
	By txtEmail = By.xpath("//h1[text()='Your Email:']//following::input[@name='email']");
	By populate  = By.xpath("//h1[text()='Your Email:']//following::input[@value='Populate']");
	String radioButton ="//label[@for='option']//preceding::input[@type='radio']";
    String  checkbox ="(//input[@type='checkbox'])[Num]";
    By 	roleslider = By.xpath("//div[@role='slider']");
    By  slideposition = By.xpath("//div[@class='mb-30']/div/div/div[10]");
	By  drppaymentprefer = By.xpath("//select[@name='preferred-payment']");
	By  txtfeedback   = By.xpath("//h1[text()='Please share your feedback here']//following::textarea");
	By   uploadimage = By.xpath("//label[text()=' upload image']");
	String actualurl = "https://www.lambdatest.com/automation-demos";
	
    public lambdaTest(WebDriver driver )
    {
       lambdaTest.driver=driver;  	
    }

	public void EnterEmail(String email)
	{
		driver.findElement(txtEmail).sendKeys(email);
		driver.findElement(populate).click();
	}
	
	public void radiobutton()
	{
     String xpath=radioButton.replaceAll("option", "Every month");
     driver.findElement(By.xpath(xpath)).click();
	}
	
   public void Alert()
   {  	
	   Alert alert= driver.switchTo().alert();
       String msg =alert.getText();
       msg.equalsIgnoreCase("hey@gmail.com");
	   alert.accept();
   }
   
   public void  selectcheckbox(String num)
   {
	 String xpath= checkbox.replaceAll("Num", num);
	driver.findElement(By.xpath(xpath)).click();
	 
   }
   
   public void paymentDropdown() throws InterruptedException
   {  
	   Thread.sleep(1000);
	   WebElement drp = driver.findElement(drppaymentprefer);
	   Select select = new Select(drp); 
	   select.selectByVisibleText("Wallets");
   }
   
   
   public void ecommercepurchase() throws InterruptedException
   {
	   Thread.sleep(2000);
	   WebElement Position1 = driver.findElement(roleslider);
	   WebElement Position2 = driver.findElement(slideposition);
	   Actions builder = new Actions(driver);
	   builder.dragAndDrop(Position1, Position2).build().perform();	
	   String actualvalue = Position1.getAttribute("aria-valuenow");
	   AssertJUnit.assertEquals(actualvalue, "90");
   }
   
   
   public void feedback()
   {
	   driver.findElement(txtfeedback).sendKeys("feedback is good");
   }
   
   
   public void switchnewtab()
   {
	  ((JavascriptExecutor) driver).executeScript("window.open()");
	  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); //switches to new tab
	    driver.get("https://www.lambdatest.com/selenium-automation");
   }

    public void uploadimage()
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement upload_file = driver.findElement(drppaymentprefer);
    	js.executeScript("arguments[0].scrollIntoView();", upload_file);
    	upload_file.sendKeys("F://jenkins.svg");
    }
    
    
public void lambdaTest(String email) throws InterruptedException
   {
	   this.EnterEmail(email);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   this.Alert();
	   this.radiobutton();
	   this.selectcheckbox("1");
	   this.selectcheckbox("2");
	   this.selectcheckbox("5");
	   this.paymentDropdown();
	   this.ecommercepurchase();
	   this.feedback();
	   this.switchnewtab();
	   
   }
   
	
}
