package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.setup.Reporter;

public class ShortlistPropertyPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public ShortlistPropertyPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }

    /**
     * Clicks the "View Shortlisted Properties" button, switches to the new tab,
     * and validates the page title.
     * @return true if the action is successful, false otherwise.
     */
//    public boolean viewShortlistedProperties() {
//        try {
//            WebElement viewShortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.viewShortlistBtn));
//            viewShortlistBtn.click();
//            
//            // Get all window handles
//            Set<String> allWindowHandles = driver.getWindowHandles();
//            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
//            
//            // Switch to the new tab (assuming it's the second one)
//            if (tabs.size() > 3) {
//                driver.switchTo().window(tabs.get(2));
//                Reporter.generateReport(driver, extTest, Status.PASS, "Shortlisted Property page. Current URL: " + driver.getCurrentUrl());
//            } else {
//                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to a new tab. Only one tab was found.");
//                return false;
//            }
//
//            // Validate the presence of the new tab's header using the specific locator
//            WebElement shortlistedTabHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.shortlistTabHeader));
//            if (shortlistedTabHeader.isDisplayed()) {
//                Reporter.generateReport(driver, extTest, Status.PASS, "Successfully navigated to the shortlisted properties");
//                return true;
//            } else {
//                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to navigate to the shortlisted properties page. Header not found.");
//                return false;
//            }
//        } catch (Exception e) {
//            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to view shortlisted properties: " + e.getMessage());
//            return false;
//        }
//    }
    public boolean viewShortlistedProperties() {
        try {
            // Step 1: Capture existing tabs
            List<String> originalTabs = new ArrayList<>(driver.getWindowHandles());
            if (originalTabs.size() < 3) {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Expected at least 3 tabs to be open before clicking.");
                return false;
            }

            // Step 2: Switch to the 3rd tab (index 2)
            driver.switchTo().window(originalTabs.get(2));

            // Step 3: Click the button that opens the 4th tab
            WebElement viewShortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.viewShortlistBtn));
            viewShortlistBtn.click();

            // Step 4: Wait until a new tab appears (4th tab)
            wait.until(driver -> driver.getWindowHandles().size() > originalTabs.size());

            // Step 5: Identify the new tab
            Set<String> allWindowHandles = driver.getWindowHandles();
            allWindowHandles.removeAll(originalTabs); // Get only the new tab
            if (allWindowHandles.size() != 1) {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Unexpected number of new tabs opened.");
                return false;
            }

            String newTab = allWindowHandles.iterator().next();
            driver.switchTo().window(newTab);

            // Step 6: Validate presence of element in the new tab
            WebElement shortlistedTabHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.shortlistTabHeader));
            if (shortlistedTabHeader.isDisplayed()) {
                Reporter.generateReport(driver, extTest, Status.PASS, "Successfully navigated to the shortlisted properties in the 4th tab.");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Header not found in the newly opened tab.");
                return false;
            }

        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to view shortlisted properties: " + e.getMessage());
            return false;
        }
    }


    /**
     * Clicks on the first shortlisted property in the listing.
     * @return true if the property is clicked successfully, false otherwise.
     */
    public boolean clickFirstShortlistedProperty() {
        try {
            // Use the more specific locator for the first property
            WebElement firstProperty = wait.until(ExpectedConditions.elementToBeClickable(Locators.shortlistedPropertyCard));
            firstProperty.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Selected first shortlisted property.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on the first shortlisted property: " + e.getMessage());
            return false;
        }
    }
//    public boolean sortByFilter() {
//    	try {
//    		WebElement shortlistBtn1 = wait.until(ExpectedConditions.elementToBeClickable(Locators.sortBy));
//    	    shortlistBtn1.click();
//    	    WebElement shortlistBtn2 = wait.until(ExpectedConditions.elementToBeClickable(Locators.mostrecent));
//    	    shortlistBtn2.click();
//    	    Reporter.generateReport(driver, extTest, Status.PASS, "Sortby most recent filter clicked");
//            return true;
//    	}
//    	 catch (Exception e) {
//             Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the main shortlist button: " + e.getMessage());
//             return false;
//    	 }
//    }
//    public boolean sortByFilter() {
//        try {
//            // Wait for Sort By dropdown
//            WebElement sortBy = wait.until(ExpectedConditions.elementToBeClickable(Locators.sortBy));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sortBy);
//            sortBy.click();
//            Reporter.generateReport(driver, extTest, Status.INFO, "Clicked on Sort By dropdown");
//
//            // Wait for "Most Recent" option and click
//            WebElement mostRecent = wait.until(ExpectedConditions.elementToBeClickable(Locators.mostrecent));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mostRecent);
//
//            Reporter.generateReport(driver, extTest, Status.PASS, "Sort By filter set to Most Recent");
//            return true;
//        } catch (Exception e) {
//            Reporter.generateReport(driver, extTest, Status.FAIL,
//                "Failed to select Sort By → Most Recent: " + e.getMessage());
//            return false;
//        }
//    }

    public boolean shortlistPropertyFromList() {
        try {
        	   
          	WebElement shortlistBtn1=wait.until(ExpectedConditions.elementToBeClickable(Locators.shortlistButton));
          	shortlistBtn1.click();
            WebElement shortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.mainshortlistbtn));
            shortlistBtn.click();
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the main shortlist button.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the main shortlist button: " + e.getMessage());
            return false;
        }
    }
    public boolean viewcontactAgentIsPresent() {
     	try {
        	 WebElement contactagent = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.contactAgent));
             if (contactagent.isDisplayed()) {
                 Reporter.generateReport(driver, extTest, Status.PASS, "View contact Agent element is present on the page:");
                 return true;
             } else {
                 Reporter.generateReport(driver, extTest, Status.FAIL, "View contact Agent element is not present on the page:");
                 return false;
             }
         } catch (Exception e) {
             Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to view shortlisted properties: " + e.getMessage());
             return false;
         }
    }
}