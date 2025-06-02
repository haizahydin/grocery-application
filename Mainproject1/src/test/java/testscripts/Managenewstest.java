package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import page.Homepage;
import page.Loginpage;
import page.Managenewspage;

public class Managenewstest extends Base {
	Loginpage loginpage;
	Homepage homepage;
	Managenewspage managenewspage;
  @Test
  public void managenews() throws IOException
  {
	   loginpage=new Loginpage(driver);
	   homepage=loginpage.loginusingexcel();
		
	   managenewspage=homepage.managenews().managenewseditandupdate();
		
		boolean present=managenewspage.alertpresent();
		Assert.assertTrue(present,Constants.MANAGENEWS_ADDING);
		
  }
  @Test
  public void managenewsdelete() throws IOException
  {
	 loginpage=new Loginpage(driver);
	 homepage=loginpage.loginusingexcel();
		
	 managenewspage=homepage.managenews().managenewsdelete();
		
		boolean alert=managenewspage.alertpresentafterdelete();
		Assert.assertTrue(alert,Constants.MANAGENEWS_DELETE);
  }
  @Test
  public void search() throws IOException
  {
	   loginpage=new Loginpage(driver);
	   homepage=loginpage.loginusingexcel();
		
	   managenewspage=homepage.managenews();
		
		
		boolean presentnews=managenewspage.managenewssearchnews("hello");
		Assert.assertTrue(presentnews,Constants.MANAGENEWS_SEARCH);
  }
}
