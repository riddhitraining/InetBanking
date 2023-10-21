package com.inetBanking.testCases;

import java.io.FileReader;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageobject.HomePage;
import com.inetBanking.pageobject.LoginPage;
import com.inetBanking.utilities.ExcelUtils;

public class TC_Login_DataDrivenTesting_002 extends BaseClass {

	private static final Logger logger = LogManager.getLogger(TC_Login_DataDrivenTesting_002.class);

	Properties p;

	public void loadproperties() throws Exception {

		FileReader reader = new FileReader("./configuration/config.properties");
		p = new Properties();
		p.load(reader);

	}

	@BeforeClass
	public void testloading() {
		try {
			loadproperties();
		} catch (Exception e) {
			logger.error("Error has been generated while loading config properties", e);
		}
	}

	@DataProvider(name = "dataProvider")
	public Object[][] dataProviderMethod() {
		Object[][] testObjArray = null;
		try {
			String file = p.getProperty("excelPath");
			String sheetname = p.getProperty("sheetname");

			testObjArray = ExcelUtils.getTableArray(file, sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return testObjArray;
	}

	@Test(dataProvider = "dataProvider")
	public void logintest(String username, String password) throws InterruptedException {

		String baseUrl = p.getProperty("baseURL");
		driver.get(baseUrl);

		LoginPage lp = new LoginPage(driver);
		lp.enteruserid(username);
		logger.info("username provided");
		lp.enterpassword(password);
		logger.info("password provided");
		lp.clickloginButton();

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Login passed");

			HomePage homePage = new HomePage(driver);

			homePage.clicklogoutLink();
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() // user define method to check alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}
