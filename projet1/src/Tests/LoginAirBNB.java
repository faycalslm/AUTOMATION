package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginAirBNB {
	public WebDriver driver;
	
	@Test
	public void connAir() {
	LoginPage log = new LoginPage(driver);
	log.siteWEb(driver, "https://www.airbnb.com/");
	log.connexion("faycal.slm@gmail.com", "fsfsfsfs8");
	log.checkAuth();
	log.closeApp();
		
		
	}
	
	
	
	
	
}
