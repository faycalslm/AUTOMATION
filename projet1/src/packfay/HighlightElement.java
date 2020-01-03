package packfay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HighlightElement {

	public static WebDriver driver ;
	
   public static void highlightt(WebDriver driver , WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style' , 'background: red; border: 2px solid blue;');", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].setAttribute('style' , 'border: solid 2px white');", element);
	}
	
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://learn-automation.com");
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(lastElementToLoad));*/
		driver.findElement(By.id("sendx-close-dNnOns5gBj56SFGkOimE4p")).click();
		/*Alert alert = driver.switchTo().alert();
		alert.dismiss();*/
		WebElement menu = driver.findElement(By.className("menu-text"));
		highlightt(driver, menu);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//body[@class='home blog fusion-image-hovers fusion-pagination-sizing fusion-button_size-large fusion-button_type-flat fusion-button_span-no fusion-button_shape-round avada-image-rollover-circle-yes avada-image-rollover-yes avada-image-rollover-direction-left fusion-has-button-gradient fusion-body ltr fusion-sticky-header no-tablet-sticky-header no-mobile-sticky-header no-mobile-slidingbar no-mobile-totop avada-has-rev-slider-styles fusion-disable-outline fusion-sub-menu-fade mobile-logo-pos-center layout-wide-mode avada-has-boxed-modal-shadow-none layout-scroll-offset-full avada-has-zero-margin-offset-top has-sidebar double-sidebars fusion-top-header menu-text-align-center mobile-menu-design-modern fusion-show-pagination-text fusion-header-layout-v4 avada-responsive avada-footer-fx-none avada-menu-highlight-style-bar fusion-search-form-classic fusion-avatar-square avada-dropdown-styles avada-blog-layout-large avada-blog-archive-layout-large avada-header-shadow-no avada-menu-icon-position-left avada-has-megamenu-shadow avada-has-mainmenu-dropdown-divider avada-has-pagetitle-100-width avada-has-mobile-menu-search avada-has-main-nav-search-icon avada-has-breadcrumb-mobile-hidden avada-has-titlebar-bar_and_content avada-has-pagination-padding avada-flyout-menu-direction-fade do-animate sidebar-position-left fusion-no-touch']/div[@id='boxed-wrapper']/div[@id='wrapper']/header[@class='fusion-header-wrapper']/div[@class='fusion-header-v4 fusion-logo-alignment fusion-logo-center fusion-sticky-menu-1 fusion-sticky-logo- fusion-mobile-logo- fusion-sticky-menu-only fusion-header-menu-align-center fusion-mobile-menu-design-modern']/div[@class='fusion-sticky-header-wrapper']/div[@class='fusion-secondary-main-menu']/div[@class='fusion-row']/nav[@class='fusion-main-menu']/ul[@id='menu-mukesh1']/li[@id='menu-item-4270']/ul[@class='sub-menu']/li[@id='menu-item-4269']/a[1]")).click();
		
	
	}
	
}
