package pages;

import org.openqa.selenium.By;


import Core.Page;

public class EditProfilePage extends Page{
	
	
	
	public void ChangePic(String path){
		
		//Assert.assertTrue(isElementPresent("editprofilepicture"), "Edit profile Element not found");
		click("editprofilepicture");
		
		driver.findElement(By.name("pic")).sendKeys(path);
	}
	
	public void UpdateInfo(){
		
		
		
	}
	
	
	public void AddaCover(){
		
		
		
	}

}
