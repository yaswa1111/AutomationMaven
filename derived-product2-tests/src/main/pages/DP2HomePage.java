package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DP2HomePage extends BasePage<DP2HomePage>{

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement COOKIE_ACCEPT;

    @FindBy(xpath = "//footer")
    WebElement FOOTER;

    @FindBy(xpath = "//*/footer//nav/ul/li/a")
    List<WebElement> FOOTER_LINKS;

    public void acceptCookie(){
        try {
            click(COOKIE_ACCEPT);
        } catch (Exception e) {
            //continue
        }
    }

    public boolean checkForInvisibilityOfCookie(){
        try{
            waitForInvisibility(COOKIE_ACCEPT);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void scrollToFooter(){
        scrollTo(FOOTER);
    }

    public void printLinks(){
        for(WebElement i:FOOTER_LINKS){
            System.out.println(i.getAttribute("href"));
        }
    }

}
