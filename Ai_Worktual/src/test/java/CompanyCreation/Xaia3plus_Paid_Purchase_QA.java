package CompanyCreation;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Xaia3plus_Paid_Purchase_QA {
	WebDriver driver;
	WebDriverWait wait;
	@Test(priority=1)
	public void test_setup() {
		driver = new ChromeDriver();
		driver.get("https://qapricing.qaworktual.co.uk/pricing/#Ccaas");
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	public void test_contactCentre() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//contactcentre
		driver.findElement(By.xpath("(//a[text()='Contact Centre'])[1]")).click();
		Thread.sleep(2000);
		//buynow
		driver.findElement(By.xpath("(//a[@class=\"buttonaction\"])[3]")).click();
	}
	@Test(priority=3)
	public void test_CopyEmail() throws InterruptedException, UnsupportedFlavorException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//opening new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://temp-mail.org/en/");
		//Thread.sleep(10000);
		
		//mail id element
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement tempmail = driver.findElement(By.xpath("//button[@class='btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']"));
		wait.until(ExpectedConditions.visibilityOf(tempmail)).click();
	}
	@Test(priority=4)
	public void test_companydetails() throws UnsupportedFlavorException, IOException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Set<String> windowIdsSet = driver.getWindowHandles();
    	List<String> windowIdsList = new ArrayList(windowIdsSet);
    	
    	driver.switchTo().window(windowIdsList.get(0));	
    	
    	String url = "https://qapricing.qaworktual.co.uk/ccaas_pricing/purchaseflow/companydetails/";
    	if(driver.getCurrentUrl().equals(url)) {
			
			driver.findElement(By.id("fname")).sendKeys(Extras.firstNameGenerator());
			driver.findElement(By.id("lname")).sendKeys(Extras.lastNameGenerator());
			driver.findElement(By.id("email")).sendKeys("test@gmail.com");
			driver.findElement(By.id("company_name")).sendKeys("WtTest");
			driver.findElement(By.id("contact_phone")).sendKeys(""+Extras.mobileNumberGenerator());
			driver.findElement(By.id("postcode")).sendKeys("E145 nr");
			driver.findElement(By.xpath("//a[text()='Find']")).click();
			driver.findElement(By.xpath("//span[@title=\"Select the address\"]")).click();
			driver.findElement(By.xpath("(//div[@class=\"ant-select-item-option-content\"])[3]")).click();
			driver.findElement(By.xpath("//span[@class=\"checkmark\"]")).click();
			driver.findElement(By.xpath("//button[text()='Continue ']")).click();
    	}
	}
	@Test(priority=5)
	public void test_ChooseNumber() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@class=\"ant-select-selection-item\"]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option-content')][normalize-space()='1234 - Bedford']")).click();
		//driver.findElement(By.xpath("//div[@class=\"ant-select-item-option-content\" and text()='Bedford']")).click();
	}
}
