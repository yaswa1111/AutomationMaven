package testutilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import utilities.driverCreator;

import java.time.Duration;

import static utilities.ExtentReport.*;
import static utilities.driverCreator.*;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        extentReports.attachReporter(spark);
        WebDriverListener webDriverListener = new listener();
        browser.set(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser"));

        if(browser.get().equalsIgnoreCase("chrome")){
            WebDriverManager.set(new EventFiringDecorator<>(webDriverListener).decorate(new driverCreator().createChromeDriver()));
        } else if (browser.get().equalsIgnoreCase("firefox")) {
            WebDriverManager.set(new EventFiringDecorator<>(webDriverListener).decorate(createFirefoxDriver()));
        } else if (browser.get().equalsIgnoreCase("edge")) {
            WebDriverManager.set(new EventFiringDecorator<>(webDriverListener).decorate(createEdgeDriver()));
        }

        fluentWait.set(new FluentWait<>(WebDriverManager.get())
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(2L))
                .ignoring(NoSuchElementException.class));

        webDriverWait.set(new WebDriverWait(WebDriverManager.get() , Duration.ofSeconds(30)));
        extentTestManager.set(extentReports.createTest(scenario.getName() + "-" + browser.get()));
    }

    @After
    public void teardown(){
        extentTestManager.remove();
        extentReports.flush();
        WebDriverManager.get().quit();
    }
}
