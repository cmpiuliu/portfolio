package Runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
        glue = {"steps_definition"},
        plugin = {"pretty", "html:target/cucumber=reports"},
        monochrome = true,
        publish = true)
public class TestRunner {

}
