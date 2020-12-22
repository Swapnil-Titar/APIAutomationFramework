package com.test.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testclass {
	
	public WebDriver driver;
	
//start brower - 
	@BeforeMethod
	public void start_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GS-2163\\eclipse-workspace\\Sampleproject\\Driver\\chromedriver.exe");	
	//driver.chrome.driver = "/Sampleproject/Driver/chromedriver.exe"// hromeDriver("webdriver.chrome.driver" "/Sampleproject/Driver/chromedriver.exe");; 	
	driver = new ChromeDriver();


	
	}

//Login - website 
	@Test()
	public void login() throws InterruptedException {
		driver.get("https://petstore.octoperf.com/");
		
		Thread.sleep(5000);
		
	}	
	
	

//close 
	@AfterMethod
	public void close_browser()
	{
		driver.close();
	}
	

}
