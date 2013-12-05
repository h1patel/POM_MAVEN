package pages;

import org.openqa.selenium.By;

import Core.Page;

public class FriendsPage extends Page {

	
	
	public boolean searchFriend(String FriendName){
		
		
		
		driver.findElement(By.xpath("//input[@class='inputtext']")).sendKeys(FriendName);
		
		if(isLinkPresent(FriendName)){
			
			return true;
		}else{
			
			return false;
		}
		
	}
	
	
}
