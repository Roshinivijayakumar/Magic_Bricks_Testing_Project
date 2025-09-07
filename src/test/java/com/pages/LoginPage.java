package com.pages;

import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.objectrepository.Locators;
import com.setup.BaseSteps;

public class LoginPage extends BaseSteps {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void switchToLoginTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // second tab
    }
    public void clickphonenumber() {
        driver.findElement(Locators.phonenumber).click();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter mobile");
        String mobile = sc.nextLine();
        System.out.println("Enter captcha");
        String captcha = sc.nextLine();

        driver.findElement(By.id("emailOrMobile")).sendKeys(mobile); 
        driver.findElement(Locators.captacha).sendKeys(captcha); 
        BaseSteps.sleep();
        driver.findElement(Locators.nextbtn).click();

    }
    public void enterotp() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter Otp");
        String otp = scanner.nextLine();
        try {
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otp1)).sendKeys(otp.substring(0, 1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otp2)).sendKeys(otp.substring(1, 2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otp3)).sendKeys(otp.substring(2, 3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otp4)).sendKeys(otp.substring(3, 4));

            wait.until(ExpectedConditions.elementToBeClickable(Locators.continuebtn)).click();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } 
    }     

    public boolean validateLogin() {
        try {
            return driver.findElement(By.xpath("//span[contains(text(),'Rosh')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}