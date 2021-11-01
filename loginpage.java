	package pages;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	
	public class loginpage {
		
		//reference variable initialisation
		WebDriver driver;
		
		
		
		By userName=By.xpath("//label[contains(.,'Username')]//following::input[@name='name']");
		By passWord=By.xpath("//label[contains(.,'Password')]//following::input[@name='password']");
		By login = By.xpath("//button[text()='Login']");
		String actualurl = "https://www.lambdatest.com/automation-demos";
		
		
	    public loginpage(WebDriver driver )
	    {
	       this.driver=driver;  	
	    }

	    
	    public void loginpage(String us,String pass)
	    {
	    
	    	driver.findElement(userName).sendKeys(us);
	    	driver.findElement(passWord).sendKeys(pass);
	    	driver.findElement(login).click();
	    }
	    
	    
	    public void setusername(String us)
	    {
	    	driver.findElement(userName).sendKeys(us);
	    }
	   
	    
	    public void setpassword(String pass)
	    {
	    	driver.findElement(passWord).sendKeys(pass);
	    }
	    
	    
	    public void click()
	    {
	    	driver.findElement(login).click();
	    }
	    
	    public void validateurl()
	    {
	    	String url = driver.getCurrentUrl();
	    	boolean result =url.equalsIgnoreCase(actualurl);
	    	if(result==true)
	    	{
	    		System.out.println("pass");
	    	}
	    	else
	    	{
	    		System.out.println("fail");
	    		driver.quit();
	    	}
	    	
	    }
	  
	    public void loginjira1(String us,String pass) throws InterruptedException
	    {
	    	this.setusername(us);
	    	this.setpassword(pass);
	    	this.click();
	    	Thread.sleep(2000);
	    	this.validateurl();
	    	
	    }
	    
	 
	    
	}


