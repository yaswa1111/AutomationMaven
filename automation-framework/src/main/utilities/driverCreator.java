package utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

public class driverCreator {

    public static ThreadLocal<WebDriver> WebDriverManager = new ThreadLocal<>();
    public static ThreadLocal<WebDriverWait> webDriverWait = new ThreadLocal<>();
    public static ThreadLocal<FluentWait<WebDriver>> fluentWait = new ThreadLocal<>();
    public static ThreadLocal<String> browser = new ThreadLocal<>();

    public static WebDriver createChromeDriver(){
        String path = System.getProperty("driverPath");
        System.setProperty("webdriver.chrome.driver",path + "/automation-framework/src/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        return driver;
    }

    public static WebDriver createFirefoxDriver(){
        String path = System.getProperty("driverPath");
        System.setProperty("webdriver.gecko.driver", path + "/automation-framework/src/resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--host=::1");
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        return driver;
    }

    public static WebDriver createEdgeDriver(){
        String path = System.getProperty("driverPath");
        System.setProperty("webdriver.edge.driver", path + "/automation-framework/src/resources/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.addArguments("guest");
        WebDriver driver = new EdgeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        return driver;
    }
}
