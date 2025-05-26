package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.Homepage;
import page.Loginpage;
import page.Managenewspage;

public class Managenews extends Base {
  @Test
  public void managenews() throws IOException
  {
	  Loginpage loginpage=new Loginpage(driver);
		loginpage.loginusingexcel();
		Homepage homepage=new Homepage(driver);
		homepage.managenews();
		Managenewspage managenews=new Managenewspage(driver);
		managenews.managenews();
		boolean present=managenews.alertpresent();
		Assert.assertTrue(present, "notpresent");
		
  }
  @Test
  public void managenewsdelete() throws IOException
  {
	  Loginpage loginpage=new Loginpage(driver);
		loginpage.loginusingexcel();
		Homepage homepage=new Homepage(driver);
		homepage.managenews();
		Managenewspage managenews=new Managenewspage(driver);
		managenews.delete();
		managenews.alertpresentafterdelete();
		
  }
  @Test
  public void search() throws IOException
  {
	  Loginpage loginpage=new Loginpage(driver);
		loginpage.loginusingexcel();
		Homepage homepage=new Homepage(driver);
		homepage.managenews();
		Managenewspage managenews=new Managenewspage(driver);
		managenews.searchnews("hello");
		boolean presentnews=managenews.searchnews("hello");
		Assert.assertTrue(presentnews, "not found");
  }
}
