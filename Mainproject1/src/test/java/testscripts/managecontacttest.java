package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import page.Homepage;
import page.Loginpage;
import page.Managecontactpage;
import page.Managefoottexterpage;

public class managecontacttest extends Base {
	Loginpage loginpage;
	Homepage homepage;
	 Managecontactpage managecontactpage;
  @Test
  public void managecontactupdate() throws IOException
  {
	   loginpage=new Loginpage(driver);
	   homepage=loginpage.loginusingexcel();
		
	   managecontactpage=homepage.clickmanagecontact().contactupdate();
		
		 
		boolean alertpresent= managecontactpage.alertpresent();
		Assert.assertTrue(alertpresent,Constants.MANAGECONTACT);
  }
}
