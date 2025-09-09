//package com.pages;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.objectrepository.Locators;
//
//
//public class HomePage {
//    WebDriver driver;
//    WebDriverWait wait;
//    Actions actions;
//
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        this.actions = new Actions(driver);
//
//    }
//
//    public boolean hoverLoginDropdown() {
//        try {
//            WebElement dropdown = wait.until(
//                ExpectedConditions.presenceOfElementLocated(Locators.loginDropdown)
//            );
//            actions.moveToElement(dropdown).perform();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean clickLoginButton() {
//        try {
//            WebElement button = wait.until(
//                ExpectedConditions.elementToBeClickable(Locators.loginButton)
//            );
//            button.click();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;  
//        }
//    }
//}
