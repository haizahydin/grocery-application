package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Managenewspage
{
	
		public WebDriver driver;
			
			public Managenewspage (WebDriver driver)
			{
			this.driver=driver;
			PageFactory.initElements(driver,this);
			}
			@FindBy(xpath="//i[@class='fas fa-edit']")WebElement edit  ;
			@FindBy(xpath="//textarea[@id='news']")WebElement newsfield ;
			@FindBy(xpath="//button[@class='btn btn-danger']")WebElement update;
			@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
			@FindBy(xpath="//i[@class='fas fa-trash-alt']")WebElement deletebutton;
			@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertafterdelete;
			@FindBy(xpath="//a[@href='javascript:void(0)']")WebElement search;
			@FindBy(xpath="//input[@placeholder='Title']")WebElement title;
			@FindBy(xpath="//button[@type='submit']")WebElement searchafter;
			@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")List<WebElement> name;
			
public Managenewspage  managenewseditandupdate()
{
	edit.click();
	newsfield.clear();
	newsfield.sendKeys("new product launch");
	update.click();
	return this;
	
}
public boolean alertpresent()
{
return alert.isDisplayed();
}
public  Managenewspage managenewsdelete()
{
	deletebutton.click();
	driver.switchTo().alert().accept();
	return this;
}
public boolean alertpresentafterdelete()
{
	return alertafterdelete.isDisplayed();
}
public boolean managenewssearchnews(String input)
{
	search.click();
	title.clear();
	title.sendKeys(input);

	searchafter.click();
	int flag=0;
	for(WebElement names:name)
	{
		if(names.getText().equalsIgnoreCase(input));
		{
			//System.out.println(names.getText());
			flag=1;
			
			break;
		}
		
	}
	if(flag==1)
	{
		return true;
		
	}
	else
	{
	return false;
	}
}
}
