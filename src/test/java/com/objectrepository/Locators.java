package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	 public static By homeLoginBtn = By.xpath("//*[@id=\"commercialIndex\"]/header/section[1]/div/div[2]/div[2]/a");
	 public static By innerLoginBtn = By.xpath("//*[@id=\"commercialIndex\"]/header/section[1]/div/div[2]/div[2]/div/div[2]/a");
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
     public static By clearPropertyType = By.xpath("//*[@id=\"propType_buy\"]/div[2]/div/div/div[1]/div[2]/div[4]");
     public static By dropdownProperType = By.xpath("//*[@id=\"propType_buy\"]/div[1]");
     public static By selectPropertyType = By.id("10002_10003_10021_10022");
     public static By closePropertyType = By.xpath("//*[@id=\"buy_proertyTypeDefault\"]");
     
     public static By clickBudget = By.id("rent_budget_lbl");
     //public static By dropdownBudget = By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[3]/div[1]");
     public static By minPrice = By.xpath("//*[@id=\"budgetMin\"]");
     public static By maxPrice = By.xpath("//*[@id=\"budgetMax\"]");
     public static By closeBudget = By.xpath("//*[@id=\"rent_budget_lbl\"]");
     public static By searchButton = By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[4]");
     public static By sortBy = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div[1]");
//     public static By mostrecent = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div/div[2]/ul/li[4]");
     
//     public static By shortlistButton = By.xpath("//*[@id=\"cardid80084779\"]/div/div[1]/div[2]/span[2]");
//     
//     public static By mainshortlistbtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/span");
//     public static By viewShortlistBtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/div/div/a");
//     public static By shortlistedPropertyTitle = By.xpath("//*[@id=\"cardid81061849\"]/div/div[1]/div[2]/h2");
//     public static By shortlistedPropertyCard = By.xpath("//*[@id=\"cardid80084779\"]/div/div[1]");
//     public static By shortlistTabHeader = By.xpath("//*[@id=\"m-tab-Shortlisted\"]");
//     public static By contactagent = By.xpath("//*[@id=\"contactRightInfo\"]/div[1]/div");
     
     // Locators for commercial
     public static By commercialTab = By.xpath("//*[@id=\"tabCOMM\"]");
     public static By leaseOption = By.xpath("//*[@id=\"commercialTypeDropdown\"]/div[2]");
     public static By leaseDropdown = By.xpath("//*[@id=\"commercialType\"]");
     public static By propertyDropdown = By.xpath("//span[contains(text(),'Office Space')]");
     public static By searchBtn = By.xpath("//button[contains(text(),'Search')]");
     
     public static By clickPropertType1 = By.xpath("//*[@id=\"propType_rent\"]/div[1]");
//     public static By clearPropertyType1 = By.xpath("//*[@id=\"propType_buy\"]/div[2]/div/div/div[1]/div[2]/div[4]");
//     public static By dropdownPropertyType1 = By.xpath("//*[@id=\"propType_buy\"]/div[1]");
     public static By selectPropertyType1 =By.xpath("//label[text()='Office Space']");
     public static By closePropertyType1= By.xpath("//body");
     
//     public static By clickBudget1 = By.xpath("//*[@id=\"commercialIndex\"]/section[1]/div/div[1]/div[3]/div[4]/div[1]");
//     public static By minPrice1 = By.xpath("//*[@id=\"minBudjet\"]/div[13]");
//   public static By maxPrice1 = By.xpath("//*[@id=\"maxBhkIndex_12\"]");
     public static By clickBudget1 = By.id("rent_budget_lbl");  
     public static By minPrice1 = By.xpath("//*[@id='minBudjet']/div[12]");
     public static By maxPrice1 = By.id("maxBhkIndex_12");
     public static By closeBudget1 = By.xpath("//body");
     public static By searchButton1 = By.xpath("//*[@id=\"commercialIndex\"]/section[1]/div/div[1]/div[3]/div[5]");

     public static By mostrecent = By.xpath("//div[@class='mb-srp__tabs__sortby']//ul[@class='mb-srp__tabs__sortby__dd__list']/li[text()='Most Recent']");
     
//     public static By shortlistButton = By.xpath("//*[@id=\"cardid81319227\"]/div/div[1]/div[2]/span[2]");
//     public static By mainshortlistbtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/span");
//     public static By viewShortlistBtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/div/div/a");
     //public static By shortlistedPropertyTitle = By.xpath("//*[@id=\"m-tab-Shortlisted\"]");
//     public static By shortlistedPropertyCard = By.xpath("//*[@id=\"cardid81319227\"]/div[2]/div[1]");
   
//     public static By contactagent = By.xpath("//*[@id=\"contactRightInfo\"]/div[1]/div");
  // First property card container
     
     //the below button is when the sort is given as relevance
     public static By shortlistButton = By.xpath("//span[@class='mb-srp__card__share--icon']/following-sibling::span[1]");
     public static By mainshortlistbtn = By.xpath("//div[@class='mb-header__main__shortlist']//span[@class='mb-header__main__shortlist__cta']");
     public static By viewShortlistBtn = By.xpath("//a[normalize-space(text())='View Your Shortlisted Properties']");
     public static By shortlistedPropertyCard = By.xpath("(//div[@class='mb-srp__card__container'])[1]");

     // Property title inside the first card
     public static By propertyTitle = By.xpath("(//h2[@class='mb-srp__card--title'])[1]");
     public static By shortlistTabHeader = By.xpath("//li[@id='m-tab-Shortlisted' and normalize-space(text())='Shortlisted']");
     // Agent name inside the first card
     public static By contactAgent = By.xpath("//div[@class='mb-ldp__contact-info__title--text1' and normalize-space(text())='Contact Agent']");

     
     public static By crossloc =By.xpath("//*[@id=\"keyword_autoSuggestSelectedDiv\"]/div/div[2]");
}