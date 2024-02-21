package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    public static ExtentReports extentReports = new ExtentReports();
    public static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    public static ThreadLocal<ExtentTest> extentTestManager = new ThreadLocal<>();

}
