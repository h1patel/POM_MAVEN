package testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.EditProfilePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyProfilePage;

import Core.Page;
import Util.TestUtil;

public class UploadaPicTest extends testBase {
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("UploadaPicTest",Page.excel)){
			
			throw new SkipException("Skipping the test case as the Run mode is not Y");
		}
		
		
	}
	
	@Test(dataProvider="getData")
	public void uploadPic(Hashtable<String,String> data){
		
		LandingPage landpage = Page.topNav.gotoHome();
		EditProfilePage editprofile = landpage.editProfile();
		editprofile.ChangePic(data.get("path"));
		
		
		
	
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		return TestUtil.getData("UploadaPicTest", Page.excel);
		
	}

}
