package AssignUsers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class AssignUsers_in_Ccaas {
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String value) {
		switch(value.toLowerCase().trim()) {
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver(); break;
		default :System.out.println("invalid");return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://myaccount.worktual.co.uk/");
		driver.manage().window().maximize();
	}
	@Test (priority=1)
	public void navigateToForm() throws InterruptedException {
		MyAccount_LoginPage elements = new MyAccount_LoginPage(driver);
		elements.setEmail_Password_ClickLogin("vefisoh175@adrais.com", "Vectone@123");
		elements.navigate_to_users();
	}
	@Test(priority=2)
	public void AssignSupervisor() throws InterruptedException {
		FormPage elements = new FormPage(driver);
		elements.setFname("aravind");
		elements.setLname("test");
		elements.setEmailadd("test");
		elements.setRoleAsSupervisor();
	}

}
