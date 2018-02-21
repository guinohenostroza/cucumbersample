package FatFree.CrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	 private String HOME_URL = "http://bitnami-fatfreecrm-dbe3.cloudapp.net/";
	 private final WebDriver driver;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    public HomePage access(){
	    	driver.get(HOME_URL);
	    	
	    	if (!"Fat Free CRM".equals(driver.getTitle())) {
	            // Alternativamente, podriamos navegar hacia la pagina de Login, haciendo Logout previamente.
	            throw new IllegalStateException("Esta no es la pagina Home");
	        }	      
	    	return this;
	    }
	    
	    public String WelcomeUsername(){
	    	WebElement user = driver.findElement(By.id("welcome_username"));
	    	return user.getText();
	    }
	    
	    
	    
}
