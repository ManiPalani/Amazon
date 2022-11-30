package com.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Base.Base_Class;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;//jUnit
@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\feature\\Amazon.feature",
glue = "com.stepdefinition",
monochrome = true,
dryRun = false,
plugin = {
		"html:Report/cucumber.html",
		//"com.cucumber.listener.ExtentCucumberFormatter:Report/Cucumber.html",
		"pretty"
})

public class Runner_Class {
	
	
	
	public static WebDriver driver=null;
	@BeforeClass
	public static void setUp()
	{
		driver= Base_Class.launch("chrome");
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}

}
