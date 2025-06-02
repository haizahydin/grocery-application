package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import page.Homepage;
import page.Loginpage;
import page.Managefoottexterpage;

public class Managefoottexttest extends Base
{
	Loginpage loginpage;
	Homepage homepage;
	Managefoottexterpage managefoottextpage;
	
  @Test
  public void foottext() throws IOException {
	   loginpage=new Loginpage(driver);
	   homepage=loginpage.loginusingexcel();
		
	   managefoottextpage=homepage.footexter().managefootpageinfrmtnupdate();
		
		boolean alertpresent= managefoottextpage.alert();
		 Assert.assertTrue(alertpresent,Constants.FOOTTEXT_FOOTTEXTALERT);
  }
}
