package com.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Base.Base_Class;
import com.Maven_Amazon.SingleData;
import com.runner.Runner_Class;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Step_Definition extends Base_Class{
	
	public static WebDriver driver =Runner_Class.driver;
	String s ;
	
	@Given("^user Can Able To Launch The Amazon URL$")
	public void user_Can_Able_To_Launch_The_Amazon_URL() throws Throwable {
		
		url("https://www.amazon.in/");
	
		
	}
	@When("user Can Able To {string} The DropDown Option")
	public void user_can_able_to_the_drop_down_option(String expected) {
		WebElement drop_Down = driver.findElement(By.name("url"));
		//String expected="Baby";
		//String expected = SingleData.singledata_Value("Sheet1", 1, 0);
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
	}
	@When("user Can Able To {string} The Product")
	public void user_can_able_to_the_product(String s1) throws InterruptedException {
		WebElement f = driver.findElement(By.id("twotabsearchtextbox"));
		//s = SingleData.singledata_Value("Sheet1", 1, 1);
		s=s1;
		inputElement(f, s);
		Thread.sleep(1000);
	}
	
	@Then("^user Can Purchase the Selected Product$")
	public void user_Can_Purchase_the_Selected_Product() throws Throwable {
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/child::div"));
		Thread.sleep(2000);
		System.out.println(s);
		for (WebElement web : element) {
		if(s.equalsIgnoreCase(web.getText()))
		{
			elementClick(web);
		break;	
		}
	}


}
}