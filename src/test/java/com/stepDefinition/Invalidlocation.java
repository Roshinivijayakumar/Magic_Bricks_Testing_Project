package com.stepDefinition;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.InvalidlocationPage;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Invalidlocation extends BaseSteps {

    InvalidlocationPage invalidlocationPage;
    ExtentTest extTest = Hooks.extTest;
    @Before("@invalidsearch")
    public void startBrowser() {
        launchBrowser();
        driver.get("https://www.magicbricks.com/");
        System.out.println("🔄 Browser launched fresh for InvalidLogin scenario");
    }

    @After("@invalidsearch")
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("✅ Browser closed after InvalidLogin scenario");
        }
    }
    
    @Given("I am on the Magicbricks home page")
    public void I_am_on_the_magicbricks_home_page() {
        invalidlocationPage = new InvalidlocationPage(driver, extTest);
        String actUrl = driver.getCurrentUrl();
        Assert.assertTrue(actUrl.contains("magicbricks.com"),
                "User is not on the Magicbricks home page. Current URL: " + actUrl);
    }

    @When("I enter {string} in the Search bar")
    public void I_enter_in_the_search_bar(String location) {
   
        boolean actResult = invalidlocationPage.enterLocation1(location);
        Assert.assertTrue(actResult, "Failed to enter location: " + location);
    }
    @When("I enter {string} in the Search")
    public void I_enter_in_the_search(String location) {
   
        boolean actResult = invalidlocationPage.enterLocation1(location);
        Assert.assertTrue(actResult, "Failed to enter location: " + location);
    }
    
    @When("I click on the Search button")
    public void i_click_on_the_search_button() {
    	    
        boolean actResult = invalidlocationPage.clickSearch2();
        Assert.assertTrue(actResult, "Failed to click on Search button");
    }

    @Then("user should remain on the home page")
    public void user_should_remain_on_the_home_page() {
        BaseSteps.sleep();
        boolean actResult = invalidlocationPage.validateStayOnHome();
        Assert.assertTrue(actResult, "User did not remain on the home page after invalid search.");
    }
}