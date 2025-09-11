package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.setup.Reporter;


public class CommercialPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public CommercialPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }

    // Enter location
    /**
     * Clicks the close button to remove the default location.
     * @return true if the close button is clicked successfully, false otherwise.
     */
    public CommercialPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCommercialTab() {
        driver.findElement(Locators.commercialTab).click();
    }
    
    public void selectLease() {
    	driver.findElement(Locators.leaseDropdown).click();
        driver.findElement(Locators.leaseOption).click();
    }
    
    public boolean enterLocation1(String location) {
        try {
        	
            WebElement locationBox = wait.until(ExpectedConditions.elementToBeClickable(Locators.enterlocation));
            locationBox.sendKeys(location);
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered location: " + location);
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter location: " + e.getMessage());
            return false;
        }
    }
//    
    //use below code for invalid location test
//    public boolean enterLocation1(String location) {
//        try {
//    		  
//    		  WebElement locationBox = wait.until(ExpectedConditions.elementToBeClickable(Locators.enterlocation));
//    		  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", locationBox); 
//    		  WebElement locationBox1 =wait.until(ExpectedConditions.elementToBeClickable(Locators.crossloc));
//    		  ((JavascriptExecutor) driver).executeScript("arguments[0].click();",locationBox1); 
//    		  locationBox.clear(); 
//    		  locationBox.sendKeys(location);
//    		//  WebElement locationBox2 =wait.until(ExpectedConditions.elementToBeClickable(Locators.selectdropdownloc));
//    		 // ((JavascriptExecutor) driver).executeScript("arguments[0].click();",locationBox2); 
//
//
//    		  
//    		  Reporter.generateReport(driver, extTest, Status.PASS, "Entered location: " +
//    		  location); return true; } catch (Exception e) {
//    		  Reporter.generateReport(driver, extTest, Status.FAIL,
//    		  "Failed to enter location: " + e.getMessage()); return false;
//    		  
//    	
//    }
//    }
    
    public boolean selectPropertyType1() {
        try {
            // Step 1: Open dropdown
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickPropertType1));
            dropdown.click();
            Reporter.generateReport(driver, extTest, Status.INFO, "Opened Property Type dropdown");

            // Step 2: Select Office Space (checkbox)
            WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.selectPropertyType1));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
            Reporter.generateReport(driver, extTest, Status.INFO, "Selected 'Office Space'");

            // Step 3: Close dropdown (click outside)
            driver.findElement(By.xpath("//body")).click();

            Reporter.generateReport(driver, extTest, Status.PASS, "Property type selection successful");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to select property type: " + e.getMessage());
            return false;
        }
    }
    
    public boolean selectBudget1() {
        try {
            // Open budget dropdown
            WebElement budgetDropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickBudget1));
            budgetDropdown.click();

            try {
                // --- First try with sendKeys ---
                WebElement minInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("budgetMin")));
                WebElement maxInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("budgetMax")));

                minInput.clear();
                minInput.sendKeys("100000"); // Min = 1 Lac
                maxInput.clear();
                maxInput.sendKeys("150000"); // Max = 1.5 Lac

                Reporter.generateReport(driver, extTest, Status.INFO, "Tried selecting budget using sendKeys");

            } catch (Exception sendKeysFailed) {
                // --- Fallback to scroll + click ---
                WebElement minPrice = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.minPrice1));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", minPrice);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", minPrice);

                WebElement maxPrice = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.maxPrice1));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", maxPrice);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", maxPrice);

                Reporter.generateReport(driver, extTest, Status.INFO, "Fallback: Selected budget using scroll + click");
            }

            // Close dropdown (click outside)
            WebElement close = wait.until(ExpectedConditions.elementToBeClickable(Locators.closeBudget1));
            close.click();

            Reporter.generateReport(driver, extTest, Status.PASS, "Budget range selected successfully (Min ₹1 Lac, Max ₹1.5 Lac)");
            return true;

        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to select budget: " + e.getMessage());
            return false;
        }
    }

    public boolean clickSearch1() {
        try {
            WebElement searchBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(Locators.searchButton1)
            );

            // scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
            Thread.sleep(500);

            // click using JS (works even if hidden/overlapped)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);

            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on Search button");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "Failed to click Search button: " + e.getMessage());
            return false;
        }
    }
    public boolean clickSearch2() {
        try {
            WebElement searchBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(Locators.searchButton)
            );

            // scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
            Thread.sleep(500);

            // click using JS (works even if hidden/overlapped)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);

            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on Search button");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "Failed to click Search button: " + e.getMessage());
            return false;
        }
    }
    
    public boolean validateStayOnHome() {
        try {
            WebElement buyHeading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='buyheading']"))
            );
            if (buyHeading.isDisplayed()) {
                Reporter.generateReport(driver, extTest, Status.PASS, "User remained on home page.");
                return true;
            }
            return false;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "User did not remain on home page: " + e.getMessage());
            return false;
        }
    }

}