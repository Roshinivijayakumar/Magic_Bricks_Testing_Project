package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reporter;

public class ShortlistPropertyPage {

	public static By viewShortlistBtn = By.xpath(
			"//a[contains(@class,'shortlist-drop__link') and normalize-space(text())='View Your Shortlisted Properties']");
	public static By shortlistButton = By.xpath("//span[@class='mb-srp__card__sort--icon']");
	public static By mainshortlistbtn = By.xpath("//span[@class='mb-header__main__shortlist__cta']");
	public static By shortlistedPropertyCard = By
			.xpath("//div[contains(@class,'mb-srp__card') and .//h2[contains(text(),'Office Space for Rent')]]");
	public static By sortBy = By.xpath("//div[contains(@class,'mb-srp__tabs__sortby--title')]");
	public static By mostrecent = By.xpath("//li[contains(.,'Most Recent')]");

	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest extTest;

	public ShortlistPropertyPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.extTest = extTest;
	}

	public boolean clickFirstShortlistedProperty() {
		try {
			// Use the more specific locator for the first property
			WebElement firstProperty = wait.until(ExpectedConditions.elementToBeClickable(shortlistedPropertyCard));
			firstProperty.click();
			Thread.sleep(4000);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);

			if (tabs.size() > 1) {
				driver.switchTo().window(tabs.get(tabs.size() - 1));
				Reporter.generateReport(driver, extTest, Status.PASS,
						"Switched to the property details tab.Current URL: " + driver.getCurrentUrl());
			} else {
				Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to the property details tab.");
				return false;
			}

			Reporter.generateReport(driver, extTest, Status.PASS, "Selected first shortlisted property.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to click on the first shortlisted property: " + e.getMessage());
			return false;
		}
	}

	public boolean sortByFilter() {
		try {
			// Click Sort By dropdown
			WebElement sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(sortBy));
			sortDropdown.click();

			// Click Most Recent option
			WebElement mostRecentOption = wait.until(ExpectedConditions.elementToBeClickable(mostrecent));
			mostRecentOption.click();

			String oldFirstCard = driver.findElement(By.xpath("(//div[contains(@class,'mb-srp__card')])[1]")).getText();

			wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(
					By.xpath("(//div[contains(@class,'mb-srp__card')])[1]"), oldFirstCard)));

			Reporter.generateReport(driver, extTest, Status.PASS,
					"Sort By 'Most Recent' applied and listing reloaded.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to apply Sort By Most Recent: " + e.getMessage());
			return false;
		}
	}

	public boolean shortlistPropertyFromList() {
		try {
			// Ensure first property card is visible
			WebElement firstProperty = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'mb-srp__card')])[1]")));

			// Now hover + click shortlist
			WebElement shortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(shortlistButton));
			new Actions(driver).moveToElement(firstProperty).perform();
			shortlistBtn.click();
			
			Thread.sleep(4000);

			WebElement mainShortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(mainshortlistbtn));
			mainShortlistBtn.click();

			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully shortlisted the first property.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to shortlist property: " + e.getMessage());
			return false;
		}
	}

}