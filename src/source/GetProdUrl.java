package source;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GetProdUrl {
	
	WebDriver driver;
	
	@Test
	public void getProdUrl(){
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		String URL="https://everus.org/";
		driver.get(URL);
		verifyLinkActive("https://everus.org/");
	}
	
	public void verifyLinkActive(String Url){
    	try{
    		URL url1=new URL(Url);
    		HttpURLConnection httpurlconnect= (HttpURLConnection)url1.openConnection();
    		httpurlconnect.setConnectTimeout(3000);
    		httpurlconnect.connect();
    		if(httpurlconnect.getResponseCode()==200){
    			System.out.println(Url+" -"+ httpurlconnect.getResponseMessage());
    		}
    		if(httpurlconnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
    			System.out.println(Url+" - "+httpurlconnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
    		}
    	}
	     catch(Exception e){
    		System.out.println("Exception is" + e);
    	}
	}
    
    	@AfterTest
    	public void closeBrowser(){
    		driver.close();
    	}

}
