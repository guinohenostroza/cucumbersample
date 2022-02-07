package FatFree.CrmAutomation;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class Login_steps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
	
	// Usar 
	@Before
	public void AntesDe()
	{
		System.setProperty("webdriver.gecko.driver",
                "./driver/geckodriver.exe");
        driver = new FirefoxDriver();		
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
	}
	
	
	@Dado("^que estoy en la pagina de inicio$")
	public void que_estoy_en_la_pagina_de_inicio() throws Throwable {
	    loginPage.access();
	}

	@Cuando("^Ingreso con los siguientes detalles de usuario$")
	public void ingreso_con_los_siguientes_detalles_de_usuario(DataTable cuentaUsuario) throws Throwable {
		List<List<String>> data = cuentaUsuario.raw();
		loginPage.typeUsername(data.get(1).get(0));
		loginPage.typePassword(data.get(1).get(1));
		homePage = loginPage.submitLogin();
		Thread.sleep(2000);
	}

	@Entonces("^debo ir a la pagina principal$")
	public void debo_ir_a_la_pagina_principal() throws Throwable {
		homePage.access();
		assertEquals(homePage.WelcomeUsername(),"USER");
	}
	
	@After
	public void LuegoDe()
	{
		driver.quit();
	}
}
