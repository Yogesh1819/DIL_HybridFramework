package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_Login extends BaseClass
{
	@Test
   public void loginTestCase()
   {
	   LoginPage lp = new LoginPage(driver);
	   lp.setUsernameAndPassword(p.getProperty("Practitioner"), p.getProperty("Password"));
	   lp.clickSigninBtn();
   }
	
}
