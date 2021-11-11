package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*
 * @author
 * 
 * this is a class to invoke the tests and pass all necessary path of the feature files and step definition
 * so than cucumber can invoke and run the tests and more 
 * the plug-in is added to produce a HTML report for the client 
 * 
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		features="./src/test/resources/features",
		glue="step_definitions",
		dryRun=false
		
		
		)
public class TestRunner {
	
	
	//dryRun = we are telling to cucumber to run only the scenario steps, not the implementation

}
	
	
	
	
	


