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
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//p[text()='Manage Category']")WebElement managecategory;
	@FindBy(xpath="//p[text()='Manage Contact']")WebElement managecontact;
	@FindBy(xpath="//p[text()='Manage Footer Text']")WebElement foottexter;
	@FindBy(xpath="//p[text()='Manage News']")WebElement managenews;
	public  Category clickonmanagecategory()
	{
		 managecategory.click();
		 return new  Category(driver);
	}
	public  Managecontactpage clickmanagecontact()
	{
		managecontact.click();
		return new  Managecontactpage(driver);
	}
	public Managefoottexterpage footexter()
	{
		foottexter.click();
		return new Managefoottexterpage(driver);
	}
	public  Managenewspage managenews()
	{
		managenews.click();
		return new  Managenewspage(driver);
	}
	

}
