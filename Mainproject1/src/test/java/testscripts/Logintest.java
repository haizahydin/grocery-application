package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import page.Loginpage;

public class Logintest extends Base {
  @Test
  public void verifyuserloginwithvalidcreditions() throws IOException
  {
	  
  
  Loginpage login=new Loginpage(driver);
  /*login.enterusernameonusernamefield("admin");
  login.enterpasswordonpasswordfield("admin");
  login.clickonloginbutton();*/
  login.loginusingexcel();
  boolean ishomepagelogin=login.ishomepageloaded();
  Assert.assertTrue(ishomepagelogin,Constants.VERIFYLOGINWITHVALIDCREDENTIOL);
  }
 
  
 
  @Test
  public void invalidpasswordcrctusername()
  {
	  Loginpage login=new Loginpage(driver);
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
 @Test
 public void validincrctpassincrtusername()
 {
	  Loginpage login=new Loginpage(driver);
	  login.enterusernameonusernamefield("anknk");
	  login.enterpasswordonpasswordfield("jbjnk");
	  login.clickonloginbutton();
	  boolean alertpresnt=login.isalertpresent();
	  Assert.assertTrue(alertpresnt, "notlogin"); 
 }
}


