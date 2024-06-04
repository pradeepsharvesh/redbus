package redbus;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bookmyticket {
	public static WebDriver driver;
	
	//@BeforeClass
   @Test
	public void launch1(){
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("disable-notifications");
		options.addArguments("disable-popups");
		options.addArguments("disable-maximized");
	    driver = new EdgeDriver(options);
	    driver.get("https://www.redbus.in/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
  
   @Test
	public void launch2(){
		String FromPlace ="chennai";
		WebElement From = driver.findElement(By.xpath("//label[text()='From']/preceding-sibling::input"));
	    From.sendKeys(FromPlace);
	    WebElement Frompl = driver.findElement(By.xpath("//text[text()='Koyambedu']"));
	    Frompl.click();

		}
   
   @Test
	public void launch3(){
		String toPlace ="bangalore";
		WebElement To = driver.findElement(By.xpath("//label[text()='To']/preceding-sibling::input"));
	    To.sendKeys(toPlace);
    WebElement Toppl = driver.findElement(By.xpath("//text[text()='Bangalore']"));
	    Toppl.click();

	}
   
   @Test
	public void launch4(){
		WebElement date = driver.findElement(By.xpath("//span[text()='4'and contains(@class,'fgdqFw')]"));
		date.click();
		
	}
   
   @Test
	public void launch6(){
		WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(),'SEARCH BUSES')]"));
		searchBtn.click();
		
	}
   @Test
   public void launch7(){
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 List<WebElement> W = driver.findElements(By.xpath("//div[contains(@class,'travel')]"));
	 List<WebElement> X = driver.findElements(By.xpath("//div[contains(@class,'dp-time')]"));
	 List<WebElement> Y = driver.findElements(By.xpath("//div[contains(@class,'bp-time')]"));
	 List<WebElement> Z = driver.findElements(By.xpath("//div[contains(@class,'d-block')]"));
	  
	 for(int i=0;i<W.size();i++) {
		 if(i ==W.size()-1){
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].scrollIntoView(true)",W.get(i));
			 js.executeScript("window.scrollTo(0,document.body.scrollHeight)",W.get(i));
			 driver.findElements(By.xpath("//div[contains(@class,'travel')]"));
			 driver.findElements(By.xpath("//div[contains(@class,'dp-time')]"));
		     driver.findElements(By.xpath("//div[contains(@class,'bp-time')]"));
	    	  driver.findElements(By.xpath("//div[contains(@class,'d-block')]"));
			  
		 }
		 else {
			 String a = W.get(i).getText();
			 String b = X.get(i).getText();
			 String c = Y.get(i).getText();
			 String d = Z.get(i).getText();
			 System.out.println("BusName :"+a +"DepartureTime :" + b+"ArrivalTime :"+c+"BusSpare :"+d);
		 }
	 }
   }
}
	


