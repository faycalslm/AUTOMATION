package packfay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Highlight {
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\safae\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://web.facebook.com/?_rdc=1&_rdr");
		WebElement element = driver.findElement(By.xpath("//input[@type='email']"));
		
		
		HelpHighlight.highlightt(driver, element);
		element.sendKeys("leofay");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.close();
		
		
		
		
		
	}
	
	
	
	
	
	
}
	
	
	
