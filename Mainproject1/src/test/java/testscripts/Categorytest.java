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
	Loginpage loginpage;
	Category categorypage;
	Homepage homepage;
	
  @Test(groups="smoke")
  public void categorydetailsadding() throws AWTException, IOException
  {
	   loginpage=new Loginpage(driver);
	   homepage=loginpage.loginusingexcel();
	   categorypage=homepage.clickonmanagecategory().categoryactions("phones");
	 
	  boolean categorycreated=categorypage.savealertpresent();
	  Assert.assertTrue(categorycreated,Constants.CATEGORY_CREATION);
  }  
@Test	  
  public void editcategorydetails() throws IOException
  {
	 loginpage=new Loginpage(driver);
	 homepage=loginpage.loginusingexcel();
	  
	  categorypage= homepage.clickonmanagecategory().editcategory().update(); 
	  
	 boolean alertpresent=categorypage.imagedeletedalertpresent();
	 Assert.assertTrue(alertpresent,Constants.CATEGORY_EDIT);
	
	 
  }
@Test
public void statusediting() throws IOException
{
 loginpage=new Loginpage(driver);
 homepage=loginpage.loginusingexcel();

 categorypage=homepage.clickonmanagecategory().statusedit(); 

boolean alertpresent=categorypage.statusapdate();
Assert.assertTrue(alertpresent,Constants.CATEGORY_STATUSUPDATE);
}
@Test
public void elementsearchsincategory() throws IOException
{
	 loginpage=new Loginpage(driver);
	 homepage=loginpage.loginusingexcel();
	
	 categorypage=homepage.clickonmanagecategory(); 
	
	boolean present=categorypage.search("toys");
	Assert.assertTrue(present,Constants.CATEGORY_SEARCH);
	
}
@Test
public void elementsearchfornotfoundelement() throws IOException
{
	 loginpage=new Loginpage(driver);
	 homepage=loginpage.loginusingexcel();
	
	 categorypage=homepage.clickonmanagecategory(); 
	
	boolean present= categorypage.search("lipstick");
	Assert.assertFalse(false,Constants.CATEGORY_NOTELEMENTSEARCH);
	
}
}
