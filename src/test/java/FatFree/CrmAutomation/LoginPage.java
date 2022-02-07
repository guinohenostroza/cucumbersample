package FatFree.CrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 // final
	  private WebDriver driver;
      private String LOGIN_URL = "http://bitnami-fatfreecrm-dbe3.cloudapp.net/login";
	  
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

        By usernameLocator = By.id("authentication_username");
        By passwordLocator = By.id("authentication_password");
        By loginButtonLocator = By.name("commit");
	        
	    public LoginPage access(){
	    	driver.get(LOGIN_URL);
	    	
	    	if (!"Fat Free CRM".equals(driver.getTitle())) {
	            // Alternativamente, podriamos navegar hacia la pagina de Login, haciendo Logout previamente.
	            throw new IllegalStateException("Esta no es la pagina de Login");
	        }
	      
	    	return this;
	    }
	   
	    public LoginPage typeUsername(String username) {
	        driver.findElement(usernameLocator).sendKeys(username);

	        return this;	
	    }

	 
	    public LoginPage typePassword(String password) {
	        driver.findElement(passwordLocator).sendKeys(password);

	        return this;	
	    }

	   
	    public HomePage submitLogin() {

	        driver.findElement(loginButtonLocator).submit();
	      
	        return new HomePage(driver);	
	    }

	
	    public LoginPage submitLoginExpectingFailure() {
	
	        driver.findElement(loginButtonLocator).submit();

	        return new LoginPage(driver);	
	    }

	    public HomePage loginAs(String username, String password) {
	        typeUsername(username);
	        typePassword(password);
	        return submitLogin();
	    }
}
