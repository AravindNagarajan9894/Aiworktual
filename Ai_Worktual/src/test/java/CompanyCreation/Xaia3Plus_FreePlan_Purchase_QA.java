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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Xaia3Plus_FreePlan_Purchase_QA{
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void a_setUp() {
		driver = new ChromeDriver();
		driver.get("https://qapricing.qaworktual.co.uk/ccaas_pricing/purchaseflow/freetrial_companydetails/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void c_copyEmail() throws InterruptedException, UnsupportedFlavorException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//opening new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://temp-mail.org/en/");
		Thread.sleep(10000);
		
		//mailid element
		WebElement tempmail = driver.findElement(By.xpath("//button[@class='btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']"));
		System.out.println(tempmail.getText());
		tempmail.click();
	}
	
	// Method to get content from the clipboard
    public String getEmailContent() throws UnsupportedFlavorException, IOException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }
    
    //random first name
    public String firstNameGenerator() {
    	List<String> fName = new ArrayList();
		fName.add("Kelly");
		fName.add("Oliver");
		fName.add("Paul");
		fName.add("Lucas");
		fName.add("Marshall");
		fName.add("Ibraheem");
		fName.add("Lloyd");
		fName.add("Victor");
		fName.add("Seth");
		
		int randonIndex = (int)(Math.random()*fName.size());
		
		String firstName = fName.get(randonIndex);
		return firstName;
    }
    
    //random last name
    public String lastNameGenerator() {
    	List<String> lName = new ArrayList();
    	lName.add("Archer");
    	lName.add("Porter");
    	lName.add("Amanda");
    	lName.add("Hill");
    	lName.add("Emilia");
    	lName.add("Carroll");
    	lName.add("Fleming");
    	lName.add("Annabelle");
    	lName.add("Jose ");
		
		int randonIndex = (int)(Math.random()*lName.size());
		
		String lastName = lName.get(randonIndex);
		return lastName;
    }
    
   //random mobile number
    public long mobileNumberGenerator() {
		long randomNumber = 1000000000L + (long)(Math.random() * 9000000000L);
		return randomNumber;
    }
	@Test
	public void d_formFreeTrail() throws InterruptedException, UnsupportedFlavorException, IOException   {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//return Back to worktual.co.uk
		Set<String> windowIdsSet = driver.getWindowHandles();
    	List<String> windowIdsList = new ArrayList(windowIdsSet);
    	System.out.println(windowIdsList.size());
    	
    	driver.switchTo().window(windowIdsList.get(0));
    	
    	String url = "https://worktual.co.uk/ccaas_pricing/purchaseflow/freetrial_companydetails/";
    	if(driver.getCurrentUrl().equals(url)) {
    		//form
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    		driver.findElement(By.id("fname")).sendKeys(firstNameGenerator());
    		driver.findElement(By.id("lname")).sendKeys(lastNameGenerator());
    		driver.findElement(By.id("email")).sendKeys(getEmailContent());
    		driver.findElement(By.id("contact_phone")).sendKeys(""+mobileNumberGenerator());
    		driver.findElement(By.id("company_name")).sendKeys("WtTest");
    		driver.findElement(By.id("noofUser")).sendKeys("10");
    		
    		//check boxes
    		driver.findElement(By.xpath("(//span[@class='checkmark'])[1]")).click();
    		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
    		
    		//continue
    		driver.findElement(By.xpath("//button[text()='Continue ']")).click();
    	}
    	
	}
	
	@Test
	public void e_password() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("password")).sendKeys("Vectone@123");
		driver.findElement(By.xpath("//button[text()='Complete trial signup']")).click();
		
	}
	
}
