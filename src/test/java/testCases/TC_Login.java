package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_Login extends BaseClass
{
	@Test
   public void loginTestCase() throws InterruptedException
   {
	   LoginPage lp = new LoginPage(driver);
	//   lp.setUsernameAndPassword(p.getProperty("Practitioner"), p.getProperty("Password"));
	   lp.setUsernamePassword(p.getProperty("Practitioner"), p.getProperty("Password"));
	   lp.clickSigninBtn();
	   lp.lockMenuPanel();
	   
	   boolean verification=lp.verifyResidnetsBtn();
	   if(verification==true)
	   {
		   System.out.println("Test case is pass..");
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   System.out.println("Test case fail..");
		   Assert.assertTrue(false);
	   }
	   Thread.sleep(4000);
   }
	
}
