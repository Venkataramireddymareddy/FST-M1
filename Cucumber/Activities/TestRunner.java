package TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/java/Features",
        glue={"StepDefinitions"},
        tags= "@SmokeTest",
        plugin = {"pretty","html: reports/html-reports/report.html"},
        monochrome = true

)

public class TestRunner {

}
