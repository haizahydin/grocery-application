package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import page.Homepage;
import page.Loginpage;
import page.Managefoottexterpage;

public class Foottexttest extends Base{
  @Test
  public void foottext() throws IOException {
	  Loginpage loginpage=new Loginpage(driver);
		loginpage.loginusingexcel();
		Homepage homepage=new Homepage(driver);
		homepage.footexter(); 
		 Managefoottexterpage foottext=new Managefoottexterpage(driver);
		 foottext.foottexter();
		boolean alertpresent= foottext.alert();
		 Assert.assertTrue(alertpresent,Constants.FOOTTEXT_FOOTTEXTALERT);
  }
}
