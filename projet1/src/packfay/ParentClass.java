package packfay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



public class ParentClass {
	
	public WebDriver driver ;
	
	
	
	public void fayh() {
		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://google.com/");
			//WebElement image = driver.findElement(By.tagName("a"));
			//System.out.println(image.findElements(By.tagName("img")).size());
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			//driver.close();
	}
	
	}
	

