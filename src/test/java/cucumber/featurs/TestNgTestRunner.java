package cucumber.featurs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\azwaw.AZ\\AutomationCentre-\\src\\test\\java\\cucumber\\featurs\\registerOnEcommerce.feature", glue = "stepDefinitions", plugin = {
		"html:target/cucumber.html" })
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

}
