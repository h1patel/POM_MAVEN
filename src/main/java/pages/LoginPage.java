package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import Core.Page;

public class LoginPage extends Page {
	
	
	public static String ValidateTitle(){
		
		
			
			return driver.getTitle();
		
	}
	
	


	public LandingPage doLogin(String username, String password){
		
		
		driver.findElement(By.xpath(object.getProperty("username"))).sendKeys(username);
		driver.findElement(By.xpath(object.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(object.getProperty("login"))).click();
		
		return new LandingPage();
		
	}
	
	
	
	

}
