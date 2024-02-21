package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CPNewsPage;
import utilities.FileUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CpNewsStepDef {

    @Given("We are navigated to CP News page")
    public void weAreLoggedIntoCPNewsPage() {
        CPNewsPage cpNewsPage = new CPNewsPage();
        Assert.assertTrue(cpNewsPage.getCurrentUrl().contains("warriors/news"));
    }

    @Then("We should be able to see all Videos")
    public void WeshouldbeabletoseeallVideos() throws IOException {
        CPNewsPage cpNewsPage = new CPNewsPage();
        FileUtils fileUtils = new FileUtils();
        cpNewsPage.waitForPageLoadToComplete();
//        FileWriter fileWriter = fileUtils.writeToFile("CoreProduct_Videos.txt");
        cpNewsPage.printtofile();
    }

}
