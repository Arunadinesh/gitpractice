package Practice;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.lang.model.util.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flipkart {

	public class Watsup {

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='policies-title footertitle']")));
		List<WebElement> elements=driver.findElements(By.xpath("//div[contains(text(),'Remove')]"));
		System.out.println("Number of elements :" +elements.size() );
		for(int i=0;i<elements.size();i++){
			elements.get(i).click();
		}
		driver.findElement(By.xpath("//div[contains(text(),'Missing Cart items')]")).isDisplayed();
		driver.navigate().back();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Cart')]")));
		driver.findElement(By.xpath("//span[@role='button']")).click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); 
		driver.findElement(By.xpath("//a[@aria-label='Mobiles']//span[contains(text(),'Mobiles')]")).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Filter')]")));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while(true) {
			boolean isDisplayedPhone = false;
			try {
				isDisplayedPhone = driver.findElement(By.xpath("(//div[@data-tracking-id='Samsung smartphones']//a)[6]")).isDisplayed();
			}catch (Exception e) {
				isDisplayedPhone = false;
			}
			
			
			if (isDisplayedPhone) {
				break;
			}else {
//				boolean isDisplayedFooter = false;
//				try {
//					isDisplayedFooter = driver.findElement(By.xpath("//footer")).isDisplayed();
//				}catch (Exception e) {
//					isDisplayedFooter = false;
//				}
//				
//				if(isDisplayedFooter) {
//					System.out.println("Phone section is not availabe in webpage");
//					break;
//				}else {
//					js.executeScript("window.scrollBy(0,250)", "");
//				}	
				js.executeScript("window.scrollBy(0,1000)", "");
			}
		}
		
		
		
		String mainpage = driver.getWindowHandle();
		System.out.println("Main Page:" + mainpage);
		String mainPageTitle = driver.getTitle();
		WebElement phone = driver.findElement(By.xpath("(//div[@data-tracking-id='Samsung smartphones']//a)[6]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(phone);
		action.click();
		action.build().perform();

		
		//wait
	
		System.out.println("mainPageTitle:  " + mainPageTitle);
		Set<String> childwindows = driver.getWindowHandles();
		System.out.println("Number of elements:" + childwindows.size());
		for (String window : childwindows) {
			System.out.println();
			System.out.println("Child windows: " + window.toString());
			driver.switchTo().window(window);
			String childPageTitle = driver.getTitle();
			System.out.println("childPageTitle " + childPageTitle);
			if (!childPageTitle.equals(mainPageTitle)) {
				System.out.println("Child and main window title matches");
				break;
			}
			System.out.println("Child and main window title not matches");
		}
			Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='row']//li//button)[1]")));
			
			String currenttitle = driver.findElement(By.xpath("//span[@class='VU-ZEz']")).getText();
			System.out.println("Currenttitle = "+currenttitle);

			String cuurentPrice = driver.findElement(By.xpath("//div[contains(text(),'Available offers')]//preceding::div[6]//div[1]")).getText();
			System.out.println("OfferPrice = "+cuurentPrice);
			
			String OriginalPrice = driver.findElement(By.xpath("//div[contains(text(),'Available offers')]//preceding::div[6]//div[2]")).getText();
			System.out.println("OriginalPrice = "+OriginalPrice);
			
			String OfferPercentage = driver.findElement(By.xpath("//div[contains(text(),'Available offers')]//preceding::div[6]//div[3]")).getText();
			System.out.println("OfferPercentage = "+OfferPercentage);
			
			
			WebElement Addcart =driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
			WebElement cart= driver.findElement(By.xpath("(//ul[@class='row']//li//button)[1]"));
//			WebElement paywithEMI= driver.findElement(By.xpath("(//ul[@class='row']//li//button)[2]"));
			
			if (Addcart.isDisplayed()) {
				Addcart.click();
			}
			else if (cart.isDisplayed()) {
				cart.click();	
			}else {
				System.out.println("There is no cart button availabe for this product");
			}
			
			 //wait
			Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Seller')]//preceding::div[2]//a[contains(text(),'SAMSUNG')]")));
			 
			 String expectedtitle = "Shopping Cart | Flipkart.com";
			 String actualTitle = driver.getTitle();
			 assert.assertEquals(actualTitle,expectedtitle);
			 
			 
			 
			 if(actualTitle.equals("Shopping Cart | Flipkart.com")) {
				 System.out.println("Phone is sucessfully addded to the cart");
			 }else {
				 System.out.println("Unable to add phone to shoping cart");
			 }
			 
			 
			 String Mobilename= driver.findElement(By.xpath("//div[contains(text(),'Seller')]//preceding::div[2]//a[contains(text(),'SAMSUNG')]")).getText();
			 System.out.println("Mobilename = "+Mobilename);
			 
			 String Currentprictatcart= driver.findElement(By.xpath("//div[contains(text(),'Seller')]//following-sibling::span[2]")).getText();
			 System.out.println("Currentprictatcart = "+Currentprictatcart);
			 
			 String Originalprictatcart= driver.findElement(By.xpath("//div[contains(text(),'Seller')]//following-sibling::span[1]")).getText();
			 System.out.println("Originalprictatcart = "+Originalprictatcart);
			 
			 String offerpercentageatcart= driver.findElement(By.xpath("//div[contains(text(),'Seller')]//following-sibling::span[3]")).getText();
			 System.out.println("offerpercentageatcart = "+offerpercentageatcart);
			 
			 if(currenttitle.contains(Mobilename)){
				 System.out.println("Product in cart are matched");
			 }
			 else {
				 System.out.println("Product are not matched in cart");

			 }
			 
			 if(cuurentPrice.contains(Currentprictatcart)){
				 System.out.println("Current Prizes are matched");
			 }
			 else {
				 System.out.println("Current Prizes are not matched");

			 }
			 if(OriginalPrice.contains(Originalprictatcart)){
				 System.out.println("Original Prizes are matched");
			 }
			 else {
				 System.out.println("Original are not matched");

			 }if(OfferPercentage.contains(offerpercentageatcart)){
				 System.out.println("OfferPercentage are matched");
			 }
			 else {
				 System.out.println("OfferPercentage are not matched");

			 }
			 
			 driver.switchTo().window(mainpage);
			 Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Filter')]")));
			 driver.findElement(By.xpath("//a[contains(@href,'viewcart')]//span")).click(); 
			 Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Place Order')]")));
			 
			 String Mobilenameatmaincart= driver.findElement(By.xpath("//div[contains(text(),'Seller')]//preceding::div[2]//a[contains(text(),'SAMSUNG')]")).getText();
			 System.out.println("Mobilenameatmaincart = "+Mobilenameatmaincart);
			 
			 String Currentprictatmaincart= driver.findElement(By.xpath("//div[contains(text(),'Seller')]//following-sibling::span[2]")).getText();
			 System.out.println("Currentprictatmaincart = "+Currentprictatmaincart);
			 
			 String Originalprictatmaincart= driver.findElement(By.xpath("//div[contains(text(),'Seller')]//following-sibling::span[1]")).getText();
			 System.out.println("Originalprictatmaincart = "+Originalprictatmaincart);
			 
			 String offerpercentageatmaincart= driver.findElement(By.xpath("//div[contains(text(),'Seller')]//following-sibling::span[3]")).getText();
			 System.out.println("offerpercentageatmaincart = "+offerpercentageatmaincart);
			 
			 if(Mobilename.contains(Mobilenameatmaincart)){
				 System.out.println("Product in cart are matched");
			 }
			 else {
				 System.out.println("Product are not matched in cart");

			 }
			 
			 if(Currentprictatcart.contains(Currentprictatmaincart)){
				 System.out.println("Current Prizes are matched");
			 }
			 else {
				 System.out.println("Current Prizes are not matched");

			 }
			 if(Originalprictatcart.contains(Originalprictatmaincart)){
				 System.out.println("Original Prizes are matched");
			 }
			 else {
				 System.out.println("Original are not matched");

			 }if(offerpercentageatcart.contains(offerpercentageatmaincart)){
				 System.out.println("OfferPercentage are matched");
			 }
			 else {
				 System.out.println("OfferPercentage are not matched");

			 }
			 
			 WebElement totalprice =driver.findElement(By.xpath("//div[@class='kQCHPX']"));
			 System.out.println(totalprice.getText());

	}
}
