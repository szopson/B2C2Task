package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"utils", "stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:cucumber.json"},
        monochrome = true
)
public class TestRunner {

}