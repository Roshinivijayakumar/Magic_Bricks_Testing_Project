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
import com.setup.Reporter;

public class InvalidlocationPage {
    public static By searchButton1 = By.xpath("//*[@id=\"commercialIndex\"]/section[1]/div/div[1]/div[3]/div[5]");
	public static By enterlocation = By.id("keyword");
	public static By crossloc =By.xpath("//*[@id=\"keyword_autoSuggestSelectedDiv\"]/div/div[2]");
    public static By searchButton = By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[4]");
	  private WebDriver driver;
	  private WebDriverWait wait;
	  private ExtentTest extTest;
	  
	  public InvalidlocationPage(WebDriver driver, ExtentTest extTest) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        this.extTest = extTest;
	    }
	  
	public boolean enterLocation1(String location) {
        try {
    		  
    		  WebElement locationBox = wait.until(ExpectedConditions.elementToBeClickable(enterlocation));
    		  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", locationBox); 
    		  WebElement locationBox1 =wait.until(ExpectedConditions.elementToBeClickable(crossloc));
    		  ((JavascriptExecutor) driver).executeScript("arguments[0].click();",locationBox1); 
    		  locationBox.clear(); 
    		  locationBox.sendKeys(location);
    		  Reporter.generateReport(driver, extTest, Status.PASS, "Entered location: " +
    	    		  location); return true; } catch (Exception e) {
    	    		  Reporter.generateReport(driver, extTest, Status.FAIL,
    	    		  "Failed to enter location: " + e.getMessage()); return false;
    	    }
        }
    	    		  
	 public boolean clickSearch2() {
	        try {
	            WebElement searchBtn = wait.until(
	                ExpectedConditions.presenceOfElementLocated(searchButton)
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
