package Pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	
	By nomsiteweb = By.xpath("//img[@class='fusion-standard-logo']");
	
	public static WebDriver driver;
	public HomePage(WebDriver driver2) {
		
		driver = driver2 ;
		
	}
	
	public void OuvrirSiteWeb(String URL) {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
	}
	
	
	public String VerifierTitreSite() 
	{
		String Title = driver.getTitle();
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.elementToBeClickable(nomsiteweb));
		return  Title ;
	}
	
	
	
}
