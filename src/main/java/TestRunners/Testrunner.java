package TestRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/java/Features",
        glue={"classpath:StepDefinition"},
        tags = "@SmokeTest",
        dryRun=false,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

        )

    public class Testrunner {

}