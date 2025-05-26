package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import utilities.Screenshotutility;

public class Base {
	Properties prop;
	FileInputStream fs;
  public WebDriver driver;
	
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	
public void initialisebrowser(String browser) throws Exception 
{
		prop=new Properties();//creates a new instance ofthe properties class injava.prop is a variable name referencing the new properties object
		fs=new FileInputStream(Constants.CONFIGFILE);//object creation of fileinputstream used to read bytes from file and passes static variable inthe constand class that holds the path to configure file.ex-config properties
		
		prop.load(fs);//loading configuration or property data from a file using in the fs module
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		} 
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid browser");
		}
		 
		 driver.get(prop.getProperty("url"));
	
		
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	
	
	
		 @AfterMethod(alwaysRun=true) 
		 	public void driverQuit(ITestResult itestresult) throws IOException //ITestResult is a interface and instance object is created
		 	{ 
		 		if(itestresult.getStatus()==ITestResult.FAILURE) //if we want pass scrnshot then .pass
		 		{ 
		 			Screenshotutility screenshot=new Screenshotutility(); 
		 			screenshot.getScreenshot(driver,itestresult.getName()); 
		 		} 
		 	//	driver.quit(); 
		 			 
		 	} 
		 			 
		 	
	}
