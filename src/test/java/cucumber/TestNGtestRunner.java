package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber", glue="stepdefination", monochrome=true,tags= "@Regression", plugin= {"html:targer/cucumber.html"})
public class TestNGtestRunner extends AbstractTestNGCucumberTests
{
	
}
