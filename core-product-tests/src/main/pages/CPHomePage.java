package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.driverCreator;


public class CPHomePage extends BasePage<CPHomePage> {

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement COOKIE_ACCEPT;

    @FindBy(xpath = "//*[@role='dialog']//*[contains(text(),'x')]")
    WebElement CLOSE_MODAL;

    @FindBy(xpath = "//*[@class='menu-item'][4]/child::a")
    WebElement SHOP;

    @FindBy(xpath = "//*[@class='menu-item'][4]/nav/ul/li/*[contains(@title,'Men')]")
    WebElement MENS;

    @FindBy(xpath = "//*[@class='menu-item'][6]/following::a[1]")
    WebElement POINT_MENU;

    @FindBy(xpath = "//*[@title='News & Features']")
    WebElement NEWS;

    public CPHomePage() {
        PageFactory.initElements(driverCreator.WebDriverManager.get(), 15);
    }

    public void acceptCookie(){
        try {
            click(COOKIE_ACCEPT);
        } catch (Exception e) {
            //continue
        }
    }

    public void closeModal(){
        try {
            click(CLOSE_MODAL);
        }catch(Exception e){
            //logger
        }

    }

    public void checkModal(){
        driverCreator.webDriverWait.get().until(ExpectedConditions.invisibilityOf(CLOSE_MODAL));
    }

    public void hoverOnShop(){
        hover(SHOP);
    }

    public void clickOnMens(){
        click(MENS);
    }

    public int noOfTabs() {
        return driverCreator.WebDriverManager.get().getWindowHandles().size();
    }

    public void hoverOnMenu(){
        hover(POINT_MENU);
    }

    public void clickOnNews(){
        click(NEWS);
    }

}
