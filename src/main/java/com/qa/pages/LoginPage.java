package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page factory - Object repository
	@FindBy(name = "username")
	WebElement usename;
	// WebElement ele = driver.findElement(By.name("username"));
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	//Initializing page objects 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatePageTitle() {
		return driver.getTitle();
	}
	public boolean validateCMRImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pass) {
		usename.sendKeys(un);
		password.sendKeys(pass);
		loginbtn.click();
		return new HomePage();
	}
}
