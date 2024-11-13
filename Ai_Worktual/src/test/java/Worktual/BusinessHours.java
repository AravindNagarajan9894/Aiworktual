package Worktual;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BusinessHours {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ccaas.worktual.co.uk/");
	}
	@Test
	public void b_login() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(150));
		//Username
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Username\"]")));
		username.sendKeys("fihek23113@dxice.com");
		
		//Password
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Password\"]")));	
		password.sendKeys("Vectone@123");
		
		//submit
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		
	}
	@Test
	public void c_createBusniessHours(){

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		
		WebElement setting =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"menuTitle menuTitlesettings false\"]")));
		setting.click();
		
		WebElement busniessHours = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"settings_channelDt__ItWve\"])[4]")));
		busniessHours.click();
		
		// crete busniess hours
		WebElement createButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"buttonGreenCreate\"]")));
		createButton.click();
		
		//form
		driver.findElement(By.xpath("//input[@placeholder=\"New Business Hours\"]")).sendKeys("Hour one");
		
		driver.findElement(By.id("basic_timezone")).click();
		WebElement asiaKolkata = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Asia/Kolkata (IST) GMT +05:30']")));
		asiaKolkata.click();
	}
}
