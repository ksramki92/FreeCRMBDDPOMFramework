package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase
{
	@FindBy(xpath="//div[@class='right menu']//span[@class='user-display']")
	WebElement user;

	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contacts;

	@FindBy(xpath="//div[@role='listbox']")
	WebElement logoutLink;

	@FindBy(xpath="//span[text()='Log Out']")
	WebElement logoutBtn;


	HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateUser()
	{
		return user.getText();
	}

	public String validateTitle()
	{
		return driver.getTitle();
	}

	public void clickOnContactsLink()
	{
		contacts.click();
	}

	public void logout()
	{
		logoutLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		logoutBtn.click();
	}

}