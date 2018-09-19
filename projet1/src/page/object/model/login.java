/**
 * 
 */
package page.object.model;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class login {
	By connexion = By.xpath("//div[@class='_lvb55za' and contains(text(),'Connexion')]");
	By lgin = By.xpath("");
	By pswd = By.xpath("");
	By buttonCnx = By.xpath("");
	
	WebDriver driver;

	public login(WebDriver driver1) {
		
		this.driver = driver1;
	}
	
	
	public void siteWEb(WebDriver driver , String UR) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\safae\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(UR);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
	}
	
	public void connexion(String login , String Password ) {	
		driver.findElement(connexion).click();
		driver.findElement(lgin).sendKeys(login);
		driver.findElement(pswd).sendKeys(Password);
		driver.findElement(buttonCnx).click();
		
	}
	public void checkAuth() {
		
		assertTrue(driver.getTitle().equalsIgnoreCase("lol"), "authentification echouée");
		
		
		
		
		
	}
	public void closeApp() {
		
		driver.quit();
	}
	
	
	
}
	
	
	
	
	
	

