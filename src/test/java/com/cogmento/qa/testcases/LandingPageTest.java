package com.cogmento.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cogmento.qa.base.TestBase;
import com.cogmento.qa.pages.LandingPage;
import com.cogmento.qa.pages.LoginPage;
import com.cogmento.qa.pages.SignupPage;

public class LandingPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	SignupPage signupPage;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	public LandingPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		log.info("*****************LANDINGPAGE TESTCASES*****************");
		initialization();
		log.info("Successfully initialized the browser and navigated to the URL");
		landingPage = new LandingPage();
	}

	@Test(priority = 1)
	public void verifyTitleTest() {
		log.info("**************Starting verifyLandingPageTitleTest TestCase**************");
		String landingPageTitle = landingPage.verifyLandingPageTitle();
		Assert.assertEquals(landingPageTitle, "Cogmento CRM and Business Cloud Solutions",
				"Landing Page title not matched");
		log.info("Successfully verified Landing Page Title");
		log.info("**************Ending verifyLandingPageTitleTest TestCase**************");

	}

	@Test(priority = 2)
	public void verifySloganTextTest() {
		log.info("**************Starting verifySloganTextTest TestCase**************");
		String slogantext = landingPage.sloganText();
		Assert.assertEquals(slogantext, "YOUR BUSINESS CLOUD PARTNER", "Slogan Text not matched");
		log.info("Successfully verified Slogan text");
		log.info("**************Ending verifySloganTextTest TestCase**************");
	}

	@Test(priority = 3)
	public void signUpBtnTest() {
		log.info("**************Starting signUpBtnTest TestCase**************");
		signupPage = landingPage.signupBtn();
		log.debug("Successfully clicked on sign up button and navigated to sign up page");
		log.info("**************Ending signUpBtnTest TestCase**************");
	}

	@Test(priority = 4)
	public void loginBtnTest() {
		log.info("**************Starting loginBtnTest TestCase**************");
		loginPage = landingPage.clickLoginBtn();
		log.debug("Successfully clicked on login button and navigated to login page");
		log.info("**************Ending loginBtnTest TestCase**************");
	}

	@AfterMethod
	public void teardown() {
		log.info("*****************END OF LANDINGPAGE TESTCASES*****************");
		driver.quit();
		log.info("Browser is closed");
	}
}
