package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage 
{
	public WebDriver driver;
	public  LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement signinBtn;
	
	@FindBy(xpath="//h6[text()='Global']/parent::div/parent::div/child::div[2]/child::button")
    WebElement globalOrganisation;
	
	@FindBy(xpath="//h6[text()='DIL-Test-01']/parent::div/parent::div/child::div[2]/child::button")
	WebElement dilTestOrganisation;
	
	@FindBy(xpath="//h6[text()='Hertfordshire County Council']/parent::div/parent::div/child::div[2]/child::button")
	WebElement HCCOrganisation;
	
	@FindBy(xpath="//h6[text()='HCC-Waking Night Test']/parent::div/parent::div/child::div[2]/child::button")
	WebElement HCCWNTestorganisation;
	
	@FindBy(xpath="//h6[text()='HCC Waking Night']/parent::div/parent::div/child::div[2]/child::button")
	WebElement HCCWNOrganisation;
	
	@FindBy(xpath="//h6[text()='DIL Admin']/parent::div/parent::div/child::div[2]/child::button")
	WebElement role_DILAdmin;
	
	@FindBy(xpath="//h6[text()='Network Manager']/parent::div/parent::div/child::div[2]/child::button")
	WebElement role_NetworkManager;
	
	@FindBy(xpath="//h6[text()='Inventory Manager']/parent::div/parent::div/child::div[2]/child::button")
	WebElement role_InventoryManager;
	
	@FindBy(xpath="//h6[text()='Factory Worker']/parent::div/parent::div/child::div[2]/child::button")
	WebElement role_FactoryWorker;
	
	@FindBy(xpath="//h6[text()='Vendor']/parent::div/parent::div/child::div[2]/child::button")
	WebElement role_Vendor;
	
	@FindBy(xpath="//h6[text()='Site Manager']/parent::div/parent::div/child::div[2]/child::button")
	WebElement role_SiteManager;
	
    @FindBy(xpath="//h6[text()='Site Operator']/parent::div/parent::div/child::div[2]/child::button")
	WebElement role_SiteOperator;
    
    @FindBy(xpath="//h6[text()='Installer']/parent::div/parent::div/child::div[2]/child::button")
    WebElement role_Installer;
    
    @FindBy(xpath="//h6[text()='Practitioner']/parent::div/parent::div/child::div[2]/child::button")
    WebElement role_Practitioner;
    
    @FindBy(xpath="//h6[text()='Org Admin']/parent::div/parent::div/child::div[2]/child::button")
    WebElement role_OrgAdmin;
    
   // @FindBy(xpath="//label[text()='Select Organisation']/parent::div/parent::div/child::div/child::label")
    @FindBy(xpath="//div[@aria-labelledby=\"global-org-select-label\"]")
    WebElement orgSelectDropdown;
    
    @FindBy(xpath="//p[text()='HCC Waking Night']")
    WebElement org_HCCWN;
    
    @FindBy(xpath="//p[text()='DIL-Test-01']")
    WebElement org_DilTest;
    
    @FindBy(xpath="//p[text()='HCC-Waking Night Test']")
    WebElement org_HCCWNTest;
    
    @FindBy(xpath="//p[text()='Hertfordshire County Council']")
    WebElement org_HCC;
    
    @FindBy(xpath="//button[text()='Continue']")
    WebElement continueBtn;
    
    @FindBy(xpath="(//p[text()='Home'])[2]")
    WebElement homeBtn;
    
    @FindBy(xpath="//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1zbqai\"]")
    WebElement lock;
    
    @FindBy(xpath="//button[text()='Logout']")
    WebElement logout;
    
    @FindBy(name="createANewReferral")
    WebElement Refbtn;
    
    @FindBy(name="allResidents")
    WebElement allResident;
    
    
    public void setUsernameAndPassword(String user,String pwd)
    {
    	username.sendKeys(user);
    	password.sendKeys(pwd);
    	signinBtn.click();
    }
    
    public void setUsernamePassword(String user1,String pwd1)
    {
    	username.sendKeys(user1);
    	password.sendKeys(pwd1);
    
    }
    public void clickSigninBtn()
    {
    	signinBtn.click();
    }
    
    
    public void selectGlobalOrg()
    {
    	globalOrganisation.click();
    }
    
    public void selectHCCWNTestOrg()
    {
    	HCCWNTestorganisation.click();
    }
    
    public void selectDilAdminRole()
    {
    	role_DILAdmin.click();
    }
    
    public void selectNMRole()
    {
    	role_NetworkManager.click();
    }
    
    public void selectIMRole()
    {
    	role_InventoryManager.click();
    }
    
    public void selectFWRole()
    {
    	role_FactoryWorker.click();
    }
    
    public void selectVendorRole()
    {
    	role_Vendor.click();
    }
    
    public void selectSMRole()
    {
    	role_SiteManager.click();
    }
    
    public void selectSORole()
    {
    	role_SiteOperator.click();
    }
    
    public void selectOrgAdminRole()
    {
    	role_OrgAdmin.click();
    }
    
    public void selectInstallerRole()
    {
    	role_Installer.click();
    }
    
    public void selectPractitionerRole()
    {
    	role_Practitioner.click();
    }
    
 
    public void selectDilOrg() throws InterruptedException
    {
    	orgSelectDropdown.click();
    	Thread.sleep(2000);
    	org_DilTest.click();
    	Thread.sleep(2000);
    	continueBtn.click();
    }
    
    public void selectHCCWnTestOrg() throws InterruptedException
    {
    	orgSelectDropdown.click();
    	Thread.sleep(2000);
    	org_HCCWNTest.click();
    	Thread.sleep(2000);
    	continueBtn.click();
    }
    
    public void lockMenuPanel() throws InterruptedException
    {
    	homeBtn.click();
    	Thread.sleep(3000);
    	lock.click();
    }
    
    public void logout()
    {
    	logout.click();
    }
    
    public void clearField()
    {
    	username.click();
    	username.clear();
    	password.click();
    	password.clear();
    }
    
    public boolean verifyRefBtn()
    {
    	boolean refbuttonstatus=Refbtn.isDisplayed();
    	return refbuttonstatus;
    }
    
    public boolean verifyResidnetsBtn()
    {
    	boolean allResidentBtnStatus=allResident.isDisplayed();
    	return allResidentBtnStatus;
    }
}
