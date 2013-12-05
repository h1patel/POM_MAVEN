package pages;

import org.openqa.selenium.By;

import Core.Page;

public class MyProfilePage extends Page{
	
	
	public void uploadPhoto(){
		
		
		
	}

	public FriendsPage gotoFriends(){
		
		driver.findElement(By.xpath(object.getProperty("gotofriends"))).click();
		
		return new FriendsPage();
	}
	
	
	public void gotoTimeline(){
		
		
		
	}
	
}
