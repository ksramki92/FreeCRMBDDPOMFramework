package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class LoginPage extends TestBase
{

	@FindBy(name="email")
	WebElement email;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String getTitle()
	{
		return driver.getTitle();
	}

	public HomePage LoginCRM(String username,String pwd)
	{
		email.sendKeys(username);
		password.sendKeys(pwd);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);

		return new HomePage();
	}
}
