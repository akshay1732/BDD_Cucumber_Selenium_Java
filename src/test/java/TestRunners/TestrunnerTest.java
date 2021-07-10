package TestRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(

        features="src/test/resources/Features",
        glue={"classpath:StepDefinition"},
        dryRun=false,
        plugin = {"pretty","html:test-output/HTML-Report/report.html"}
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
@RunWith(Cucumber.class)
public class TestrunnerTest {

    /* @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() { return super.scenarios(); }*/

}