package path;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Watsup {

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
		
		//span[@role='button']
		

	}

}
