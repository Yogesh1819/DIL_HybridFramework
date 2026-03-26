package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_01_DilAdmin_Login extends BaseClass 
{
    @Test(groups= {"Sanity"})
	public void dilAdminLogin() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
	//	lp.setUsernameAndPassword("test1diladmin1@arthtechltd.com", "Pass@123");
		lp.setUsernameAndPassword(p.getProperty("DILAdmin"), p.getProperty("Password"));
		Thread.sleep(3000);
		lp.selectGlobalOrg();
		Thread.sleep(3000);
		lp.selectDilAdminRole();
		Thread.sleep(3000);
		lp.selectHCCWnTestOrg();
		Thread.sleep(3000);
		lp.lockMenuPanel();
		Thread.sleep(3000);
		lp.logout();
	}
    
    @Test(groups= {"Sanity"})
    public void practitionerLogin() throws InterruptedException
    {
    	
    	LoginPage lp=new LoginPage(driver);
	//	lp.setUsernameAndPassword("wntest1practitioner1@arthtechltd.com", "Pass@123");
    	lp.setUsernameAndPassword(p.getProperty("Practitioner"), p.getProperty("Password"));
		//lp.selectPractitionerRole();
		lp.lockMenuPanel();
		lp.logout();
    }
}
