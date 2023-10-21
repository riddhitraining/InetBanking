package com.inetBanking.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	By useridLocator = By.name("uid");
	By passwordLocator = By.name("password");
	By loginButtonLocator = By.name("btnLogin");
	

	WebDriver driver;
	WebElement userid;
	WebElement password;
	WebElement loginButton;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.userid = driver.findElement(useridLocator);
		this.password = driver.findElement(passwordLocator);
		this.loginButton = driver.findElement(loginButtonLocator);
	}

	public void enteruserid(String user) {
		userid.sendKeys(user);
	}

	public void enterpassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickloginButton() {
		loginButton.click();
	}
	

}
