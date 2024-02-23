package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/features"},
        glue ={"stepDef","testutilities"},
        plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"}
)
public class DerivedProduct2RunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
