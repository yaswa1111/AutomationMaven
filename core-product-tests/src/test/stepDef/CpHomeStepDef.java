package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CPHomePage;

public class CpHomeStepDef {

    @Given("We are logged into CP home page")
    public void weAreLoggedIntoCPHomePage() {
        CPHomePage cpHomePage = new CPHomePage();
        Assert.assertEquals(cpHomePage.getCurrentUrl() ,"https://www.nba.com/warriors");
    }

    @Given("We go to CP home page")
    public void goToHomePage() {
        CPHomePage cpHomePage = new CPHomePage();
        cpHomePage.getUrl("https://www.nba.com/warriors");
    }

    @When("I try to close modal")
    public void iTryToCloseModal() {
        CPHomePage cpHomePage = new CPHomePage();
        cpHomePage.closeModal();
    }

    @When("I try to accept cookies")
    public void iTryToAcceptCookies() {
        CPHomePage cpHomePage = new CPHomePage();
        cpHomePage.acceptCookie();
    }

    @Then("Popup should be closed")
    public void popupShouldBeClosed() {
        CPHomePage cpHomePage = new CPHomePage();
        cpHomePage.checkModal();
    }

    @When("I hover on Shop")
    public void i_hover_on_shop() {
        CPHomePage cpHomePage = new CPHomePage();
        cpHomePage.hoverOnShop();
    }

    @When("I hover on Menu")
    public void i_hover_on_menu() {
        CPHomePage cpHomePage = new CPHomePage();
        cpHomePage.hoverOnMenu();
    }

    @When("I click on Men's")
    public void i_click_on_men_s() {
        CPHomePage cpHomePage = new CPHomePage();
        Assert.assertEquals(cpHomePage.noOfTabs() ,1);
        cpHomePage.clickOnMens();
    }

    @When("I click on News")
    public void i_click_on_news() {
        CPHomePage cpHomePage = new CPHomePage();
        Assert.assertEquals(cpHomePage.noOfTabs() ,1);
        cpHomePage.clickOnNews();
    }

    @Then("details should be opened in new tab")
    public void details_should_be_opened_in_new_tab() {
        CPHomePage cpHomePage = new CPHomePage();
        Assert.assertEquals(cpHomePage.noOfTabs() ,2);
        cpHomePage.switchToNewTab();
    }

}
