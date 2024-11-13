package CompanyCreationUsingPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class purchaseflow_ContactCenter_FreeTrail {
	
	WebDriver driver;
	
	//constructor
	purchaseflow_ContactCenter_FreeTrail(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	//form page
	
	//@FindBy(xpath="xpathvalue") WebElement
	@FindBy(xpath="//input[@id='fname']") WebElement fname_txt_fld;
	@FindBy(xpath="//input[@id='lname']") WebElement lname_txt_fld;
	@FindBy(xpath="//input[@id='email']") WebElement email_txt_fld;
	@FindBy(xpath="//input[@id='contact_phone']") WebElement phone_txt_fld;
	@FindBy(xpath="//input[@id='company_name']") WebElement companyName_txt_fld;
	@FindBy(xpath="//input[@id='noofUser']") WebElement noOfUser_txt_fld;
	@FindBy(xpath="(//span[@class=\"checkmark\"])[1]") WebElement consent_checkbox;
	@FindBy(xpath="(//span[@class=\"checkmark\"])[2]") WebElement settingUp_checkbox;
	@FindBy(xpath="//button[text()='Continue ']") WebElement continue_btn;
	
	//password page
	@FindBy(xpath="//input[@id='password']") WebElement password_txt_fld;
	@FindBy(xpath="//button[normalize-space()='Complete trial signup']") WebElement signUp_btn;
	
	//Action Methods
	//form page
	public void setFname(String value) {
		fname_txt_fld.sendKeys(value);
	}
	public void setLname(String value) {
		lname_txt_fld.sendKeys(value);
	}
	public void setEmail(String value) {
		email_txt_fld.sendKeys(value);
	}
	public void setPhone(String value) {
		phone_txt_fld.sendKeys(value);
	}
	public void setCompanyName(String value) {
		companyName_txt_fld.sendKeys(value);
	}
	public void setNoOfUsers(String value) {
		noOfUser_txt_fld.sendKeys(value);
	}
	public void clicking_CheckBox() {
		consent_checkbox.click();
		settingUp_checkbox.click();
	}
	public void clickContinue() {
		continue_btn.click();
	}
	
	//password page
	public void setPassword(String value) {
		password_txt_fld.sendKeys(value);
	}
	public void clickSignUp() {
		signUp_btn.click();
	}
}
