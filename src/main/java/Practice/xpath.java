package Practice;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	      WebDriver driver = new ChromeDriver(); 
	      driver.manage().window().maximize();
	      driver.get("https://www.flipkart.com/");
	      try {
	    	    Thread.sleep(5000);
	    	} catch(InterruptedException e) {
	    	    System.out.println("got interrupted!");
	    	}
	      //Thread.sleep(3000);

	      String text = driver.findElement(By.xpath("(//div[contains(@class,'emupdz')]//img//preceding::div[3])[2]")).getText();
	    //String text = driver.findElement(By.xpath("(//div[contains(@class,'emupdz')]//img//preceding::div[3])")).getText();
		 //String text = driver.findElement(By.xpath("(//div[contains(@class,'emupdz')]//img)")).getText();
	      System.out.println("Categorey "+ text);
	List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'emupdz')]//img//preceding::div[3]")); 
    System.out.println("Number of elements:" +elements.size());
for(int i=0; i<elements.size();i++) {
    System.out.println("Categories text:" + elements.get(i).getText());

}


	}

}
