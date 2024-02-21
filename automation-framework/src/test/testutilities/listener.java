package testutilities;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;

import static utilities.ExtentReport.extentTestManager;

public class listener implements WebDriverListener  {
    @Override
    public void beforeGet(WebDriver driver, String url) {
        extentTestManager.get().log(Status.INFO, "Attempting to get "+ url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        extentTestManager.get().log(Status.INFO, "Successfully got "+ url);
    }

    @Override
    public void beforeClick(WebElement element) {
        extentTestManager.get().log(Status.INFO, "Attempting to click on "+element.getText());
    }

    @Override
    public void afterClick(WebElement element) {
        extentTestManager.get().log(Status.INFO, "click successful on "+element);
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        extentTestManager.get().log(Status.INFO, "Attempting to send keys "+ Arrays.toString(keysToSend) +" to "+element.getTagName());
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        extentTestManager.get().log(Status.INFO, "sending "+ Arrays.toString(keysToSend) +" to "+element.getTagName());
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        extentTestManager.get().log(Status.INFO, "Attempting to find element using driver by "+ locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        extentTestManager.get().log(Status.INFO, "Finding Webelement" +result.toString() + " using driver by "+ locator);
    }

    @Override
    public void beforeFindElement(WebElement element, By locator) {
        extentTestManager.get().log(Status.INFO, "Attempting to find element using element by "+ locator);
    }

    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
        extentTestManager.get().log(Status.INFO, "Finding Webelement" +result.toString() + " using element by "+ locator);
    }
}
