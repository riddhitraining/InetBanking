package com.inetBanking.utilities;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadConfig {

	Properties p;

	public ReadConfig() {
		File src = new File("./configuration/config.properties");

		try {
			FileReader reader = new FileReader(src);
			p = new Properties();
			p.load(reader);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url= p.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username= p.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password= p.getProperty("password");
		return password;
	}
	
	public void test1() {
		WebDriver driver = null;
		
		String drivername= p.getProperty("drivername");
		
		if(drivername .equals("Chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		}
		else if(drivername .equals("FF"))
		{
			driver= new FirefoxDriver();
		}
		else if(drivername .equals("Safari"))
		{
			driver= new SafariDriver();
		}else
		{
			System.out.println("no browser value is given");
		}
		String baseURL= p.getProperty("baseURL");
		driver.get(baseURL);

}}
