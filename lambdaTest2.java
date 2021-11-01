package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class lambdaTest2 {
	
	
	public static WebDriver driver;
	
	By imgJenkins = By.xpath("//img[@title='Jenkins']");
	
	 public lambdaTest2(WebDriver driver )
	    {
		 lambdaTest2.driver=driver;  	
	    }

	 public void gettingimage() throws IOException, InterruptedException, AWTException
	 {
      WebElement logo =   driver.findElement(imgJenkins);
      Actions action= new Actions(driver);
      action.contextClick(logo).build().perform();
      action.sendKeys(Keys.CONTROL, "v").build().perform();
      Robot robot = new Robot();
      robot.keyPress(KeyEvent.VK_ENTER);  
	 }
	 
	 public void previoustab()
	   {
		  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(0)); //switches to new tab
		    driver.get("https://www.lambdatest.com/selenium-automation");
	   }
	 
	 public void labmdaTest2() throws IOException, InterruptedException, AWTException
	 {
		 this.gettingimage();
		 this.previoustab();
	 }
	 
	 
}
