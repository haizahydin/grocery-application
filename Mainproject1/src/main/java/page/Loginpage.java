package page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Excelread;


public class Loginpage 
{
	public WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='username']")WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")WebElement passwordfield;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")WebElement loginbutton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	@FindBy(xpath="//nav[@class='main-header navbar navbar-expand navbar-dark navbar-dark']")WebElement homepage;
public void enterusernameonusernamefield(String username)
{
usernamefield.sendKeys(username);	
}
public void enterpasswordonpasswordfield(String password)
{
	passwordfield.sendKeys(password);
	
}
public Homepage clickonloginbutton()
{
	loginbutton.click();
	return new Homepage(driver);
}
public boolean ishomepageloaded()
{
	return homepage.isDisplayed();
}
public boolean isalertpresent()
{
	return alert.isDisplayed();

}
public Homepage loginusingexcel() throws IOException
{
	String username=Excelread.readStringData(1,0,"loginpage");
	String password=Excelread.readStringData(1,1,"loginpage");
	usernamefield.sendKeys(username);
	passwordfield.sendKeys(password);
	loginbutton.click();
	return new Homepage(driver);
}
}
