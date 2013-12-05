package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Core.Page;

public class LandingPage extends Page {
	
	public void updateStatus(){
		
		
	}
	
	public MyProfilePage gotoProfile(){
		
		driver.findElement(By.xpath(object.getProperty("gotoprofile"))).click();
		
		return new MyProfilePage();
	}
	
	
	public EditProfilePage editProfile(){
		
		
		click("editprofile");
		
		return new EditProfilePage();
		
	}
	
}
