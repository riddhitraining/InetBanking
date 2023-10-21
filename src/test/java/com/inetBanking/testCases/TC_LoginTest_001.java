package com.inetBanking.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.inetBanking.pageobject.LoginPage;
import com.inetBanking.utilities.CustomListener;


@Listeners(CustomListener.class)
public class TC_LoginTest_001 extends BaseClass {
	
	private static final Logger logger = LogManager.getLogger(TC_LoginTest_001.class);
	
	@Test
	public void logintest() {
		
		driver.get(baseURL);
		
		logger.info("URL is opened");
		
		LoginPage lp= new LoginPage(driver);
		lp.enteruserid(username);
		logger.info("Entered username");
		
		lp.enterpassword(password);
		logger.info("Entered password");
		
		lp.clickloginButton();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}else
		{
			Assert.assertTrue(false);
			logger.info("Login test falied");
		}
	}

}
