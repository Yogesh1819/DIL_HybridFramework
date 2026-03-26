package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Admin extends BasePage 
{

	public Admin(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//p[text()='Accounts']")
	WebElement Accounts;
	
	@FindBy(xpath="//p[text()='Admins']")
	WebElement Admins;
	
	@FindBy(name="search")
	WebElement search;
	
	@FindBy(name="pencilIcon")
	WebElement editBtn;
	
	@FindBy(name="newButton")
	WebElement newBtn;
	
	@FindBy(name="firstName")
	WebElement Fname;
	
	@FindBy(name="lastName")
	WebElement Lname;
	
	@FindBy(name="contactNumber")
	WebElement contact;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="save")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[text()='Admin is created successfully.']")
	WebElement adminCreatePopup;
	
	@FindBy(xpath="//div[text()=\"Admin is updated successfully.\"]")
	WebElement adminUpdatePopup;
	
	@FindBy(xpath="//div[text()='Admin deleted successfully.']")
	WebElement adminDeletePopup;
	
	
	public void clickAccountSelectAdmin()
	{
	    Accounts.click();
	    Admins.click();
	    newBtn.click();
	}
	
	public void createAdmin(String firstname,String lastname,String contactnumber,String Email)
	{
		
		Fname.sendKeys(firstname);
		Lname.sendKeys(lastname);
		contact.sendKeys(contactnumber);
		email.sendKeys(Email);
		saveBtn.click();
	}
	
	public String adminCreatePopup()
	{
		String admincreate=adminCreatePopup.getText();
		return admincreate;
	}
	
	public void searchAdmin(String adminemail)
	{
		search.sendKeys(adminemail);
	}
	
	public void editAdmin()
	{
		editBtn.click();
	}
	
	public void updateAdmin(String upfirstname,String uplastname)
	{
		Fname.sendKeys(upfirstname);
		Lname.sendKeys(uplastname);
		saveBtn.click();	
	}
	
	public String adminUpdatePopup()
	{
		String adminupdated=adminUpdatePopup.getText();
		return adminupdated;
	}
	
	public String adminDeletedPopup()
	{
		String admindeleted=adminDeletePopup.getText();
		return admindeleted;	
	}
	
	public void clearField()
	{
		Fname.clear();
		Lname.clear();
	}
}
