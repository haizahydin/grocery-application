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
	public static int implicitWaitDuration=10;
	public static int explicitwaitduration=15;
	public static int fluentwaitduration=30;
	public static int fluentintervel=5;
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitDuration));
	}
	public void waituntilelementisvisible(WebDriver driver,WebElement element)
	{
		
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(explicitwaitduration)); //object creation
		
		obj.until(ExpectedConditions.visibilityOf(element)); 
	}
	public void waituntilalertispresent(WebDriver driver)
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(explicitwaitduration));
		obj.until(ExpectedConditions.alertIsPresent());
	}
	public void waituntilelementtobeclick(WebDriver driver,WebElement element) 
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(explicitwaitduration));
		obj.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waituntilelementtobeselect(WebDriver driver,WebElement element)
	{
	WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(explicitwaitduration));
	obj.until(ExpectedConditions.elementToBeSelected(element));
}
	public void waituntilvisibilityofwebelement(WebDriver driver,WebElement element)
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(explicitwaitduration));
		obj.until(ExpectedConditions.visibilityOf(element));
	}
	public void waituntiltexttobepresent(WebDriver driver,WebElement element,String a)
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(explicitwaitduration));
		obj.until(ExpectedConditions.textToBePresentInElement(element, a));
	}
	public void fluentwait(WebDriver driver,WebElement element)
	{
		FluentWait<WebDriver>wait=new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(fluentwaitduration))
		.pollingEvery(Duration.ofSeconds(fluentintervel))//condition check every 5sec
		.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}



