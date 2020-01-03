  package packfay;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail {
	
	WebDriver driver;
	public void invokeBrowser() {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\safae\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public void loadWebsite() {
		invokeBrowser();
		driver.get("http://www.kooora.com/");
		String title = driver.getTitle();
		//assert true; title.contains("gt");	
		assertTrue(title.contains("gt"));
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		driver.close();
	}
	public static void main(String[] args) {

		Gmail obj = new Gmail();
		obj.loadWebsite();
	}
}
