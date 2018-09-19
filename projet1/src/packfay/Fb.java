package packfay;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Fb {

	WebDriver driver;
	public void invokeDrv() {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"drivers\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);	
	}
	
	public void invokeSite() {
		
		invokeDrv();
		driver.get("https://www.facebook.com/");
		WebElement dropdown = driver.findElement(By.id("month"));
		Select selct_options = new Select(dropdown);
		List<WebElement> all_options=selct_options.getOptions();
		
		
		
		for (WebElement e:all_options) {
			
			System.out.println("List elments :"+e.getText());
				
		}
		int sizefb = all_options.size();
		for(int i=1;i<=sizefb;i++) {
			System.out.println("list elemnts sont :"+i);
		}
		
		
	}
	
	
	
	public static void main(String[] args) {

	}

}
