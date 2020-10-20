package com.cogmento.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.qa.base.TestBase;

public class LandingPage extends TestBase{

	@FindBy(xpath="//a[contains(@class,'btn-xs-2')]")
	WebElement loginBtn1;
	
	@FindBy(xpath="//main[1]//section[1]//a[contains(@class,'btn-sm')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//header[1]//div[1]//nav[1]//div[2]//div[2]//div[@class='rd-navbar-brand']//a[1]//span[contains(text(),'business')]")
	WebElement brandSlogan;
	
	
	
	//Initializing the Page Objects
		public LandingPage() {
			PageFactory.initElements(driver, this);
		}
		
	//Action Class
		
		public String verifyLandingPageTitle() {
			return driver.getTitle();
		}
		
		public LoginPage clickLoginBtn() {
			loginBtn1.click();
			return new LoginPage();
		}
		
		public SignupPage signupBtn() {
			signUpBtn.click();
			return new SignupPage();
		}
		
		public String sloganText() {
			String slogantext = brandSlogan.getText();
			return slogantext;
		}
		
}
