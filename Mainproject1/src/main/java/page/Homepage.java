package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage
{
public WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);//initialise web elements ,pagefactory is  a class
	}
	@FindBy(xpath="//p[text()='Manage Category']")WebElement managecategory;
	@FindBy(xpath="//p[text()='Manage Contact']")WebElement managecontact;
	@FindBy(xpath="//p[text()='Manage Footer Text']")WebElement foottexter;
	@FindBy(xpath="//p[text()='Manage News']")WebElement managenews;
	public void clickonmanagecategory()
	{
		 managecategory.click();
	}
	public void clickmanagecontact()
	{
		managecontact.click();
	}
	public void footexter()
	{
		foottexter.click();
	}
	public void managenews()
	{
		managenews.click();
	}
	

}
