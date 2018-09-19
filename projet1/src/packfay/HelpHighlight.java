package packfay;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelpHighlight {

	public static void highlightt(WebDriver driver , WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style' , 'background: red; border: 2px solid blue;');", element);
		
		/*
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			System.out.println(e.getMessage());
		}
		
		*/
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("arguments[0].setAttribute('style' , 'border: solid 2px white');", element);

	}
	
}
