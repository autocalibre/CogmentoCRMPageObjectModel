package com.cogmento.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cogmento.qa.base.TestBase;
import com.cogmento.qa.pages.ContactsPage;
import com.cogmento.qa.pages.HomePage;
import com.cogmento.qa.pages.LandingPage;
import com.cogmento.qa.pages.LoginPage;
import com.cogmento.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {
		log.info("*****************CONTACTSPAGE TESTCASES*****************");
		initialization();
		log.info("Successfully initialized the browser and navigated to the URL");
		landingPage = new LandingPage();
		loginPage = landingPage.clickLoginBtn();
		log.debug("Successfully clicked on the Login button and navigated to login page");
		homePage = loginPage.getLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.debug("Successfully entered username, password, clicked on submit and navigated to HomePage");
		contactsPage = homePage.clickContactsPageLink();
		log.debug("Successfully clicked on contacts link and navigated to contacts page");
	}

	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		log.info("**************Starting verifyContactsLabelTest TestCase**************");
		Assert.assertEquals(contactsPage.verifyContactsLabel(), "Contacts");
		log.info("Successfully verified contacts label");
		log.info("**************Ending verifyContactsLabelTest TestCase**************");
	}

	@Test(priority = 2)
	public void clickSelectAllCBTest() {
		log.info("**************Starting clickSelectAllCBTest TestCase**************");
		Assert.assertTrue(contactsPage.clickSelectAllCB(), "SelectAll checkbox is not enabled");
		log.debug("Successfully clicked select all checkbox");
		log.info("**************Ending clickSelectAllCBTest TestCase**************");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void createNewContactTest(String firstName, String lastName, String company) {
		log.info("**************Starting createNewContactTest TestCase**************");
		contactsPage.clickNewContactLink();
		log.debug("Successfully clicked new contact button ");
		contactsPage.createNewContact(firstName, lastName, company);
		log.debug("Successfully entered firstname, lastname, company name and clicked on save button");
		log.info("**************Ending createNewContactTest TestCase**************");
	}

	@AfterMethod()
	public void tearDown() {
		log.info("*****************END OF CONTACTSPAGE TESTCASES*****************");
		driver.quit();
		log.info("Browser is closed");
	}
}
