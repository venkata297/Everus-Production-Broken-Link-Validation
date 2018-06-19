package source;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Getalllabels {
	
	WebDriver driver;
	
	@Test
	public void getlabel(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://everusmall.com/");
		
		List<WebElement> list1= driver.findElements(By.xpath(".//*"));
		Iterator<WebElement> i= list1.iterator();
		while(i.hasNext()){
			System.out.println(i.next().getText());
		}
	}

	
}
