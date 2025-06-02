package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import page.Homepage;
import page.Loginpage;

public class Logintest extends Base {
	Loginpage login;
	 Homepage homepage;
 @Test
  public void verifyuserloginwithvalidcreditions() throws IOException
  {
	  
  
   login=new Loginpage(driver);
  /*login.enterusernameonusernamefield("admin");
  login.enterpasswordonpasswordfield("admin");
  login.clickonloginbutton();*/
   homepage=login.loginusingexcel();
  boolean ishomepagelogin=login.ishomepageloaded();
  Assert.assertTrue(ishomepagelogin,Constants.VERIFYLOGINWITHVALIDCREDENTIOL);
  }
 
  
 
@Test
  public void invalidpasswordcrctusername()
  {
	   login=new Loginpage(driver);
	 login.enterpasswordonpasswordfield("karol");
	  login.enterusernameonusernamefield("admin");
	  login.clickonloginbutton();
	  boolean alertpresent=login.isalertpresent();
	 Assert.assertTrue(alertpresent, "notlogin");
	  
  }
  @Test
  public void validpassincrtusername()
  {
	  Loginpage login=new Loginpage(driver);
	  login.enterusernameonusernamefield("admin");
	  login.enterpasswordonpasswordfield("bjhn");
	  login.clickonloginbutton();
	  boolean alertpresnt=login.isalertpresent();
	  Assert.assertTrue(alertpresnt, "notlogin"); 
  }

 @Test(dataProvider="incorrectmethod")
 public void invalidpassanduser(String username,String password)
 {
 Loginpage login=new Loginpage(driver);
 login.enterpasswordonpasswordfield(password);
 login.enterusernameonusernamefield(username);
 login.clickonloginbutton();
 boolean alertpresent=login.isalertpresent();
 Assert.assertTrue(alertpresent, "notlogin");
}
 @DataProvider
 public Object[][] incorrectmethod()
 {
	  return new Object[][]
			  {{"bunjn","ghbjb"},{"guhn","guh"},{"hbjn","bbjnj"},{"bnnk","bhn"}};
 }}



