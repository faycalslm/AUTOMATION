package cross;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OuvrirAllianzNEWPGD {
	
	public WebDriver driver ;
	public String ProjectPathj = System.getProperty("user.dir");
	
	public void accesNewpgd() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fselmane\\Downloads\\chromedriver_win32\\chromedriver1.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://poly-portail-recette.polyexpert.nat:8700/#/login");
		driver.findElement(By.id("inputUsername")).sendKeys("ACS");
		driver.findElement(By.id("inputPassword")).sendKeys("NOMADE");
		driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block hvr-float']")).submit();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("polyportail-dashboard.ng-star-inserted:nth-child(3) div.container-fluid:nth-child(2) polyportail-application-list.ng-tns-c5-1 div.my-3.p-4.bg-white.rounded.applications-list-container.ng-tns-c5-1.ng-star-inserted ul.applications-list a.ng-tns-c5-1.ng-star-inserted:nth-child(8) li.ng-tns-c5-1 > img.ng-tns-c5-1")).click();	
	}
	
	@Test
	public void testAllianz() {
		accesNewpgd();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Tous les dossiers')]"))));
		driver.findElement(By.cssSelector("div.main-block:nth-child(4) main.container-fluid div.router-outlet-container newpgd-dossier-list-container.ng-star-inserted:nth-child(2) newpgd-dossier-list-table:nth-child(2) div.search-container:nth-child(1) div.advanced-search div:nth-child(1) > span:nth-child(1)")).click();
		//Select compagnies = new Select(driver.findElement(By.className("ui-dropdown-items ui-dropdown-list ui-widget-content ui-widget ui-corner-all ui-helper-reset")));
		//compagnies.selectByIndex(16);
		driver.findElement(By.className("ng-tns-c12-2 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ui-dropdown-label-empty ng-star-inserted")).click();
		//WebDriverWait waitt = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("ng-star-inserted"))));
		driver.findElement(By.className("ng-star-inserted")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
	}}
	
	

