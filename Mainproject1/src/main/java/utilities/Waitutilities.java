package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waitutilities
{
	public static int implicitWaitDuration=10;//toget 10sec duration in all methods
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void waituntilelementisvisible(WebDriver driver,WebElement element)
	{
		
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(10)); //object creation
		
		obj.until(ExpectedConditions.visibilityOf(element)); 
	}
	public void waituntilalertispresent(WebDriver driver)
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(10));
		obj.until(ExpectedConditions.alertIsPresent());
	}
	public void waituntilelementtobeclick(WebDriver driver,WebElement element) 
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(10));
		obj.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waituntilelementtobeselect(WebDriver driver,WebElement element)
	{
	WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(10));
	obj.until(ExpectedConditions.elementToBeSelected(element));
}
	public void waituntilvisibilityofwebelement(WebDriver driver,WebElement element)
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(10));
		obj.until(ExpectedConditions.visibilityOf(element));
	}
	public void waituntiltexttobepresent(WebDriver driver,WebElement element,String a)
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(10));
		obj.until(ExpectedConditions.textToBePresentInElement(element, a));
	}
	public void fluentwait(WebDriver driver,WebElement element)
	{
		FluentWait<WebDriver>wait=new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(20))
		.pollingEvery(Duration.ofSeconds(5))//condition check every 5sec
		.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}



