package Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import pages.topNavigation;

import Util.Xls_Reader;

public class Page {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties object = new Properties();
	public static FileInputStream fis;
	public static Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.xlsx");;
	public static topNavigation topNav = null;
	
	
	public Page() {
	
		
	
	try {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		config.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	try {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\object.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		object.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
				
		if(driver == null){
			
			
			if(config.getProperty("browser").equals("firefox")){
				
				driver = new FirefoxDriver();
			}else if(config.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
				
			}else if(config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			driver.get(config.getProperty("testsite"));
			driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
			topNav = new topNavigation();
			
			
		}
		
	}
	
	public boolean isLinkPresent(String linkText){
		
		try{
			
			driver.findElement(By.linkText(linkText));
			return true;
			
		}catch(Throwable t){
			
			return false;
			
		}
		
	}
	
	
	public static boolean isElementPresent(String xpath){
		
		try{
			
			driver.findElement(By.xpath(object.getProperty(xpath)));
			return true;
			
		}catch(Throwable t){
			
			return false;
			
		}
		
	}
	
	
	
	public static void click(String xpath){
		
	//	try{
			
			driver.findElement(By.xpath(object.getProperty(xpath))).click();
			
			
		//}catch(Throwable t){
			
		//error report
			
		//}
		
		
	}
	
	
	public static void tearDown(){
		
		driver.quit();
	}
	

}
