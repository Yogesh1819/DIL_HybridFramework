package testCases;

import org.testng.annotations.Test;

import pageObjects.Admin;
import testBase.BaseClass;

public class TC_01_UpdateAdminAccount extends BaseClass
{
	@Test
	public void updateAdminAccount() throws InterruptedException
	{
		Admin updateAdmin = new Admin(driver);
		updateAdmin.searchAdmin("Ian");
		Thread.sleep(4000);
		updateAdmin.editAdmin();	
	}

}
