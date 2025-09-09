//     public static By commercialOption = By.id("tabCOMM");  
//     public static By propertyTypeDropdown = By.id("buy_proertyTypeDefault");  
//     public static By officeSpaceOption = By.xpath("//*[@id=\"10007_10018\"]");
//     public static By minBudget = By.xpath("//*[@id=\"minBudjet\"]/div[13]");
//     public static By maxBudget = By.xpath("//*[@id=\"maxBhkIndex_13\"]");
//     public static By searchButton = By.xpath("//*[@id=\"commercialIndex\"]/section[1]/div/div[1]/div[3]/div[5]/span");

package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
//	 public static By homeLoginBtn = By.xpath("//*[@id=\"commercialIndex\"]/header/section[1]/div/div[2]/div[2]/a");
//	 public static By innerLoginBtn = By.xpath("//*[@id=\"commercialIndex\"]/header/section[1]/div/div[2]/div[2]/div/div[2]/a");
	public static By homeLoginBtn = By.xpath("//a[contains(@class, 'mb-header__main__link') and contains(@class, 'js-menu-link') and normalize-space(text())='Login']");
	 public static By innerLoginBtn = By.cssSelector("a.mb-login__drop-cta");
	 public static By googleLoginBtn = By.xpath("//*[@id=\"my-signin2\"]/div/div");
	 public static By phonenumber = By.xpath("//*[@id=\"emailOrMobile\"]");
	 public static By nextbtn = By.id("btnStep1");
	 public static By captacha = By.xpath("//*[@id=\"captchaCodeSignIn\"]");	
	 public static By otp1 = By.id("verify01");
	 public static By otp2 = By.id("verify02");
	 public static By otp3 = By.id("verify03");
	 public static By otp4 = By.id("verify04");
     public static By continuebtn = By.xpath("//*[@id=\"verifyOtpDiv\"]/div[2]/div[3]/button");
     public static By closepopup = By.xpath("//*[@id=\"userOnboardingWidget\"]/div/div[1]");
     public static By enterlocation = By.id("keyword");
     public static By clickPropertType = By.id("propType_buy");
     public static By dropdownProperType = By.xpath("//*[@id=\"propType_buy\"]/div[1]");
     public static By selectPropertyType = By.id("10002_10003_10021_10022");
     //public static By clickBudget = By.id("rent_budget_lbl");
     public static By dropdownBudget = By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[3]/div[1]");
     public static By minPrice = By.xpath("//*[@id=\"minBudjet\"]/div[10]");
     public static By maxPrice = By.xpath("//*[@id=\"maxBhkIndex_11\"]");
     public static By searchButton = By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[4]");
     public static By sortBy = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div[1]");
}
