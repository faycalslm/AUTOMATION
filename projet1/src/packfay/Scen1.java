package packfay;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Scen1 {
public WebDriver driver = null;
	@Test
	public void Testing() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/delete_customer.php ");
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("54000");
		driver.findElement(By.xpath("//input[@name='submit']")).submit();
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
	}}
		