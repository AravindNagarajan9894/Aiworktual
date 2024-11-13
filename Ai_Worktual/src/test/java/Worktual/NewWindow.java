package Worktual;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewWindow {	
	WebDriver driver;
	WebDriver driver2;
	WebDriverWait wait;
	@Test
	public void a_setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = "https://myaccount.worktual.co.uk/";
		driver.get(url);
		driver.manage().window().maximize();
		
		 WebElement tempmail = driver.findElement(By.xpath("//button[@class='btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']"));
		 System.out.println(tempmail.getText());
		 Thread.sleep(10000);
		 tempmail.click();

		
	}
	@Test
	public void b_login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String userName = "xivere2297@bacaki.com";
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your email address\"]")).sendKeys(userName);
		String password = "Vectone@123";
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your password\"]")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}
	

	public String copyEmail() throws InterruptedException, UnsupportedFlavorException, IOException {
		
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 ChromeOptions options = new ChromeOptions();
	     options.addArguments("--incognito");
	     driver2 = new ChromeDriver(options);
	     driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver2.get("https://temp-mail.org/en/");
	     driver2.manage().window().maximize();
		 
	     Thread.sleep(1500);
		 //mail id element
	     WebElement tempmail = driver2.findElement(By.xpath("//button[@class='btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']"));
		 tempmail.click();
		 
		 Toolkit toolkit = Toolkit.getDefaultToolkit();
	     Clipboard clipboard = toolkit.getSystemClipboard();
	     return (String) clipboard.getData(DataFlavor.stringFlavor);
		
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
	public void d_addUserForm() throws InterruptedException, UnsupportedFlavorException, IOException {
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder=\"Enter First Name\"]")).sendKeys("Supervisor");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Last Name\"]")).sendKeys("Nine");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Email Address\"]")).sendKeys(copyEmail());
		
		//Role 
		WebElement roleCheckBox = driver.findElement(By.xpath("//select[@name=\"organisationRole\"]"));
		Select role = new Select(roleCheckBox);
		role.selectByVisibleText("Supervisor");
		
		//company info
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Employee ID\"]")).sendKeys("006");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Job title\"]")).sendKeys("Supervisor");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter department\"]")).sendKeys("CcaaS");
		
		
		//reporting to
		WebElement reportingToCheckBox = driver.findElement(By.xpath("//select[@name=\"report\"]"));
		Select reportingTo = new Select(reportingToCheckBox);
		reportingTo.selectByValue("200");
		
		
		//personal info
		driver.findElement(By.xpath("//input[@placeholder=\"Enter phone number\"]")).sendKeys("9101084708272");
		driver.findElement(By.xpath("//button[text()='Create User']")).click();
	}
	
	@Test
	public void e_password() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(10000);
		driver2.findElement(By.xpath("(//a[@class=\"viewLink title-subject\"])[2]")).click();
	}
	    

}
