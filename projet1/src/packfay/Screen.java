package packfay;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Screen {	
	public static void main(String[] args) throws IOException  {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\safae\\\\Downloads\\\\chromedriver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/?ref=tn_tnmn");
		Utility.Screen.takeSceenshot(driver, "leo");
		driver.close();
	}
}
