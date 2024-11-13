package AssignUsers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyAccount_LoginPage {
	WebDriver driver;
	
	MyAccount_LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	//login page
	@FindBy(xpath="//input[@placeholder='Enter your email address']") WebElement email_txt_fld;
	@FindBy(xpath="//input[@placeholder='Enter your password']") WebElement password_txt_fld;
	@FindBy(xpath="//input[@id='login-button']") WebElement login_btn;
	
	//user management

	@FindBy(xpath="//button[normalize-space()='User Management']") WebElement users_dropdown;
	@FindBy(xpath="//a[normalize-space()='Users']") WebElement users_drpdwn;	
	//@FindBy(xpath="//button[@id='react-aria7856133499-4']") WebElement addUsers_drpdwn;
	
	
	
		
	//action methods
	public void setEmail(String value) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		email_txt_fld.sendKeys(value);
	}
	
	public void setPassword(String value) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		password_txt_fld.sendKeys(value);
	}
	
	public void setEmail_Password_ClickLogin(String email, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		email_txt_fld.sendKeys(email);
		password_txt_fld.sendKeys(password);
		login_btn.click();
	}
	public void navigate_to_users() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		users_dropdown.click();
		users_drpdwn.click();
		Thread.sleep(1000);
		driver.navigate().to("https://myaccount.worktual.co.uk/usermanagement/addUser");
	}
	
	
	
}
