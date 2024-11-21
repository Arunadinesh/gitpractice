package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class gmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver(); 
	      driver.manage().window().maximize();
	      driver.get("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      //Thread.sleep(3000);
	    //a[contains(@class,'medium header__aside__button')]
	      //driver.findElement(By.xpath("//a[contains(@class,'medium header__aside__button')]")).click();
	      //driver.findElement(By.xpath("(//input)[1]")).sendKeys("arunamohan0305@gmail.com");
	      //driver.findElement(By.xpath("(//button)[3]")).click();
	      
	     // "//div[@data-primary-action-label = 'Next']//button//span[contains(text(), \"Next\")]"
	      
	     // driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Dina@0305");
	     // driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();
	      //compose
	      ////driver.findElement(By.xpath("//div[@class=\"aic\"]//div[@role=\"button\"]")).click();
	      //compose page
	     //driver.findElement(By.xpath("//input[@id=\":tm\"]")).sendKeys("gopikugan16@gmail.com");
	     //driver.findElement(By.xpath("//input[@name=\"subjectbox\"]")).sendKeys("Automation Task");

	      



	}

}
