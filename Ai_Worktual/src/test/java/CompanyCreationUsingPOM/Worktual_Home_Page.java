package CompanyCreationUsingPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Worktual_Home_Page {
	WebDriver driver;
	
	//constructors
	Worktual_Home_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="(//a[text()='Pricing'])[1]") WebElement pricingLink;
	@FindBy(xpath="(//a[text()='Contact Centre'])[1]") WebElement contactCentreLink;
	@FindBy(xpath="(//a[@class=\"buttonaction onlyfullborder\"])[3]") WebElement xaia3plus_30dayFreetrail;
	@FindBy(xpath="(//a[@class=\"buttonaction onlyfullborder\"])[2]") WebElement xaia2plus_30dayFreetrail;
	@FindBy(xpath="(//a[@class=\"buttonaction onlyfullborder\"])[1]") WebElement xaia1plus_30dayFreetrail;
	
	//Action Methods
	public void navigate_to_Xaia3plus_Freetrial() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		pricingLink.click();
		Thread.sleep(1000);
		contactCentreLink.click();
		Thread.sleep(1000);
		xaia3plus_30dayFreetrail.click();
	}
	public void navigate_to_Xaia2plus_Freetrial() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		pricingLink.click();
		Thread.sleep(1000);
		contactCentreLink.click();
		Thread.sleep(1000);
		xaia2plus_30dayFreetrail.click();
	}
	public void navigate_to_Xaia1plus_Freetrial() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		pricingLink.click();
		Thread.sleep(1000);
		contactCentreLink.click();
		Thread.sleep(1000);
		xaia1plus_30dayFreetrail.click();
	}
}
