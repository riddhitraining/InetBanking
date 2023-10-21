package com.inetBanking.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	By logoutLinkLocator = By.xpath("//a[contains(text(),'Log out')]");
	
	WebDriver driver;
	WebElement logoutLink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.logoutLink= driver.findElement(logoutLinkLocator);
	}
	
	public void clicklogoutLink() {
		logoutLink.click();
	}


}
