package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Fakerutility;

public class Managefoottexterpage {
	public WebDriver driver;
	Fakerutility fakerutilityobj=new Fakerutility();
	
	public Managefoottexterpage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);//initialise web elements ,pagefactory is  a class
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement edit;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")WebElement address ;
	@FindBy(xpath="//input[@id='email']")WebElement email ;
	@FindBy(xpath="//input[@name='phone']")WebElement phone ;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement  update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert ;

public void foottexter()
{
	edit.click();
	address.clear();
	address.sendKeys("bjunjnjnj");
	email.clear();
	email.sendKeys("sdsd@gmail.com");
	phone.clear();
	phone.sendKeys("6546146");
	update.click();
	
	
}
public boolean alert() {
	return alert.isDisplayed();
}
}
