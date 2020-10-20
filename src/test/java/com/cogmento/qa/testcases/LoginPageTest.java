package com.cogmento.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cogmento.qa.base.TestBase;
import com.cogmento.qa.pages.ForgotPasswordPage;
import com.cogmento.qa.pages.HomePage;
import com.cogmento.qa.pages.LandingPage;
import com.cogmento.qa.pages.LoginPage;
import com.cogmento.qa.pages.SignupPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	LandingPage landingPage;
	ForgotPasswordPage forgotPasswordPage;
	SignupPage signUpPage;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		log.info("*****************LOGINPAGE TESTCASES*****************");
		initialization();
		log.info("Successfully initialized the browser and navigated to the URL");
		landingPage = new LandingPage();
		loginPage = landingPage.clickLoginBtn();
		log.debug("Successfully clicked on login button and navigated to login page");
		
	}
	
	@Test(priority=1)
	public void loginTest() {
		log.info("**************Starting loginTest TestCase**************");
		homePage = loginPage.getLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.debug("Successfully entered username, password and clicked on submit and navigated to HomePage");
		log.info("**************Ending loginTest TestCase**************");
	}
	
	@Test(priority=2)
	public void forgotPasswordLinkTest() {
		log.info("**************Starting forgotPasswordLinkTest TestCase**************");
		forgotPasswordPage = loginPage.forgotPasswordLink();
		log.debug("Successfully clicked on forgot password link and navigated to forgot password page");
		log.info("**************Ending forgotPasswordLinkTest TestCase**************");
	}
	
	@Test(priority=3)
	public void signupLinkTest() {
		log.info("**************Starting signupLinkTest TestCase**************");
		signUpPage = loginPage.signupLink();
		log.debug("Successfully clicked on sign up link and navigated to sign up page");
		log.info("**************Ending signupLinkTest TestCase**************");
	}
	
	@AfterMethod
	public void tearDown() {
		log.info("*****************END OF LOGINPAGE TESTCASES*****************");
		driver.quit();
		log.info("Browser is closed");
	}
}
