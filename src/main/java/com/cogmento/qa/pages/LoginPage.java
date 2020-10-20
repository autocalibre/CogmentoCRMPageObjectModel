package com.cogmento.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory OR:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(@class,'submit')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	@FindBy(xpath="//a[contains(text(),'Forgot')]")
	WebElement forgotPassword;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[contains(text(),'Classic CRM')]")
	WebElement classicCRMLink;
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	public HomePage getLogin(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public SignupPage signupLink() {
		signUpLink.click();
		
		return new SignupPage();
	}
	
	public ForgotPasswordPage forgotPasswordLink() {
		forgotPasswordLink.click();
		return new ForgotPasswordPage();
	}
	
	public ClassicCRMPage classicCRMLink() {
		classicCRMLink.click();
		return new ClassicCRMPage();
	}
}
