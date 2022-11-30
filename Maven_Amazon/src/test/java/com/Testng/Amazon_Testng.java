package com.Testng;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.Base_Class;
import com.Maven_Amazon.SingleData;

public class Amazon_Testng extends Base_Class {
	@BeforeSuite
	public void browserLaunch() {
		launch("chrome");
	}

	@BeforeTest
	public void url() throws InterruptedException {
		url("https://www.amazon.in/");
		implicit_Wait();
		Thread.sleep(1000);
	}

	@Test(priority = 0)
	public void dropDown() throws IOException, InterruptedException {
		Thread.sleep(10000);
		WebElement drop_Down = driver.findElement(By.name("url"));
		// String expected="Baby";
		String expected = SingleData.singledata_Value("Sheet1", 1, 0);
		Select drop = new Select(drop_Down);
		List<WebElement> options = drop.getOptions();// Get the dropdown value
		for (int i = 0; i < options.size(); i++) {
			String actual = options.get(i).getText();
			if (expected.equalsIgnoreCase(actual)) {
				drop.selectByVisibleText(actual);
			} else {
				continue;
			}
		}
	}

	@Test(priority = 1)
	public void valueSelect() throws InterruptedException, IOException {

		Thread.sleep(10000);
		WebElement f = driver.findElement(By.id("twotabsearchtextbox"));
		String s = SingleData.singledata_Value("Sheet1", 1, 1);
		inputElement(f, s);
		Thread.sleep(6000);
		List<WebElement> element = driver
				.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
		Thread.sleep(1000);
		for (WebElement web : element) {

			System.out.println(getText(web));
		}
		Thread.sleep(2000);
		for (WebElement web : element) {
			if (s.equalsIgnoreCase(web.getText())) {
				elementClick(web);
				break;
			}

		}
	}
}
