package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	 public static By loginDropdown = By.xpath("//a[text()='Login' and contains(@class,'js-menu-link')]");  
	 public static By loginButton   = By.xpath("//a[contains(@onclick,'userauth/login')]");	 
	 
	 public static By phonenumber = By.xpath("//*[@id=\"emailOrMobile\"]");
	 public static By nextbtn = By.id("btnStep1");
	 public static By captacha = By.xpath("//*[@id=\"captchaCodeSignIn\"]");

	 public static By otp1 = By.id("verify01");
	 public static By otp2 = By.id("verify02");
	 public static By otp3 = By.id("verify03");
	 public static By otp4 = By.id("verify04");
     public static By continuebtn = By.xpath("//*[@id=\"verifyOtpDiv\"]/div[2]/div[3]/button");
}
