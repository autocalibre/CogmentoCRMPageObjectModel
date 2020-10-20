package com.cogmento.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[contains(@href,'contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(@href,'deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(@href,'tasks')]")
	WebElement tasksLink;
	
	@FindBy(css = "span.user-display")
	WebElement userNameLabel;

	// Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickContactsPageLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDealsPageLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public boolean verifyUserNameLabel() {
		return userNameLabel.isDisplayed();
	}
	
	public TasksPage clickTasksPageLink() {
		tasksLink.click();
		return new TasksPage();
	}
}
