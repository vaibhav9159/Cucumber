package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"/Users/vsrivastava/eclipse-workspace/CucumberTestAutomation/src/test/resources/AppFeatures/AccountsPage.feature"},
			glue = {"stepDefinitions","AppHooks"},
			plugin ={"pretty"}
		)


public class Tests {
 
}
