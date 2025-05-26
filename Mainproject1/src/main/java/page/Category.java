package page;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.Fileuploadutility;
import utilities.Generalutilities;

public class Category
{
public WebDriver driver;

Fileuploadutility obj=new  Fileuploadutility();
Generalutilities general=new Generalutilities();
	public Category(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);//initialise web elements ,pagefactory is  a class
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
	@FindBy(xpath="//input[@id='category']")WebElement categoryfield;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement discound;
	@FindBy(xpath="//input[@id='main_img']")WebElement filechoosing;
	@FindBy(xpath="//button[@type='submit']")WebElement save;
	@FindBy(xpath="//input[@ value='yes'and @name='top_menu']")WebElement showontop;
	@FindBy(xpath="//input[@value='yes' and @name='show_home']")WebElement showonleft;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement aleret;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement edit;
	@FindBy(xpath="//span[@class='fas fa-trash-alt']")WebElement delete;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement deletealertpresent;
	@FindBy(xpath="//button[@name='update']")WebElement update;
	@FindBy(xpath="//span[text()='Active']")WebElement status;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertafteredit;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search;
	@FindBy(xpath="//input[@placeholder='Category']")WebElement categoryname;
	@FindBy(xpath="//button[@name='Search']")WebElement searchbuttonafterentername;
	@FindBy(xpath="//a[@href='http://groceryapp.uniqassosiates.com/admin/Category/index?un=toys&Search=sr&page_ad=1']")WebElement elementpresent;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")WebElement notfound;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")List<WebElement> name;
	

public void categoryactions(String categoryname) throws AWTException
{
	newbutton.click();
	categoryfield.sendKeys(categoryname+general.generateCurrentDateAndTime());
	discound.click();
	String filepath=Constants.CATEGORY_IMAGE;
obj.fileuploadingusingsend(filechoosing,filepath);

//showontop.click();
//showonleft.click();
//general.scrollbyverticala(driver);
general.clickJavaScriptExecutor(save, driver);

}
public boolean savealertpresent()
{
	return aleret.isDisplayed();
}
public void editcategory()
{
edit.click();
delete.click();
driver.switchTo().alert().accept();


}
public boolean imagedeletedalertpresent()
{
	return deletealertpresent.isDisplayed();
}
public void update()
{
general.clickJavaScriptExecutor(update, driver);
}
public void statusedit()
{
	status.click();	
}
public boolean statusapdate()
{
	return alertafteredit.isDisplayed();
}
//table
public boolean search(String input)
{
	search.click();
	
	categoryname.sendKeys(input);
	searchbuttonafterentername.click();
	

		
	
			//String input=a;
			
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
			
}}