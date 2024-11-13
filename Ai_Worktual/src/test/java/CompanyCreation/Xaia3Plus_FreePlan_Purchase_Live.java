package CompanyCreation;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Xaia3Plus_FreePlan_Purchase_Live{
	WebDriver driver;
	WebDriverWait wait;
	@Test(priority=0)
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://worktual.co.uk/");
		driver.manage().window().maximize();
	}
	@Test(priority=1, dependsOnMethods= {"setUp"})
	public void test_Purchase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[text()='Pricing' and @class=\"nav-link nav-link\"]")).click();
		
		//contact centre
		driver.findElement(By.xpath("//a[text()='Contact Centre' and @class=\"nav-link\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='pricingHome_plansection__3oh_0 pricingHome_plansectioncontactcenter__1ozXD']//div[3]//div[1]//div[2]//a[1]")).click();
		
	}
	@Test(priority=2, dependsOnMethods= {"test_Purchase"})
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
	@Test(priority=3, dependsOnMethods= {"test_CopyEmail"})
	public void test_FormFreeTrail() throws InterruptedException, UnsupportedFlavorException, IOException   {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//return Back to worktual.co.uk
		Set<String> windowIdsSet = driver.getWindowHandles();
    	List<String> windowIdsList = new ArrayList(windowIdsSet);
    	
    	driver.switchTo().window(windowIdsList.get(0));
    	
    	String url = "https://worktual.co.uk/ccaas_pricing/purchaseflow/freetrial_companydetails/";
    	if(driver.getCurrentUrl().equals(url)) {
    		//form
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    		driver.findElement(By.id("fname")).sendKeys(Extras.firstNameGenerator());
    		driver.findElement(By.id("lname")).sendKeys(Extras.lastNameGenerator());
    		driver.findElement(By.id("email")).sendKeys(Extras.getEmailContent(driver));
    		driver.findElement(By.id("contact_phone")).sendKeys(""+Extras.mobileNumberGenerator());
    		driver.findElement(By.id("company_name")).sendKeys("WtTest");
    		driver.findElement(By.id("noofUser")).sendKeys("10");
    		
    		//check boxes
    		driver.findElement(By.xpath("(//span[@class='checkmark'])[1]")).click();
    		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
    		
    		//continue
    		driver.findElement(By.xpath("//button[text()='Continue ']")).click();
    	}
    	
	}
	
	@Test(priority=4, dependsOnMethods= {"test_FormFreeTrail"})
	public void test_Password() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("password")).sendKeys("Vectone@123");
		driver.findElement(By.xpath("//button[text()='Complete trial signup']")).click();
		
	}
	//----------------------------------------------------------------------------------------------------------
	public void g_loginToCcaaS() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//switch to email id for login
		Set<String> windowIdsSet ;
		windowIdsSet = driver.getWindowHandles();
		
    	List<String> windowIdsList;
    	windowIdsList = new ArrayList(windowIdsSet);
    	driver.switchTo().window(windowIdsList.get(1));
    	
    	
    	//login
    	
    	driver.findElement(By.xpath("//a[contains(text(),'Welcome to Worktual.')]")).click();
    	driver.findElement(By.xpath("//a[@href=\"https://ccaas.worktual.co.uk/\"]")).click();
    	
    	//switch to CcaaS
    	windowIdsSet = driver.getWindowHandles();
    	windowIdsList = new ArrayList(windowIdsSet);
    	
    	String expectedTitle = "Worktual Contact Centre";
    	for(int i=0;i<windowIdsList.size();i++) {
    		driver.switchTo().window(windowIdsList.get(i));
    		
    		if(driver.getTitle().equals(expectedTitle)) {
    			
    			//setUpLater
    			driver.findElement(By.xpath("//span[text()='Set up later ']"));
    			driver.findElement(By.xpath("//button[text()='Skip tour ']")).click();
    			driver.findElement(By.xpath("//li[text()='My Account']")).click();
    		}
    	}
	}
	public void f_UserManagement() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='User Management']")).click();
		driver.findElement(By.xpath("//a[text()='Users']")).click();
		
		//add users
		driver.findElement(By.id("react-aria3024405208-6")).click();
		driver.findElement(By.xpath("//a[text()='Add User ']")).click();
	}
	public void g_addUserForm() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@placeholder=\"Enter First Name\"]")).sendKeys("Supervisor");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Last Name\"]")).sendKeys("One");
		driver.findElement(By.xpath("")).sendKeys("sebif24516@carspure.com");
		
		//Role 
		WebElement roleCheckBox = driver.findElement(By.xpath("//select[@name=\"organisationRole\"]"));
		Select role = new Select(roleCheckBox);
		role.selectByVisibleText("Supervisor");
		
		//company info
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Employee ID\"]")).sendKeys("002");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Job title\"]")).sendKeys("Supervisor");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter department\"]")).sendKeys("CcaaS");
		
		
		//reporting to
		WebElement reportingToCheckBox = driver.findElement(By.xpath("//select[@name=\"report\"]"));
		Select reportingTo = new Select(reportingToCheckBox);
		reportingTo.selectByValue("200");
		
		
		//personal info
		driver.findElement(By.xpath("//input[@placeholder=\"Enter phone number\"]")).sendKeys("9191784738272");
		driver.findElement(By.xpath("//button[text()='Create User']")).click();
	}
}
