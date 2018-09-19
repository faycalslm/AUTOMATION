package cross;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testCross {
	WebDriver driver;
	@Test
	@Parameters("browser")
	public void testBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\safae\\Downloads\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} 
		
		else if (browser.equalsIgnoreCase("ie")) {
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\safae\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();	
	}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.seleniumhq.org/download/");
		System.out.println("title"+driver.getTitle());
		
		driver.quit();
		
		
	}
	
}
	
	

