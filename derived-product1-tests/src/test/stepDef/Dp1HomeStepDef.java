package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DP1HomePage;

import java.util.ArrayList;
import java.util.List;

public class Dp1HomeStepDef {
//button[contains(@class,'TileHeroStories_tileHeroStoriesButton')]
    //TileHeroStories_tileHeroStoriesNextStory
    //aria-hidden
    @Given("We are logged into DP1 home page")
    public void weAreLoggedIntoCPHomePage() {
        DP1HomePage dp1HomePage = new DP1HomePage();
        Assert.assertTrue(dp1HomePage.getCurrentUrl().contains("https://www.nba.com/sixers"));
    }

    @Given("We go to DP1 home page")
    public void goToHomePage() {
        DP1HomePage dp1HomePage = new DP1HomePage();
        dp1HomePage.getUrl("https://www.nba.com/sixers");
    }

    @When("I try to accept cookies")
    public void iTryToAcceptCookies() {
        DP1HomePage dp1HomePage = new DP1HomePage();
        dp1HomePage.acceptCookie();
    }

    @Then("Cookie popup should not be visible")
    public void cookiePopupShouldNotBeVisible() {
        DP1HomePage dp1HomePage = new DP1HomePage();
        Assert.assertTrue(dp1HomePage.checkForInvisibilityOfCookie()) ;
    }


    @Then("We should be able to get count of slides")
    public void weShouldBeAbleToGetCountOfSlides() {
        DP1HomePage dp1HomePage = new DP1HomePage();
        System.out.println(dp1HomePage.countSlides());
    }


    @And("We should be able to verify time taken by each slide")
    public void weShouldBeAbleToVerifyTimeTakenByEachSlide() {
        DP1HomePage dp1HomePage = new DP1HomePage();
        Assert.assertEquals(dp1HomePage.countDuration(),10L);
    }

    @And("We should be able to get titles of each slide")
    public void weShouldBeAbleToGetTitlesOfEachSlide() {
        DP1HomePage dp1HomePage = new DP1HomePage();
        List<String> expected = new ArrayList<>();
        expected.add("76ers Defeated by Knicks");
        expected.add("Inside Tyrese Maxey's All-Star Weekend");
        expected.add("Lowry Signs with Sixers");
        expected.add("Sixers Acquire Buddy Hield");
        List<String> titles= dp1HomePage.getTitleofAllSlides();
        for(String i:titles){
            Assert.assertTrue(expected.contains(i));
        }
    }
}
