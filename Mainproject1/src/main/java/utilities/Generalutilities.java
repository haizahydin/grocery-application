package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Generalutilities {
	//JAVA SCRIPT EXECUTER
	
		public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		public void scrollbyverticala( WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			//js.executeScript("window.scrollBy(0,-350)","");
		}	
		public void scrollbyhorizondal(WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver ;
			js.executeScript("window.scrollBy(500,0)","");
			js.executeScript("window.scrollBy,(-500,0)","");
		}
		public void scrolluptofullheight( WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver ;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
		public void scrollbyviewanelement(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver ;
			js.executeScript("arguments[0].scrollIntoView()",element);
		}
		public String generateCurrentDateAndTime() { 
	 		Date date = new Date(); 
	 		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss"); 
	 		return formatter.format(date); 
	 	}
	//DROP DOWN
		
		public String selectDropdownWithValue(WebElement element, String value)
		{
			Select object = new Select(element);
			object.selectByValue(value);
			WebElement selectedElement = object.getFirstSelectedOption();
			return selectedElement.getText();
		}
		public String selectdropdownbyindex(WebElement element, int index)
				{
			Select object = new Select(element);
			object.selectByIndex(index);
			WebElement selectedElement = object.getFirstSelectedOption();
			return selectedElement.getText();

	}
		public  String selectdropdownbyvisibletext(WebElement element, String value)
		{
			Select object = new Select(element);
			object.selectByVisibleText("value");
			WebElement selectedElement = object.getFirstSelectedOption();
			return selectedElement.getText();
		}
		
		public void dragonaction(WebDriver driver,WebElement sourseelement,WebElement targetelement)
		{
			Actions action=new Actions(driver);
			action.dragAndDrop(sourseelement, targetelement).perform();
		}
		public void alerthandlingsinglealert(WebElement clickbut,WebDriver driver)
		{
			
			
			clickbut.click();
			driver.switchTo().alert().accept();
		}
		public void alerthandlingconfrmtionalert(WebElement clicksec,WebDriver driver)
		{	
			clicksec.click();
			String alerttext=driver.switchTo().alert().getText();
			System.out.println(alerttext);
			driver.switchTo().alert().dismiss();
		}
		public void alerthandlingpromtalert(WebElement clickprompt,WebDriver driver,String value)
		{
			
			clickprompt.click();
			driver.switchTo().alert().sendKeys("value");
			driver.switchTo().alert().accept();
			
			}
		
		
		}


