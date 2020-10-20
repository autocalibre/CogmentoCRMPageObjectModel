package com.cogmento.qa.testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cogmento.qa.base.TestBase;
import com.cogmento.qa.pages.ContactsPage;
import com.cogmento.qa.pages.HomePage;
import com.cogmento.qa.pages.LandingPage;
import com.cogmento.qa.pages.LoginPage;



public class HomePageTest extends TestBase{
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("*****************HOMEPAGE TESTCASES*****************");
		initialization();
		log.info("Successfully initialized the browser and navigated to the URL");
		landingPage = new LandingPage();
		loginPage = landingPage.clickLoginBtn();
		log.debug("Successfully clicked on the Login button and navigated to login page");
		homePage = loginPage.getLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.debug("Successfully entered username, password, clicked on submit and navigated to HomePage");
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		log.info("**************Starting verifyHomePageTitleTest TestCase**************");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,prop.getProperty("homepagetitle"), "HomePage title not matched");
		log.info("Successfully verified Home Page Title");
		log.info("**************Ending verifyHomePageTitleTest TestCase**************");

	}
	
	@Test
	public void verifyUserNameLabelTest() {
		log.info("**************Starting verifyUserNameLabelTest TestCase**************");
		Assert.assertTrue(homePage.verifyUserNameLabel(),"Username is not matched");
		log.info("Successfully verified Username Label");
		log.info("**************Ending verifyUserNameLabelTest TestCase**************");
	}
	
	@Test
	public void contactsPageLinkTest() {
		log.info("**************Starting contactsPageLinkTest TestCase**************");
		contactsPage = homePage.clickContactsPageLink();
		log.debug("Successfully clicked on contacts link and navigated to contacts page");
		log.info("**************Ending contactsPageLinkTest TestCase**************");

	}
	
	@AfterMethod
	public void tearDown() {
		log.info("*****************END OF HOMEPAGE TESTCASES*****************");
		driver.quit();
		log.info("Browser is closed");
	}
}
