package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage = new LoginPage();
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginPagetitleTest() {
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCMRImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
}
