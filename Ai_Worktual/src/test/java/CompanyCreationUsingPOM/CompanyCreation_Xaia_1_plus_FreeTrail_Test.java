package CompanyCreationUsingPOM;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import CompanyCreation.Extras;

public class CompanyCreation_Xaia_1_plus_FreeTrail_Test {
	WebDriver driver;
	Worktual_Home_Page homePage;
	purchaseflow_ContactCenter_FreeTrail purchaseForm;
	
	@BeforeClass()
	@Parameters({"browser"})
	public void setUp(String value) {
		switch(value) {
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver(); break;
		default :System.out.println("invalid");return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://worktual.co.uk/");
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void test_navigate_To_Xaia3plus_freeTrail() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//accessing home page POM Class
		homePage = new Worktual_Home_Page(driver);
		homePage.navigate_to_Xaia1plus_Freetrial();
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void test_CopyEmail() throws InterruptedException, UnsupportedFlavorException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//opening new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://temp-mail.org/en/");
		Thread.sleep(10000);
		
		//mail id element
		WebElement tempmail = driver.findElement(By.xpath("//button[@class='btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']"));
		tempmail.click();
	}
	@Test(priority=3, dependsOnMethods= {"test_navigate_To_Xaia3plus_freeTrail"})
	public void test_Form() throws UnsupportedFlavorException, IOException{
		//return Back to form
		Set<String> windowIdsSet = driver.getWindowHandles();
    	List<String> windowIdsList = new ArrayList<String>(windowIdsSet);
    	
    	driver.switchTo().window(windowIdsList.get(0));
    	
    	String url = "https://worktual.co.uk/ccaas_pricing/purchaseflow/freetrial_companydetails/";
    	if(driver.getCurrentUrl().equals(url)) {
		
			//accessing purchaseflow_Xaia3plus_FreeTrail POM class
			purchaseForm = new purchaseflow_ContactCenter_FreeTrail(driver);
			purchaseForm.setFname(Extras.firstNameGenerator());
			purchaseForm.setLname(Extras.lastNameGenerator());
			purchaseForm.setEmail(Extras.getEmailContent(driver));
			purchaseForm.setPhone(""+Extras.mobileNumberGenerator());
			purchaseForm.setCompanyName("WtTest");
			purchaseForm.setNoOfUsers("10");
			purchaseForm.clicking_CheckBox();
			purchaseForm.clickContinue();
    	}
		
	}
	@Test(priority=4, dependsOnMethods= {"test_Form"})
	public void test_Password() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		purchaseForm.setPassword("Worktual@123");
		purchaseForm.clickSignUp();
		
		Thread.sleep(50000);
		String expectedUrl = "https://myaccount.worktual.co.uk/verify_email";
		
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
//		wait.until(ExpectedConditions.urlToBe(expectedUrl));
	
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		
	}

}
