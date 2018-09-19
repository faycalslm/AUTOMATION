package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tng {
	
WebDriver driver;
	@Test(priority=0,description="test1")
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\safae\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		//Assert.assertEquals("face", driver.getTitle());
	}
	
	@Test(priority=1, description="test 2")
	public void checkWebsite() {
		openBrowser();
		driver.findElement(By.xpath("//input[@type='email']")).click();
		driver.navigate().back();
		//Assert.assertEquals(12, 12);
		
	}
	
	
	
	public void testSoft() {
		SoftAssert assertSoft = new SoftAssert();
		assertSoft.assertEquals(12, 1);
		System.out.println("done nice");
		assertSoft.assertAll();
		
		
	}
	
	public void assertStop() {
		
		Assert.assertTrue(false);
		
	}
	
public void quit() {
		
driver.quit();		
	}
	
	
}
