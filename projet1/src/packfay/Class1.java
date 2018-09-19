package packfay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1 {
	
	WebDriver driver;
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\safae\\Downloads\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void browserShit() {
			try {
				invokeBrowser();
				driver.get("http://amazon.com/");
				String Pagetitle = driver.getTitle();
				System.out.println("title :"+Pagetitle);
				Thread.sleep(3000);
				driver.close();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	public static void main(String[] args) {
			Class1 myObj = new Class1();
			myObj.browserShit();

	}

}
