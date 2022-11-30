package com.Maven_Amazon;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	public static WebDriver driver;
	public static int indexOfPopulation;
	public static int indexOfCountry;
	
	public static void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public static void allHeader() {
		//All Header
		Map<Integer,String> headerMap=new LinkedHashMap<Integer,String>();
		List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/thead/tr/th"));
		System.out.println("Header Datas:" );
		for (int i=0;i<allHeaders.size();i++) {
			String header= allHeaders.get(i).getText().replace("\n", "");
			headerMap.put(i, header);
			if(header.equals("Population")) {
				indexOfPopulation=i;
			}
			else if(header.contains("Country")) {
				indexOfCountry=i;
			}
			
		}
		System.out.println(headerMap);
	}
	
	public static void allData() {
		//All Datas
		List<WebElement> allDatas = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr/td"));
		System.out.println("All datas for table:" );
		for (WebElement data : allDatas) {
			System.out.println(data.getText());
		}
	}
	public static void particularData() {
		//Particluar Data
		WebElement totalCase = driver.findElement(By.xpath("//table[@id='main_table_countries_today']/tbody/tr[7]/td[3]"));
		System.out.println("Total Cases for India" + totalCase.getText());
	}
	public static void rowWise_Data() {
		
		//Rowwise Data  
		
		List<WebElement> rowDatas = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr[7]/td"));
		System.out.println("Particluar value on  India is :");
		for (WebElement particularData : rowDatas) {
			System.out.println(particularData.getText());
		}
	}
public static void columnWise_Data() {
	//Columnwise Data  
	
		List<WebElement> columnDatas = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr/td[2]"));
		System.out.println("Particluar value on  India is :" );
		for (WebElement particularColumnData : columnDatas) {
			System.out.println(particularColumnData.getText());
		}
	}
	
public static void main(String[] args) throws InterruptedException {
	launch();
	allHeader();
//	allData();
//	particularData();
//	rowWise_Data();
//	columnWise_Data();
	

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	System.err.println("Done");
//	Thread.sleep(1000);
//	System.err.println("Done");
//	WebElement f= driver.findElement(By.xpath("(//a[text()='Services'])[1]"));
//	Actions a = new Actions(driver);
//	a.clickAndHold(f);
//	System.err.println("Done");
//	List<WebElement> fe = driver.findElements(By.xpath("//ul[@class='menu-child']/child::li"));
//	for (WebElement web : fe) {
//		System.out.println(web.getText());
//		if(web.getText().contains("BPO"))
//		{
//			break;
//		}
//	}
}
}
