package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_LoginVerification_Pos_01 extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void loginVerification(String Diluser,String Dilpassword) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
	//	lp.setUsernameAndPassword(Diluser, Dilpassword);
		lp.setUsernamePassword(Diluser, Dilpassword);
		lp.clickSigninBtn();
		try
		{
	//    boolean status=lp.verifyRefBtn();
	    boolean status1=lp.verifyResidnetsBtn();
	    if(status1==true)
	    {
	    	lp.lockMenuPanel();
	    	lp.logout();
	    	System.out.println("Login sucessfully...");
	    	Assert.assertTrue(true);	
	    }
		}
		catch(Exception e)
		{
			lp.clearField();
			System.out.println("Login unsucessfull...");
			Assert.assertTrue(false);
		}
	}

}
