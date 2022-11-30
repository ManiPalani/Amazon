package com.Maven_Amazon;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.Base.Base_Class;
import com.property.ConfigurationHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon extends Base_Class{
public static void main(String[] args) throws InterruptedException, IOException {
	String browser=ConfigurationHelper.getInstance().getBrowser();
   launch(browser);
   
   String url=ConfigurationHelper.getInstance().getUrlr(); 
	url(url);
	implicit_Wait();
	Thread.sleep(1000);
	WebElement drop_Down = driver.findElement(By.name("url"));
	//String expected="Baby";
	String sheet=ConfigurationHelper.getInstance().getSheet();
	String expected = SingleData.singledata_Value(sheet, 0, 1);
	Select drop = new Select(drop_Down);
	List<WebElement> options = drop.getOptions();//Get the dropdown value
	for (int i = 0; i < options.size(); i++) {
		String actual = options.get(i).getText();
		if(expected.equalsIgnoreCase(actual)) {
			drop.selectByVisibleText(actual);
		}
		else {
			continue;
		}
	}
	WebElement f = driver.findElement(By.id("twotabsearchtextbox"));
	
	String s = SingleData.singledata_Value(sheet, 1, 1);
	inputElement(f, s);
	Thread.sleep(6000);
	List<WebElement> element = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
	Thread.sleep(1000);
	for (WebElement web : element) {
		
	System.out.println(getText(web));
	}
	Thread.sleep(2000);
	for (WebElement web : element) {
	if(s.equalsIgnoreCase(web.getText()))
	{
	elementClick(web);
	break;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*for (WebElement web : element) {
	if(s.equals(web.getText()))
	{
	web.click();	
	break;
		
	}*/
}
}
}
