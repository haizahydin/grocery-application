package testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import page.Category;
import page.Homepage;
import page.Loginpage;


public class Categorytest extends Base
{
  @Test
  public void categorydetailsadding() throws AWTException, IOException
  {
	  Loginpage loginpage=new Loginpage(driver);
	  loginpage.loginusingexcel();
	  Homepage homepage=new Homepage(driver);
	  homepage.clickonmanagecategory();
	  
	  Category create=new Category(driver);
	  create.categoryactions("phones");
	  boolean categorycreated=create.savealertpresent();
	  Assert.assertTrue(categorycreated,Constants.CATEGORY_CREATION);
  }  
@Test	  
  public void edit() throws IOException
  {
	Loginpage loginpage=new Loginpage(driver);
	  loginpage.loginusingexcel();
	  Homepage homepage=new Homepage(driver);
	  homepage.clickonmanagecategory(); 
	  Category create=new Category(driver);
	  create.editcategory();
	 boolean alertpresent=create.imagedeletedalertpresent();
	 Assert.assertTrue(alertpresent,Constants.CATEGORY_EDIT);
	 create.update();
	 
  }
@Test
public void statusediting() throws IOException
{
Loginpage loginpage=new Loginpage(driver);
loginpage.loginusingexcel();
Homepage homepage=new Homepage(driver);
homepage.clickonmanagecategory(); 
Category create=new Category(driver);
create.statusedit();
boolean alertpresent=create.statusapdate();
Assert.assertTrue(alertpresent,Constants.CATEGORY_STATUSUPDATE);
}
@Test
public void elementsearchs() throws IOException
{
	Loginpage loginpage=new Loginpage(driver);
	loginpage.loginusingexcel();
	Homepage homepage=new Homepage(driver);
	homepage.clickonmanagecategory(); 
	Category create=new Category(driver);
	boolean present=create.search("toys");
	Assert.assertTrue(present,Constants.CATEGORY_SEARCH);
	
}
@Test
public void elementsearchfornotfoundelement() throws IOException
{
	Loginpage loginpage=new Loginpage(driver);
	loginpage.loginusingexcel();
	Homepage homepage=new Homepage(driver);
	homepage.clickonmanagecategory(); 
	Category create=new Category(driver);
	boolean present=create.search("lipstick");
	Assert.assertFalse(false,Constants.CATEGORY_NOTELEMENTSEARCH);
	
}
}
