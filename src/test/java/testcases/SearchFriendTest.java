package testcases;

import java.util.Hashtable;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FriendsPage;
import pages.LandingPage;
import pages.MyProfilePage;

import Core.Page;
import Util.TestUtil;

public class SearchFriendTest  extends testBase {
	
	

	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("SearchFriendTest",Page.excel)){
			
			throw new SkipException("Skipping the test case as the Run mode is not Y");
		}
		
		
	}
	
	
	@Test(dataProvider="getData")
	public void searchforfriend(Hashtable<String, String> data){
		


		LandingPage landpage = Page.topNav.gotoHome();
		MyProfilePage myprofile = landpage.gotoProfile();
		FriendsPage friends = myprofile.gotoFriends();
		Assert.assertTrue(friends.searchFriend(data.get("friendname")), "Friend not found");
		System.out.println("Friend found");
		
		
		
	}

	
	

	@DataProvider
	public Object[][] getData(){
		
		return TestUtil.getData("SearchFriendTest", Page.excel);
		
	}

	
}
