package com.library.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.library.qa.base.TestBase;

public class LoginPage extends TestBase {


//PageFactory- OR:
	@FindBy(id="userId")
WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='button signin']")
	WebElement signIn;
	
	@FindBy(xpath="//button[@id='submit-button']")
	WebElement searchbtn;
	
	@FindBy(xpath="//img[@class='_alwaysShow']")
	WebElement img;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);

	}
//Actions
	public String validateLoginPage(){
		return driver.getTitle();
	}


	
	public boolean validateLibraryLogo() {
		
		return img.isDisplayed();
	}

    public HomePage login(String userid, String pwd) {
    	username.sendKeys(userid);
    	password.sendKeys(pwd);
    	signIn.click();
    	return new HomePage();
    	
    }














}
