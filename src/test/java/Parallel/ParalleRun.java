package Parallel;


import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
			features = {"/Users/vsrivastava/eclipse-workspace/CucumberTestAutomation/src/test/resources/Parallel"},
			glue = {"Parallel"},
			plugin ={"pretty", "timeline:test-output-thread/"}
		)
public class ParalleRun extends AbstractTestNGCucumberTests{
	
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
