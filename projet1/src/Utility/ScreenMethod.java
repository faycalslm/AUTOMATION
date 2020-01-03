package Utility;

import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenMethod {
	
	public static void takeSceenshot(WebDriver driver , String screenname) {
		
		//screenshot de l'ecran
		
		TakesScreenshot screen = (TakesScreenshot)driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(source, new File("./Screenshots/"+screenname+""));
		} catch (Exception e) {
			
			System.out.println("erreur de capture d ecran :"+e.getMessage());		
			
		}	
		}	
	
	//prendre capture d'ecran d'un seul element ou framee
	
		public static void takePartialScreenShot(WebDriver driver , WebElement element) throws IOException {

			String screenShot = System.getProperty("user.dir") + "Screenshots\\fay\\screenShot.png";
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Point p = element.getLocation();
			int width = element.getSize().getWidth();
			int height = element.getSize().getHeight();
			BufferedImage img = ImageIO.read(screen);
			BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width,height);
			ImageIO.write(dest, "png", screen);
			FileHandler.copy(screen, new File(screenShot));
		}

	//attendre l'apparition d'un element
		public static void AttendreChargementPage (WebDriver driver , WebDriverWait wait , WebElement nomElement) {
			//explicit wait
			wait = (WebDriverWait) new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(nomElement));
			
			//implicit wait
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//fluent wait
			/*@SuppressWarnings(value = { "" })
			FluentWait<WebDriver> wait2 = new FluentWait<WebDriver>(driver);
			wait2.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);*/
		}
	
	//Actions avec la souris
		public static void MouseActions(WebDriver driver , WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element); //parcourir un sous menu qui apparait apres un mousehover sur le mennu principal
			action.moveToElement(element, 100, 200);
			action.clickAndHold(element);  // cliquer et maintenir
			action.doubleClick(element).perform();   // double click
			action.contextClick(element).perform();  //click droit
		}
	
		
		//Recuperer la date
		public static String fn_GetTimeStamp(){
			DateFormat DF=DateFormat.getDateTimeInstance();
			Date dte=new Date();
			String DateValue=DF.format(dte);
			DateValue=DateValue.replaceAll(":", "_");
			DateValue=DateValue.replaceAll(",", "");
			return DateValue;
		}
	
	//Select options from a list
	public static void ElementFromListe(WebDriver driver , String VisibleText , WebElement chaine) {
	
		Select selection = new Select(chaine);
		selection.selectByIndex(0);
		selection.selectByValue("");
		selection.selectByVisibleText("");
		selection.deselectByIndex(0);
		selection.getAllSelectedOptions();
		selection.getFirstSelectedOption();
		Collection<WebElement> liste =  selection.getOptions();
		System.out.println(liste);
			
	}
	
	
	//Parcourir les options d'une liste
	public static void SlectionRadioButtons() {
		WebElement channel = null;
		Select selection2 = new Select(channel);
		List options = (List)selection2.getOptions();
		System.out.println("Liste des options est :"+options);
	}
	
	
	//Gestion des frames
	@SuppressWarnings("deprecation")
	public static void gestionFrames(WebDriver driver) {
		driver.switchTo().frame(0);
		//trouver les frames d'une page
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		 Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		 System.out.println("Number of iframes on the page are " + numberOfFrames);
		
		 //deuxieme methode utilisant le tag iframe
		
		 List iframeElements = (List) driver.findElements(By.tagName("iframe"));
		 System.out.println("The total number of iframes are " + iframeElements.size()); 
		 
	}
	
	//cliquer sur un checkbox qui n'est pas visible
	public static void checkInvisibleOption(WebDriver driver , WebElement checkbox) {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", checkbox);
		
	}


	//changer de fenetres dans un navigateur
	
	public static void changeOnglet(WebDriver driver) {// Get the current window handle.
			String fenetre1 = driver.getWindowHandle();
			// Switch to new windows.
			for(String fenetre2: driver.getWindowHandles()){
			driver.switchTo().window(fenetre2);
			}
			// Close all new windows.
			driver.close();

			// Switch back to first window.
			driver.switchTo().window(fenetre1);

			// Changer de tab 
			// CTRL + T
			// on peut ajouter plusieurs de touches du clavier grave à cette methode
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
			
			//executer les tests sur le nouveau tab
			ArrayList<String> tablist = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tablist.get(0));
			
	}
	
	//gestions des alertes et pop up
	public static void Gestionalerte(WebDriver driver ) {
		
			driver.switchTo().alert().dismiss();
			driver.switchTo().alert().accept();
			driver.switchTo().alert().sendKeys("text..");
			driver.switchTo().alert().notify();
		
	}
	
	
	//trouver les images et liens cassées
	
	public static void brokenImages(WebDriver driver , WebElement image , String URL) throws MalformedURLException, IOException {
		
			java.util.List<WebElement> listeimages = driver.findElements(By.tagName("img"));
			listeimages.addAll(driver.findElements(By.tagName("a")));
			System.out.println("nbre total des images :"+listeimages.size());
			java.util.List<WebElement> imagesactives = new ArrayList<WebElement>();
			for (int i = 0; i < listeimages.size(); i++) {
				if (listeimages.get(i).getAttribute("href")!= null ||listeimages.get(i).getAttribute("href").contains("javascript")) {
					imagesactives.add(listeimages.get(i));
				}
			}
			
			System.out.println("nbre total des images qui ont l'attribut href"+imagesactives);
			
			for (int j = 0; j < imagesactives.size(); j++) {
				HttpURLConnection conx = (HttpURLConnection) new URL(imagesactives.get(j).getAttribute("href")).openConnection();
				conx.connect();
				String reponse = conx.getResponseMessage();
				
				
				System.out.println("la reponse de ce lien : "+imagesactives.get(j).getAttribute("href")+ "est" + reponse);
				java.util.List<WebElement> imagescorrectes = new ArrayList<WebElement>();
				
				for (int f = 0; f < imagesactives.size(); f++) {
					if (imagesactives.get(j).getAttribute("href") == "200") {
						imagescorrectes.add(imagesactives.get(f));
					}
				}
				System.out.println("le nombre total d'images et liens qui ont une réponse correcte est"+imagescorrectes.size());
				
			}
	}
	
	
	
	//Trouver les liens morts d'un siteweb
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
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
          if (httpURLConnect.getResponseCode()==400 ) {
			System.out.println(linkUrl+ "- " +httpURLConnect.getResponseMessage());
		}
          if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_FORBIDDEN || httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
			System.out.println(linkUrl + " - "+httpURLConnect.getResponseMessage());
		}
          
        } catch (Exception e) {
           System.out.println(e.getMessage());
           System.out.println(e.getCause());
           System.out.println(e.getStackTrace());
           System.out.println(e.getLocalizedMessage());
        }} 
		
	//Scroll down
	public static void ScrollDownElement(WebElement element , WebDriver driver) {
		
		//Scroll down jusqu'à l'apparition d'un element
		JavascriptExecutor javascript = (JavascriptExecutor)driver;
		javascript.executeScript("arguments[0].scrollIntoView();", element);
		
		//Scroll down jusu'au bas de la page
		javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	
	//Gestion des certifiats 	
	public static void GestionSSLCerti(WebDriver driver) {
			
	DesiredCapabilities gestionsslchrome = new DesiredCapabilities();
	//accepter les certificats SSL
	gestionsslchrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	//accepter les certificats non securisés
	gestionsslchrome.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	
	}

	
	//Drag and Drop
	public static void dragDrop(WebDriver driver , WebElement element1 , WebElement element2) {
		
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2).build().perform();
		action.dragAndDropBy(element1, 200, 10); //drag and drop by pixels
		
	}
	
	
	
}
