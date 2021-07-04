package TestRunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features="classpath:Features",
        glue={"classpath:StepDefinition"},
        dryRun=false,
        plugin = {"pretty","html:test-output/HTML-Report/report.html"}
        //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        )

public class TestrunnerTest extends AbstractTestNGCucumberTests {

    /* @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() { return super.scenarios(); }*/

}