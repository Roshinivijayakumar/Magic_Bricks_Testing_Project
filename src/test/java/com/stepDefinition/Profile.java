package com.stepDefinition;

import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps{
	HomePage homePage;
	LoginPage loginPage;
	
	@Given("the user is on home page and gives login")
	public void the_user_is_on_home_page() {
		launchBrowser();
        homePage = new HomePage(driver);
        boolean hovered = homePage.hoverLoginDropdown();
        Assert.assertTrue(hovered, "Login dropdown was not clickable!");

        boolean buttonClicked = homePage.clickLoginButton();
        Assert.assertTrue(buttonClicked, "Login button was not clickable!");
	}
	
	@When("I am directed to the login page and click on phonenumber")
	public void i_am_redirected_to_the_login_page_and_click_on_phonenumber() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.switchToLoginTab();
		loginPage.clickphonenumber();
	}
	@When("I enter the otp")
	public void i_enter_the_otp() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterotp();
		boolean actResult =loginPage.validateLogin();
		Assert.assertTrue(actResult);
	}	
}
