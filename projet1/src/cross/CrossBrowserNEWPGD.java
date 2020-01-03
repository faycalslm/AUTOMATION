package cross;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserNEWPGD {
	
	public WebDriver driver = null;
	String projectpath = System.getProperty("user.dir");
	
	public static void verifyLinkActive(String linkUrl)
	{
        try 
        {
           URL url = new URL(linkUrl);
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();  
           httpURLConnect.setConnectTimeout(5000);
           httpURLConnect.connect();
           System.out.println("on va vérifier le line suivant :"+linkUrl);
          
           if(httpURLConnect.getResponseCode()==200 || httpURLConnect.getResponseCode()==401)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
               System.out.println(linkUrl+ "  "+httpURLConnect.getResponseCode());
               //System.out.println(linkUrl+ " " +httpURLConnect.getFollowRedirects());
              
            }
           
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
          if (httpURLConnect.getResponseCode()==400) {
			System.out.println(linkUrl+ "- " +httpURLConnect.getResponseMessage());
		}
        } catch (Exception e) {
           System.out.println(e.getMessage());
           System.out.println(e.getCause());
           System.out.println(e.getStackTrace());
           System.out.println(e.getLocalizedMessage());
        }} 
	@Test  
	@Parameters("browser")
	public void testBrowser(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();	
		} 
		else if (browser.equalsIgnoreCase("ie")) {
		driver = new InternetExplorerDriver();	
	}	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://poly-portail-recette.polyexpert.nat:8700/#/login");
		driver.findElement(By.id("inputUsername")).sendKeys("ACS");
		driver.findElement(By.id("inputPassword")).sendKeys("NOMADE");
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block hvr-float']")).submit();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("polyportail-dashboard.ng-star-inserted:nth-child(3) div.container-fluid:nth-child(2) polyportail-application-list.ng-tns-c5-1 div.my-3.p-4.bg-white.rounded.applications-list-container.ng-tns-c5-1.ng-star-inserted ul.applications-list a.ng-tns-c5-1.ng-star-inserted:nth-child(8) li.ng-tns-c5-1 > img.ng-tns-c5-1")).click();
		
		List<WebElement> liensiteweb = driver.findElements(By.tagName("a"));
		for (int i = 0; i < liensiteweb.size(); i++) {
		WebElement element = liensiteweb.get(i);
		String url = element.getAttribute("href");
		verifyLinkActive(url);
		}
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.close();
	}}
	
	

