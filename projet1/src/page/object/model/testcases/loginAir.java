package page.object.model.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import page.object.model.login;

public class loginAir {
	WebDriver driver;
	
	@Test
	public void connAir() {
	login log = new login(driver);
	log.siteWEb(driver, "https://www.airbnb.fr/");
	log.closeApp();
		
		
	}
	
	
	
	
	
}
