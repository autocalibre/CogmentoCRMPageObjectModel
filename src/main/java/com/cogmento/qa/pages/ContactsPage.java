package com.cogmento.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactsLabel;

	@FindBy(css = "input[type='checkbox']")
	WebElement selectAllCheckBox;
	
	@FindBy(xpath="//a[contains(@href,'contacts/new')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath="//div[@class='item']//button[@class='ui linkedin button']")
	WebElement saveBtn;

	// Initializing the Page Objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	//Action Classes
	
	public String verifyContactsLabel() {
		return contactsLabel.getText();
	}
	
	public boolean clickSelectAllCB() {
		selectAllCheckBox.click();
		return selectAllCheckBox.isSelected();
	}
	
	public void clickNewContactLink() {
		newContactLink.click();
	}
	
	public void createNewContact(String ftName, String ltName, String comp) {
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		company.sendKeys(Keys.ENTER);
		saveBtn.click();
	}
}
