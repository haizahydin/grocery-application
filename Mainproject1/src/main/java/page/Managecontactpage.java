package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.PhoneNumber;

import utilities.Fakerutility;
import utilities.Generalutilities;

public class Managecontactpage

{
	public WebDriver driver;
	Fakerutility fakerutilityobj=new Fakerutility();
	Generalutilities general=new Generalutilities();
	public Managecontactpage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);//initialise web elements ,pagefactory is  a class
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")WebElement editbutton;
	@FindBy(xpath="//input[@id='phone']")WebElement phonefield;
	@FindBy(xpath="//input[@id='email']")WebElement emailid;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")WebElement address ;
	@FindBy(xpath="//textarea[@name='del_time']")WebElement deliverytime;
	@FindBy(xpath="//input[@id='del_limit']")WebElement deliverychargelimit ;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement update  ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
public void contactupdate()
{
	editbutton.click();


	
	phonefield.clear();
	
	String phone=fakerutilityobj.generatephonenum();
	phonefield.sendKeys(phone);
	emailid.clear();
	String mail=fakerutilityobj.email();
	emailid.sendKeys(mail);
	address.clear();
	String adress=fakerutilityobj.address();
	address.sendKeys(adress);
	deliverytime.clear();
	deliverytime.sendKeys("10");
	deliverychargelimit.clear();
	deliverychargelimit.sendKeys("30");
	general.clickJavaScriptExecutor(update, driver);
}
public boolean alertpresent()
{
	return alert.isDisplayed();
	
}
	
}
