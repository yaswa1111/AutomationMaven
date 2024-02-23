package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utilities.ExtentReport.extentTestManager;
import static utilities.driverCreator.WebDriverManager;
import static utilities.driverCreator.fluentWait;

public class BasePage<T extends BasePage<T>> {



    public BasePage(){
        PageFactory.initElements(WebDriverManager.get(), this);
    }

    public T getUrl(String url){
        try{
            WebDriverManager.get().get(url);
            waitForPageLoadToComplete();
            waitForAjaxCallsToComplete();
            while(!WebDriverManager.get().getCurrentUrl().contains(url)){
                System.out.println(WebDriverManager.get().getCurrentUrl());
                WebDriverManager.get().get(url);
            }
            extentTestManager.get().log(Status.INFO, "Get URL is successful");
        }catch(Exception e){
            extentTestManager.get().log(Status.WARNING, "Failed to get URL with following exception:"+e.getMessage());
        }
        return (T) this;
    }

    public T hover(WebElement element){
        waitForPageLoadToComplete();
        waitForAjaxCallsToComplete();
        fluentWait.get().until(ExpectedConditions.visibilityOf(element));
        try{
            Actions actions = new Actions(WebDriverManager.get());
            actions.moveToElement(element).build().perform();
            extentTestManager.get().log(Status.INFO, "Hovered on "+element.getText() +" successfully");
        }catch(Exception e){
            extentTestManager.get().log(Status.WARNING, "Failed to hover with following exception:"+e.getMessage());
        }
        return (T) this;
    }

    public T scrollTo(WebElement element){
        fluentWait.get().until(ExpectedConditions.visibilityOf(element));
        try{
            ((JavascriptExecutor) WebDriverManager.get()).executeScript("arguments[0].scrollIntoView(true);",element);
            extentTestManager.get().log(Status.INFO, "Hovered on "+element.getText() +" successfully");
        }catch(Exception e){
            extentTestManager.get().log(Status.WARNING, "Failed to hover with following exception:"+e.getMessage());
        }
        return (T) this;
    }

    public T click(WebElement element){
        waitForPageLoadToComplete();
        waitForAjaxCallsToComplete();
        fluentWait.get().until(ExpectedConditions.visibilityOf(element));
        try{
            element.click();
            extentTestManager.get().log(Status.INFO, "Clicked on "+element.getText() +" successfully");
        }catch(Exception e){
            extentTestManager.get().log(Status.WARNING, "Failed to click with following exception:"+e.getMessage());
        }
        return (T) this;
    }

    public void switchToNewTab(){
        String currentTab = WebDriverManager.get().getWindowHandle();
        for(String i:WebDriverManager.get().getWindowHandles()){
            if(!i.contentEquals(currentTab)){
                WebDriverManager.get().switchTo().window(i);
                break;
            }
        }
    }

    public String getCurrentUrl(){
        String url = null;
        try{
            url = WebDriverManager.get().getCurrentUrl();
            extentTestManager.get().log(Status.INFO, "Get URL is successful");
        }catch(Exception e){
            extentTestManager.get().log(Status.WARNING, "Failed to get URL with following exception:"+e.getMessage());
        }
        return url;
    }

    public String getText(WebElement element){
        fluentWait.get().until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public boolean isFound(WebElement element){
        try{
            fluentWait.get().until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void waitForPageLoadToComplete(){
        try{
            new WebDriverWait(WebDriverManager.get(),Duration.ofSeconds(15)).until(d -> ((JavascriptExecutor)WebDriverManager.get()).executeScript("return document.readyState").equals(new String[]{"complete", "interactive"}));
        }catch(Exception e){
            //do nothing
        }
    }

    public void waitForAjaxCallsToComplete(){
        try{
            fluentWait.get().until(d -> ((JavascriptExecutor)WebDriverManager.get()).executeScript("return jQuery.active == 0"));
        }catch(Exception e){
            //do nothing
        }
    }

    public void waitForVisibility(List<WebElement> element){
        try{
            fluentWait.get().until(ExpectedConditions.visibilityOfAllElements(element));
        }catch(Exception e){
            //logger
        }
    }

    public void waitForVisibility(WebElement element){
        try{
            fluentWait.get().until(ExpectedConditions.visibilityOfAllElements(element));
        }catch(Exception e){
            //logger
        }
    }

    public void isElementDisplayed(WebElement element){
        try{
            fluentWait.get().until((ExpectedCondition<Boolean>) d -> element.isDisplayed());
        }catch(Exception e){

        }
    }

    public void isElementNotDisplayed(WebElement element){
        try{
            fluentWait.get().until((ExpectedCondition<Boolean>) d -> !element.isDisplayed());
        }catch(Exception e){

        }
    }

    public void waitForInvisibility(WebElement element){
        try{
            fluentWait.get().until(ExpectedConditions.invisibilityOf(element));
        }catch(Exception e){

        }
    }





}
