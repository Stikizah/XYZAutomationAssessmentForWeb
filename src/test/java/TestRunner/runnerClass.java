package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
        glue={"StepDefinition"},monochrome = true,
		plugin = {"json:target/cucumber.json"}
//        plugin = { "pretty", "html:target/reports.html"}
		//,tags = "@TestThree"
)
public class runnerClass {

}
