package pages;



import Core.Page;

public class topNavigation {
	
	
	public void LogOut(){
		
		
		
	}
	
	public void searchContext(){
		
		
	}
	
	public LandingPage gotoHome(){
		
		//Assert.assertTrue(Page.isElementPresent("homepage"), "Home Page Element not found");
		Page.click("homepage");
		return new LandingPage();
		
	}
	

}
