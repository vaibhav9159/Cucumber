package Parallel;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ecomm.qa.driversFactory.DriverFactory;
import com.ecomm.qa.utils.configReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private Properties prop;
	private configReader reader;
	
	@Before(order=0)
	public void getProperty()
	{
		 reader = new configReader();
		 prop=reader.initializePropertiesFile();
	}
	
	@Before(order=1)
	public void launchBrowser()
	{
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver=driverFactory.launchBrowser(browserName);
	}
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void tearDownWithScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{	//take screenshot
			String screenshotName=scenario.getName().replaceAll(" ", "_") + "_"+ System.currentTimeMillis();
			byte[] sourcePath =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	
	
}
