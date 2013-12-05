package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LoginPage;

import Util.TestUtil;

import Core.Page;
import ErrorCollectors.ErrorCollector;



public class LoginTest extends testBase{
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("LoginTest",Page.excel)){
			
			throw new SkipException("Skipping the test case as the Run mode is not Y");
		}
		
		
	}
	
	
	@Test(dataProvider="getData")
	public void doLoginTest(Hashtable<String,String> data){
		
		
		LoginPage loginpage = new LoginPage();
		
		ErrorCollector.verifyEquals(loginpage.ValidateTitle(), data.get("title"));
		
		
		LandingPage landpage = loginpage.doLogin(data.get("username"), data.get("password"));
	//	MyProfilePage myprofile = landpage.gotoProfile();
	//	FriendsPage friends = myprofile.gotoFriends();
	//	Assert.assertTrue(friends.searchFriend("Mayank Sharma"), "Friend not found");
	//	System.out.println("Friend found");
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return TestUtil.getData("LoginTest", Page.excel);
		
	}

}
