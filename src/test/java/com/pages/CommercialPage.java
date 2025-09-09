//package com.pages;
//
//import org.openqa.selenium.WebDriver;
//
//import com.objectrepository.Locators;
//
//public class CommercialPage {
//	   WebDriver driver;
//
//	    public CommercialPage(WebDriver driver) {
//	        this.driver = driver;
//	    }
//
//	    public void selectCommercialOption() {
//	        driver.findElement(Locators.commercialOption).click();
//	    }
//
//	    public void selectPropertyTypeOfficeSpace() {
//	        driver.findElement(Locators.propertyTypeDropdown).click();
//	        driver.findElement(Locators.officeSpaceOption).click();
//	    }
//	    public void selectMaxMinBudget() {
//	    	driver.findElement(Locators.minBudget).click();
//	    	driver.findElement(Locators.maxBudget).click();
//	    }
//	    public void clickSearchButton() {
//	    	driver.findElement(Locators.searchButton).click();
//	    }
//}
