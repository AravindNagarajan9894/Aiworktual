package AssignUsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormPage {
	WebDriver driver;
	
	FormPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//add user form

	@FindBy(xpath="//input[@placeholder='Enter First Name']") WebElement fname_txt_fld;
	@FindBy(xpath="//input[@placeholder='Enter Last Name']") WebElement lname_txt_fld;
	@FindBy(xpath="//input[@placeholder='Enter Email Address']") WebElement emailadd_txt_fld;
	@FindBy(xpath="//select[@name='organisationRole']") WebElement role_drp_dwn;
	
	
	//form methods
	public void setFname(String fname) {
		fname_txt_fld.sendKeys(fname);
		
	}
	public void setLname(String lname) {
		lname_txt_fld.sendKeys(lname);
	}
	public void setEmailadd(String email) {
		emailadd_txt_fld.sendKeys(email);
	}
	public void setRoleAsAdmin() {
		Select roles = new Select(role_drp_dwn);
		roles.selectByVisibleText("Admin");
	}
	public void setRoleAsSupervisor() {
		Select roles = new Select(role_drp_dwn);
		roles.selectByVisibleText("Supervisor");
	}
	public void setRoleAsAgent() {
		Select roles = new Select(role_drp_dwn);
		roles.selectByVisibleText("Agent");
	}
	
		
}
