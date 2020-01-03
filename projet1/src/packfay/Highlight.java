package packfay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Highlight {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\safae\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://learn-automation.com/");
		//driver.switchTo().frame(arg0
		Actions actions = new Actions(driver); 
     WebElement automation = driver.findElement(By.xpath("//li[@id='menu-item-4270']//span[@class='menu-text'][contains(text(),'Automation Tools')]"));
     actions.moveToElement(automation).perform();
     WebElement selenium = driver.findElement(By.xpath("//body[@class='home blog fusion-image-hovers fusion-pagination-sizing fusion-button_size-large fusion-button_type-flat fusion-button_span-no fusion-button_shape-round avada-image-rollover-circle-yes avada-image-rollover-yes avada-image-rollover-direction-left fusion-has-button-gradient fusion-body ltr fusion-sticky-header no-tablet-sticky-header no-mobile-sticky-header no-mobile-slidingbar no-mobile-totop avada-has-rev-slider-styles fusion-disable-outline fusion-sub-menu-fade mobile-logo-pos-center layout-wide-mode avada-has-boxed-modal-shadow-none layout-scroll-offset-full avada-has-zero-margin-offset-top has-sidebar double-sidebars fusion-top-header menu-text-align-center mobile-menu-design-modern fusion-show-pagination-text fusion-header-layout-v4 avada-responsive avada-footer-fx-none avada-menu-highlight-style-bar fusion-search-form-classic fusion-avatar-square avada-dropdown-styles avada-blog-layout-large avada-blog-archive-layout-large avada-header-shadow-no avada-menu-icon-position-left avada-has-megamenu-shadow avada-has-mainmenu-dropdown-divider avada-has-pagetitle-100-width avada-has-mobile-menu-search avada-has-main-nav-search-icon avada-has-breadcrumb-mobile-hidden avada-has-titlebar-bar_and_content avada-has-pagination-padding avada-flyout-menu-direction-fade do-animate sidebar-position-left fusion-no-touch']/div[@id='boxed-wrapper']/div[@id='wrapper']/header[@class='fusion-header-wrapper']/div[@class='fusion-header-v4 fusion-logo-alignment fusion-logo-center fusion-sticky-menu-1 fusion-sticky-logo- fusion-mobile-logo- fusion-sticky-menu-only fusion-header-menu-align-center fusion-mobile-menu-design-modern']/div[@class='fusion-sticky-header-wrapper']/div[@class='fusion-secondary-main-menu']/div[@class='fusion-row']/nav[@class='fusion-main-menu']/ul[@id='menu-mukesh1']/li[@id='menu-item-4270']/ul[@class='sub-menu']/li[@id='menu-item-4269']/a[@class='fusion-bar-highlight']/span[1]")); 
     actions.moveToElement(selenium).perform();
     WebElement seleniumcsharp = driver.findElement(By.xpath("//li[@id='menu-item-4173']//span[contains(text(),'Selenium Webdriver C# Tutorial')]"));
     seleniumcsharp.click();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     String codesource = driver.getPageSource();
     Assert.assertTrue(codesource.contains("How to Select Calendar Values in Selenium with C# and Webtable"));
     System.out.println(driver.getTitle());
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
     driver.close();
		
		
		
		
		
	}
	
	
	
	
	
	
}
	
	
	
