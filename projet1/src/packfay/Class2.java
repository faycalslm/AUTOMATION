package packfay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Class2 {
	
	WebDriver driver;
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\safae\\Downloads\\chromedriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			String browsername = options.getBrowserName();
			System.out.println("browser name"+browsername);
			String version = options.getVersion();
			System.out.println("browser name"+version);
			org.openqa.selenium.Platform platefroem = options.getPlatform();
			System.out.println("browser name"+platefroem);
			@SuppressWarnings("deprecation")
			Boolean js = options.isJavascriptEnabled();
			System.out.println("browser name"+js);
	
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
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
			Class2 myObj = new Class2();
			myObj.browserShit();

	}

}
