package Worktual;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UserOnboard {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		String url = "https://myaccount.worktual.co.uk/";
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@Test
	public void b_login() throws InterruptedException {
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String userName = "xivere2297@bacaki.com";
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your email address\"]")).sendKeys(userName);
		String password = "Vectone@123";
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your password\"]")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}
	@Test
	public void c_UserManagement() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[text()='User Management']")).click();
		driver.findElement(By.xpath("//a[text()='Users']")).click();
		
		//add users
		driver.findElement(By.xpath("(//button[@class=\"dropdown-toggle btn btn-primary\"])[1]")).click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class=\"dropdown-item\"])[1]"))).click();
		//driver.findElement(By.xpath("(//a[@class=\"dropdown-item\"])[1]")).click();
	}
	@Test
	public void d_addUserForm() throws InterruptedException {
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String email = "sebif24516@carspure.com";
		driver.findElement(By.xpath("//input[@placeholder=\"Enter First Name\"]")).sendKeys("Supervisor");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Last Name\"]")).sendKeys("One");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Email Address\"]")).sendKeys(email);
		
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
