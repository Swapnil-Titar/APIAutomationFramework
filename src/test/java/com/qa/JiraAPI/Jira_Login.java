package com.qa.JiraAPI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;

public class Jira_Login 

{
	
	public static Logger logger;
	public static Properties pro;
	
	@BeforeSuite
	public void TestDataSetup() throws IOException 
	{
		File Src = new File(".\\src\\main\\java\\com\\qa\\Config\\Config.Properties");
		FileInputStream fis = new FileInputStream(Src);
		pro = new Properties();
		pro.load(fis);
		logger = Logger.getLogger("Logger_File");
		PropertyConfigurator.configure(".\\src\\main\\java\\com\\qa\\Config\\log4j.properties");
	}
	}
	

