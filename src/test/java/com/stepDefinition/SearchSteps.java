////package com.stepDefinition;
////
////public class SearchSteps {
////
////}
//package com.stepDefinition;
//
//import org.testng.Assert;
//
//import com.pages.SearchPage;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class SearchSteps extends BaseSteps {
//    SearchPage searchPage;
//
//    @Given("I am on the homepage after login")
//    public void i_am_on_the_homepage_after_login() {
//        searchPage = new SearchPage(driver);
//    }
//
//    @When("I enter {string} in the search box")
//    public void i_enter_in_the_search_box(String city) {
//        searchPage.enterCity(city);
//    }
//
//    @When("I select {string} from the dropdown")
//    public void i_select_from_the_dropdown(String city) {
//        // already handled in enterCity method
//    }
//
//    @When("I click on the Search button")
//    public void i_click_on_the_search_button() {
//        searchPage.clickSearch();
//    }
//
//    @Then("I should see the property listings for {string}")
//    public void i_should_see_the_property_listings_for(String city) {
//        boolean result = searchPage.verifyResults();
//        Assert.assertTrue(result, "Property listings not visible for " + city);
//    }
//}