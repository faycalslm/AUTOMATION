package Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screen {

	public static void takeSceenshot(WebDriver driver , String screenname) {
			
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	    //FileUtils.copyFile(source, new File("C:\\Users\\safae\\Downloads\\commons-io-2.6-src\\testimages.png"));
		try {
			FileUtils.copyFileToDirectory(source, new File("./Screenshots/"+screenname+""));
		} catch (Exception e) {
			
			System.out.println("erreur de capture d ecran :"+e.getMessage());		
			;
		}
		
		
	}
	
	
	
}
