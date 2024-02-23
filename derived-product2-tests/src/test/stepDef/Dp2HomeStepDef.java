package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DP2HomePage;

import java.util.ArrayList;
import java.util.List;

public class Dp2HomeStepDef {
    @Given("We are logged into DP2 home page")
    public void weAreLoggedIntoCPHomePage() {
        DP2HomePage dp2HomePage = new DP2HomePage();
        Assert.assertTrue(dp2HomePage.getCurrentUrl().contains("https://www.nba.com/bulls/"));
    }

    @Given("We go to DP2 home page")
    public void goToHomePage() {
        DP2HomePage dp2HomePage = new DP2HomePage();
        dp2HomePage.getUrl("https://www.nba.com/bulls/");
    }

    @When("I try to accept cookies")
    public void iTryToAcceptCookies() {
        DP2HomePage dp2HomePage = new DP2HomePage();
        dp2HomePage.acceptCookie();
    }

    @Then("Cookie popup should not be visible")
    public void cookiePopupShouldNotBeVisible() {
        DP2HomePage dp2HomePage = new DP2HomePage();
        Assert.assertTrue(dp2HomePage.checkForInvisibilityOfCookie()) ;
    }

    @When("We scroll down to bottom of page")
    public void weScrollDownToBottomOfPage() {
        DP2HomePage dp2HomePage = new DP2HomePage();
        dp2HomePage.scrollToFooter();
    }

    @Then("We should be able to see multiple links")
    public void weShouldBeAbleToSeeMultipleLinks() {
        DP2HomePage dp2HomePage = new DP2HomePage();
        dp2HomePage.printLinks();
    }

    @Then("We should be able to write hyperlinks to CSV")
    public void weShouldBeAbleToWriteHyperlinksToCSV() {
        DP2HomePage dp2HomePage = new DP2HomePage();
    }

    @Then("We can print duplicate hyperlinks")
    public void weCanPrintDuplicateHyperlinks() {
        DP2HomePage dp2HomePage = new DP2HomePage();
    }
}
