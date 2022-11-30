package com.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	public static WebDriver driver;

	public static WebDriver launch(String value) {
		if (value.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		return driver;

	}

	public static void url(String getUrl) {
		driver.get(getUrl);
	}

	public static void close_Window() {
		driver.close();
	}

	public static void quite_Window() {
		driver.quit();
	}

	public static void getTitle() {
		System.out.println(driver.getTitle());
	}

	public static void getCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	public static void navigate_TO(String getURL) {
		driver.navigate().to(getURL);
	}

	public static void navigate_Back() {
		driver.navigate().back();
	}

	public static void navigate_Forward() {
		driver.navigate().forward();
	}

	public static void Refresh() {
		driver.navigate().refresh();
	}

	public static void inputElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void elementClick(WebElement element) {
		element.click();
	}

	public static void elementClear(WebElement element) {
		element.clear();
	}

	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static void isEnabled(WebElement element) {
		boolean b = element.isEnabled();
		System.out.println("The check whether element is enabled or not" + b);
	}

	public static void isDisplayed(WebElement element) {
		boolean b = element.isDisplayed();
		System.out.println("The check whether element is displayed or not" + b);
	}

	public static void isSelected(WebElement element) {
		boolean b = element.isEnabled();
		System.out.println("The check whether element is selected or not" + b);
	}

	static JavascriptExecutor js = (JavascriptExecutor) driver;

	public static void js_Click(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public static void js_InputElement(WebElement element, String value) {
		js.executeScript("arguments[0].value = " + value, element);
	}

	public static void scroll_View(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void implicit_Wait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void explicit_Wait(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(element));
	}

	public static void selectDropDownOption(WebElement element, String option, String value) {

		Select s = new Select(element);
		if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("visibletext")) {
			s.selectByVisibleText(value);
		} else if (option.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(value));
		}

	}
	
	public static void deSelectDropDownOption(WebElement element, String option, String value) {

		Select s = new Select(element);
		if (option.equalsIgnoreCase("value")) {
			s.deselectByValue(value);
		} else if (option.equalsIgnoreCase("visibletext")) {
			s.deselectByVisibleText(value);
		} else if (option.equalsIgnoreCase("index")) {
			s.deselectByIndex(Integer.parseInt(value));
		}

	}
	
	public static List<WebElement> dropDownOptions(WebElement element) {
		Select s= new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}
	
	public static WebElement firstSelectedOptions(WebElement element) {
		Select s= new Select(element);
		WebElement firstOption = s.getFirstSelectedOption();
		return firstOption;
	}
	
	public static List<WebElement> allSelectedOptions(WebElement element) {
		
		Select s= new Select(element);
		List<WebElement> allOptions = s.getAllSelectedOptions();
		return allOptions;
		
	}
	public static void isMultiple(WebElement element) {
		Select s= new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println("The check whether element is multiple or not" + multiple);
	}


	public void takeScreenShot(String fileName) throws IOException {

		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Manikandaprabu\\eclipse-workspace\\Maven_Amazon\\Report" + fileName + ".png");
		FileUtils.copyFile(src, des);
	}

	public static void mouseHoverToElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();

	}

	public static void double_Click(WebElement element) {
		Actions ac = new Actions(driver);
		ac.doubleClick(element).build().perform();
	}

	public static void right_Click(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();
	}

	public static void drag_Drop(WebElement element, WebElement drop_Element) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(element, drop_Element).build().perform();
	}

	public static void clickAndHold(WebElement element) {
		Actions ac = new Actions(driver);

		ac.clickAndHold(element).build().perform();
	}

	// Alert
	public static void accept_Alert() {
		driver.switchTo().alert().accept();
	}

	public static void dismiss_Alert() {
		driver.switchTo().alert().dismiss();
	}

	public static void key_Alert(String value) {
		driver.switchTo().alert().sendKeys(value);
		String text = driver.switchTo().alert().getText();
		System.out.println(text);

	}

	// Frame
	public static void frame_Index(int value) {
		driver.switchTo().frame(value);
	}

	public static void frame_Name(String value) {
		driver.switchTo().frame(value);
	}

	public static void frame_WebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void switchToDefault() {

		driver.switchTo().defaultContent();

	}
}
