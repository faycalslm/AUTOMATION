
package packfay;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class wAIT {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fselmane\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.guru99.com/implicit-explicit-waits-selenium.html]");
		
		List<WebElement> list = driver.findElements(By.tagName("frame"));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	/*	WebDriverWait tsena = new WebDriverWait(driver, 5);
		Alert myalert = tsena.until(ExpectedConditions.alertIsPresent());
		myalert.dismiss();
        driver.close();*/
		
		
		
		
		
	}
	
	
	
	
	
	
}
	
	
	
