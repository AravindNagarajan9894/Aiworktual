package NumberPurchase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Number_Perchase_Call {
	WebDriver driver;
	WebDriverWait wait;
	@Test(priority=0)
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://betamyaccount.worktual.co.uk/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	public void login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("email")).sendKeys("petey13416@polatrix.com");
		driver.findElement(By.name("password")).sendKeys("Vectone@123");
		driver.findElement(By.id("login-button")).click();
	}
	@Test(priority=3)
	public void number_Management() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//button[@class=\"accordion-button collapsed\"])[3]")).click();
		driver.findElement(By.xpath("//a[text()='Numbers']")).click();
		
		//Purchase Number
		driver.findElement(By.xpath("//button[text()='Purchase Number']")).click();
		driver.findElement(By.id("react-select-2-placeholder")).sendKeys("Call");
	
		
	}
}
