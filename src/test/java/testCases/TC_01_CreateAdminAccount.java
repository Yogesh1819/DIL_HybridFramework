package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Admin;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_01_CreateAdminAccount extends BaseClass 
{
	@Test(priority=1)
	public void createAdminAccount() throws InterruptedException
	{
		LoginPage hp = new LoginPage(driver);
		hp.setUsernameAndPassword(p.getProperty("DILAdmin"), p.getProperty("Password"));
	    hp.selectGlobalOrg();
		hp.selectDilAdminRole();
		hp.selectHCCWnTestOrg();
		hp.lockMenuPanel();
		
		Admin adminacc=new Admin(driver);
		adminacc.clickAccountSelectAdmin();
		adminacc.createAdmin("Ian", "Bell", "7445662318", "ianbell@gmail.com");
		String popup=adminacc.adminCreatePopup();
		
		if(popup.equals("Admin is created successfully."))
		{
			System.out.println("Admin account is created..");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Admin account is not created..");
			Assert.assertTrue(false);
		}
		
	
	}
	
	@Test(priority=2)
	public void updateAdminAccount() throws InterruptedException
	{
		Thread.sleep(2000);
		Admin updateAdmin = new Admin(driver);
		updateAdmin.searchAdmin("Ian");
		Thread.sleep(5000);
		updateAdmin.editAdmin();
		updateAdmin.clearField();
		Thread.sleep(3000);
		updateAdmin.updateAdmin("Joe", "Root");
		String popup=updateAdmin.adminUpdatePopup();
		if(popup.equals("Admin is updated successfully."))
		{
			System.out.println("Admin account is updated.");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Admin account is not updated.");
			Assert.assertTrue(false);
		}
	}


}
