package CompanyCreation;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class Extras {
	 //random first name
    public static String firstNameGenerator() {
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
    public static String lastNameGenerator() {
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
    public static long mobileNumberGenerator() {
		long randomNumber = 1000000000L + (long)(Math.random() * 9000000000L);
		return randomNumber;
    }
    
 // Method to get content from the clipboard
    public static String getEmailContent(WebDriver driver) throws UnsupportedFlavorException, IOException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }
    
}
