package com.ecomm.qa.driversFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	//public WebDriver driver;
	
	public static ThreadLocal <WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public WebDriver launchBrowser(String browserName)
	{
		System.out.println("Browser is : " + browserName);
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver()); 
		}
		else if(browserName.equals("firefox"))
		{	
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		return getDriver();			
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
	}
	
	
	

}
