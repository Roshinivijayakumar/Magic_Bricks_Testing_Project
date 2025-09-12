package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.objectrepository.Locators;
import com.setup.Reporter;

public class ShortlistPropertyPage {
	

//	public static By contactAgent = By.xpath("//div[@class='mb-ldp__contact-info__title--text1' and normalize-space(text())='Contact Owner']");
//	public static By viewShortlistBtn = By.xpath("//a[contains(@class,'shortlist-drop__link') and normalize-space(text())='View Your Shortlisted Properties']");
//	public static By shortlistTabHeader = By.xpath("//li[@id='m-tab-Shortlisted' and normalize-space(text())='Shortlisted']");
//	public static By shortlistedPropertyCard = By.xpath("//div[@id='propertiesAction80571739']/ancestor::div[contains(@class,'mb-srp__card')]");
//	public static By shortlistButton = By.xpath("//span[@class='mb-srp__card__sort--icon']");
//	public static By mainshortlistbtn = By.xpath("//span[@class='mb-header__main__shortlist__cta']");
//	public static By sortBy = By.xpath("//div[@class='mb-srp__tabs__sortby--title']");
//	public static By mostrecent = By.xpath("//li[contains(@class,'mb-srp__tabs__sortby__dd__list--item') and normalize-space(text())='Most Recent']");

	// Contact Owner / Agent
	public static By contactAgent = By.xpath("//div[contains(@class,'contact-info__title') and contains(.,'Contact')]");

	// View Shortlist Button
	public static By viewShortlistBtn = By.xpath("//a[contains(.,'View Your Shortlisted Properties')]");

	// Shortlisted Tab Header
	public static By shortlistTabHeader = By.xpath("//li[contains(@id,'Shortlisted') and normalize-space(text())='Shortlisted']");

	// First Shortlisted Property Card
//	public static By shortlistedPropertyCard = By.xpath("(//div[contains(@class,'mb-srp__card')])[1]");
	// First shortlisted property card in Shortlist Tab
	public static By shortlistedPropertyCard = By.xpath("(//div[@class='shortlist-wrapper']//div[contains(@class,'mb-srp__card')])[1]");

	// Shortlist (Heart) Icon inside card
	public static By shortlistButton = By.xpath("//span[contains(@class,'mb-srp__card__sort--icon')]");

	// Main Shortlist Button (top header)
	public static By mainshortlistbtn = By.xpath("//div[contains(@class,'mb-header__main__shortlist')]//span[contains(@class,'shortlist__cta')]");

	// Sort By dropdown
	public static By sortBy = By.xpath("//div[contains(@class,'mb-srp__tabs__sortby--title')]");

	// Sort By → Most Recent option
	public static By mostrecent = By.xpath("//li[contains(.,'Most Recent')]");


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
    public boolean viewShortlistedProperties() {
        try {
            WebElement viewShortlistBtn1 = wait.until(ExpectedConditions.elementToBeClickable( viewShortlistBtn));
            viewShortlistBtn1.click();
         
            // Get all window handles
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
            
            // Switch to the new tab (assuming it's the second one)
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(tabs.size()-1));
                Reporter.generateReport(driver, extTest, Status.PASS, "Shortlisted Property page. Current URL: " + driver.getCurrentUrl());
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to a new tab. Only one tab was found.");
                return false;
            }

            // Validate the presence of the new tab's header using the specific locator
            WebElement shortlistedTabHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(shortlistTabHeader));
            if (shortlistedTabHeader.isDisplayed()) {
                Reporter.generateReport(driver, extTest, Status.PASS, "Successfully navigated to the shortlisted properties");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to navigate to the shortlisted properties page. Header not found.");
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
            WebElement firstProperty = wait.until(ExpectedConditions.elementToBeClickable(shortlistedPropertyCard));
            firstProperty.click();
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
            
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(tabs.size()-1));
                Reporter.generateReport(driver, extTest, Status.PASS, "Switched to the property details tab.Current URL: " + driver.getCurrentUrl());
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to the property details tab.");
                return false;
            }

            
            
        
            Reporter.generateReport(driver, extTest, Status.PASS, "Selected first shortlisted property.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on the first shortlisted property: " + e.getMessage());
            return false;
        }
    }
//    public boolean sortByFilter() {
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    	try {
//    		WebElement shortlistBtn1 = wait.until(ExpectedConditions.elementToBeClickable(sortBy));
//    	    shortlistBtn1.click();
//    	    WebElement shortlistBtn2 = wait.until(ExpectedConditions.elementToBeClickable(mostrecent));
//    	    shortlistBtn2.click();
//    	    Reporter.generateReport(driver, extTest, Status.PASS, "Sortby most recent filter clicked");
//            return true;
//    	}
//    	 catch (Exception e) {
//             Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the main shortlist button: " + e.getMessage());
//             return false;
//    	 }
//    }

//    public boolean shortlistPropertyFromList() {
//        try {
//            WebElement shortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(shortlistButton));
//            
//            // In case it only shows on hover
//            Actions actions = new Actions(driver);
//            actions.moveToElement(shortlistBtn).perform();        
//            shortlistBtn.click();
//    
//            WebElement mainShortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(mainshortlistbtn));
//            mainShortlistBtn.click();
//
//            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the main shortlist button.");
//            return true;
//        } catch (Exception e) {
//            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the main shortlist button: " + e.getMessage());
//            return false;
//        }
//    }
    public boolean sortByFilter() {
        try {
            // Click Sort By dropdown
            WebElement sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(sortBy));
            sortDropdown.click();

            // Click Most Recent option
            WebElement mostRecentOption = wait.until(ExpectedConditions.elementToBeClickable(mostrecent));
            mostRecentOption.click();

            // Wait until the property list is refreshed
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(@class,'loader')]"))); // loader if present

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[contains(@class,'mb-srp__card')])[1]")));

            Reporter.generateReport(driver, extTest, Status.PASS, "Sort By 'Most Recent' applied and listing reloaded.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to apply Sort By Most Recent: " + e.getMessage());
            return false;
        }
    }

    public boolean shortlistPropertyFromList() {
        try {
            // Ensure first property card is visible
            WebElement firstProperty = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[contains(@class,'mb-srp__card')])[1]")));

            // Now hover + click shortlist
            WebElement shortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(shortlistButton));
            new Actions(driver).moveToElement(firstProperty).perform();
            shortlistBtn.click();

            WebElement mainShortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(mainshortlistbtn));
            mainShortlistBtn.click();

            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully shortlisted the first property.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to shortlist property: " + e.getMessage());
            return false;
        }
    }


    
    public boolean viewcontactAgentIsPresent() {
    	
    	try {
       	 WebElement contactagent = wait.until(ExpectedConditions.visibilityOfElementLocated(contactAgent));
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