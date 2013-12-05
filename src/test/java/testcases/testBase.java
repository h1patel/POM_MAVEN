package testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Core.Page;

public class testBase {
	
	@AfterSuite
	public void setUp(){
		
		Page.tearDown();
		
	}

}
