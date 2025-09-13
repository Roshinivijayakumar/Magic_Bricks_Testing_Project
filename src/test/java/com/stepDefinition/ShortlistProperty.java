package com.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.ShortlistPropertyPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ShortlistProperty extends BaseSteps {
	ShortlistPropertyPage shortlistPage;
	ExtentTest extTest = Hooks.extTest;

	@Given("the user is on the property listing page")
	public void the_user_is_on_the_property_listing_page() {

	}

	@When("clicks on sortby and selects most recent filter")
	public void clicks_on_sortby_and_selects_most_recent_filter() {
		shortlistPage = new ShortlistPropertyPage(driver, Hooks.extTest);
		BaseSteps.sleep();
		boolean actResult = shortlistPage.sortByFilter();
		Assert.assertTrue(actResult, "Failed to select sortby mostrecent filter.");
	}

	@When("I shortlist the first property from the listing")
	public void i_shortlist_the_first_property_from_the_listing() {
		shortlistPage = new ShortlistPropertyPage(driver, Hooks.extTest);
		boolean actResult = shortlistPage.shortlistPropertyFromList();
		Assert.assertTrue(actResult, "Failed to shortlist the first property from the listing.");

	}
}