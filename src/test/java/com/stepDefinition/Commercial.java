package com.stepDefinition;

import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.pages.CommercialPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class Commercial extends BaseSteps {

    CommercialPage commercialPage;
    ExtentTest extTest = Hooks.extTest;
    static String[][] excelData;

    @Given("the user is on the MagicBricks homepage")
    public void the_user_is_on_the_magicbricks_homepage() {	
    	 commercialPage = new CommercialPage(driver, extTest);
         String actUrl = driver.getCurrentUrl();
         Assert.assertTrue(actUrl.contains("magicbricks.com"),
         "User is not on the Magicbricks home page. Current URL: " + actUrl);
         if(excelData == null) {
 			excelData = ExcelReader.readdata();
 		}	
    }

    @When("the user navigates to the Commercial tab")
    public void the_user_navigates_to_the_commercial_tab() {
        commercialPage.clickCommercialTab();
    }

    @When("the user selects {string} option")
    public void the_user_selects_option(String lease) {
        commercialPage.selectLease();
    }

    @When("the user enters location as {string} in the Search bar")
    public void the_user_enters_location_as_in_the_search_bar(String location) throws InterruptedException {
    	int row = Hooks.firstrow;
	    location = excelData[row][0];
    	boolean actResult = commercialPage.enterLocation1(location);
        Assert.assertTrue(actResult, "Failed to enter location: " + location);
    }

    @When("the user selects the Property Type from drop down")
    public void the_user_selects_the_property_type_from_drop_down() {
        boolean actResult = commercialPage.selectPropertyType1();
        Assert.assertTrue(actResult, "Failed to select property type " );
    }
    
    @When("the user selects budget range from drop down")
    public void the_user_selects_budget_range_from_drop_down() {
    	boolean actResult = commercialPage.selectBudget1();
        Assert.assertTrue(actResult, "Failed to select budget from dropdown");
    }

    @When("the user clicks on Search")
    public void the_user_clicks_on_search() {
        boolean actResult = commercialPage.clickSearch1();
        Assert.assertTrue(actResult, "Failed to click Search button");
    }
}
