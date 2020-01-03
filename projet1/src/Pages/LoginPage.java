/**
 * 
 */
package Pages;

import static org.testng.Assert.assertTrue;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class LoginPage {
	
	
	By Testing = By.xpath("//span[contains(text(),'Home')]");
	By lgin = By.xpath("//input[@id='email-login-email']");
	By pswd = By.xpath("//input[@id='email-login-password']");
	By buttonCnx = By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/section[1]/section[1]/div[2]/form[1]/div[1]/div[7]/button[1]/span[1]");
	
	
	public static WebDriver driver=null;
	//String projectpath = System.getProperty("user.dir");
	
	
	public LoginPage(WebDriver driver1) {
		this.driver = driver1;
	}
	
	public void siteWEb(WebDriver driver , String UR) {
		//System.setProperty("webdriver.chrome.driver", projectpath+"drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(UR);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);

	}
	
	public void connexion(String login , String Password ) {	
		Actions action = new Actions(driver);
		action.moveToElement((WebElement) Testing).perform();
		//driver.findElement(connexion).click();
		driver.findElement(lgin).sendKeys(login);
		driver.findElement(pswd).sendKeys(Password);
		driver.findElement(buttonCnx).click();
	}
	public void checkAuth() {
		assertTrue(driver.getTitle().contains("udemy"));
	}
	
	public void closeApp() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.quit();
	}
	
	
	
}
	
	
	
	
	
	

