//
//package com.pages;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.objectrepository.Locators;
//
//
//public class SearchPage {
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public SearchPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    public void enterCity(String city) {
//        driver.findElement(Locators.searchBox).sendKeys(city);
//        wait.until(ExpectedConditions.elementToBeClickable(Locators.chennaiDropdown)).click();
//    }
//
//    public void clickSearch() {
//        driver.findElement(Locators.searchButton).click();
//    }
//
//    public boolean verifyResults() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.propertyResults)).isDisplayed();
//    }
//}