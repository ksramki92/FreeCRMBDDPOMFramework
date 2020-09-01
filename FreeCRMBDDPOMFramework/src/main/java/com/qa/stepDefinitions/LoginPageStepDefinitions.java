package com.qa.stepDefinitions;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class LoginPageStepDefinitions extends TestBase
{
	LoginPage login;
	HomePage homepage;

	@Given("^user opens browser$")
	public void user_opens_browser()
	{
		TestBase.initialization();
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page()
	{
		login=new LoginPage(); //This should be done here instead of at class level as we need pagefactory to be used in subsequent steps.
		//if we create object in class level, then pagefactory will be initialized only once and will be lost when second step (login) method is called.
		String title=login.getTitle();
		Assert.assertEquals("Cogmento CRM", title);
	}

	@Then("^user logs into app$")
	public void user_logs_into_app()
	{
		homepage=login.LoginCRM(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page()
	{
		String user=homepage.validateUser();
		Assert.assertEquals("Ramki K", user);
	}

	@Then("^user clicks on logout button$")
	public void user_clicks_on_logout_button()
	{
		homepage.logout();
	}

	@Then("^user closes the browser$")
	public void user_closes_the_browser()
	{
		driver.close();
	}
}
