package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.Homepage;
import page.Loginpage;
import page.Managecontactpage;
import page.Managefoottexterpage;

public class managecontacttest extends Base {
  @Test
  public void contact() throws IOException
  {
	  Loginpage loginpage=new Loginpage(driver);
		loginpage.loginusingexcel();
		Homepage homepage=new Homepage(driver);
		homepage.clickmanagecontact(); 
		 Managecontactpage contact=new  Managecontactpage(driver);
		 contact.contactupdate();
		boolean alertpresent= contact.alertpresent();
		Assert.assertTrue(alertpresent,"not aleret present");
  }
}
