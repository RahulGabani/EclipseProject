package com.library.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import com.library.qa.base.TestBase;
import com.library.qa.pages.HomePage;
import com.library.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage = new HomePage();

	public LoginPageTest() throws IOException {
		super();
		
	}
	
	
	@BeforeMethod
    public void setUp() throws IOException {
		TestBase.initialization();
		loginPage = new LoginPage();
		
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
	String title=	loginPage.validateLoginPage();
	AssertJUnit.assertEquals(title, "Sign In : Toronto Public Library");
	
	}
	@Test(priority=2)
	public void loginPageLogoTest() {
	boolean logo =	loginPage.validateLibraryLogo();
	AssertJUnit.assertTrue(logo);
		
	}
	@Test(priority=3)
	public void signinTest() {
		
		 homePage = loginPage.login(prop.getProperty("card"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
