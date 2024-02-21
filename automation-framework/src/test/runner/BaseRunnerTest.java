package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"features"},
        glue ={"stepDef","utilities"},
        tags = "@News or @Shop",
        plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"}
)
public class BaseRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
