package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CPShopPage;

public class CpShopStepDef {

    @Given("We are logged into CP shop page")
    public void weAreLoggedIntoCPShopPage() {
        CPShopPage cpShopPage = new CPShopPage();
        cpShopPage.checkPromotions();
        Assert.assertTrue(cpShopPage.getCurrentUrl().contains("shop.warriors.com"));
    }

    @When("We click on Jackets")
    public void clickOnJackets(){
        CPShopPage cpShopPage = new CPShopPage();
        cpShopPage.clickOnJackets();
    }

    @Then("We should be able to see all Jackets")
    public void WeshouldbeabletoseeallJackets(){
        CPShopPage cpShopPage = new CPShopPage();
        cpShopPage.getJacketDetails();
    }

}
