package org.example;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import static org.example.GoogleSearchpage.extent;
import static org.example.GoogleSearchpage.sparkReporter;

public class BenepikSearchDeal  {
    public static WebDriver driver;
    GoogleSearchpage objectrepo;
    ChromeOptions opt = new ChromeOptions();

    @BeforeTest
    public void Browser() throws IOException {

        //This line will disable the information bar which it display while running automation.
        opt.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
        //use this syntax when you want to inspect
        // opt.addArguments("--auto-open-devtools-for-tabs");
        // This will open inspect of the page *
        WebDriverManager.chromedriver().setup(); // This line will automatically set up ChromeDriver
        driver = new ChromeDriver(opt); // Use the driver instance declared in the class
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        objectrepo = new GoogleSearchpage(driver);
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/Search_Deals_Report.html");
        sparkReporter.config().setDocumentTitle("BPlus_search_deal Automation Report");
        sparkReporter.config().setReportName("Search Deals Test Case");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setTimeStampFormat("EEEE,MMMM,dd,yyyy,hh:mm a '('ZZZ')'");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        // Clear screenshots directory before starting the tests
        String screenshotDir = System.getProperty("user.dir") + "/Report/screenshots";
        FileUtils.cleanDirectory(new File(screenshotDir));
    }
    @AfterTest
    public void endReport() {
        extent.flush();
    }
    public String captureScreenshot(String screenshotName) throws IOException {
        String FileSeparator = System.getProperty("file.separator");
        String ScreenshotPath = System.getProperty("user.dir") + FileSeparator + "Report" + FileSeparator + "screenshots";
        File screenshotDir = new File(ScreenshotPath);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
        String screenshotPath = ScreenshotPath + FileSeparator + screenshotName + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Test = new File(screenshotPath);
        if (Test.exists()) {
            Test.delete();
        }
        FileUtils.copyFile(src, Test);
//        return screenshotPath;
        byte[] fileContent = Files.readAllBytes(Test.toPath());
        // Encode byte array to Base64
        String base64Encoded = Base64.getEncoder().encodeToString(fileContent);
        // Construct data URI
        String dataURI = "data:image/png;base64," + base64Encoded;
        return dataURI;
    }
    @Test(priority = 0)
    public void SearchOperation() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Search Operation");
        long startTime = System.currentTimeMillis();
        try {
            GoogleSearchpage page = new GoogleSearchpage(driver);
            page.searchgoogle("Benepik Plus");
            test.log(Status.PASS, "Search Operation Passed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Search Operation Failed: " + e.getMessage());
        }
        long duration = System.currentTimeMillis() - startTime;
        test.log(Status.INFO, "Test duration: " + duration + " milliseconds");
        String screenshotPath = captureScreenshot("SearchOperation");
        test.addScreenCaptureFromPath(screenshotPath);
    }
    @Test(priority = 1)
    public void ClickOnBenepikPlus() throws IOException {
        ExtentTest test = extent.createTest("Click on Benepik Plus");
        long startTime = System.currentTimeMillis();
        try {
            GoogleSearchpage page = new GoogleSearchpage(driver);
            page.Benepikplus();
            test.log(Status.PASS, "Clicked on Benepik Plus Passed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Clicked on Benepik Plus Failed: " + e.getMessage());
        }
        long duration = System.currentTimeMillis() - startTime;
        test.log(Status.INFO, "Test duration: " + duration + " milliseconds");
        String screenshotPath = captureScreenshot("ClickOnBenepikPlus");
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Test(priority = 2)
    public void SelectCountry() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Select Country");
        long startTime = System.currentTimeMillis();
        try {
            BenepikPlusWebPage page = new BenepikPlusWebPage(driver);
            page.ChooseCountry();
            test.log(Status.PASS, "Select Country Passed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Select Country Failed: " + e.getMessage());
            Assert.fail("Select Country Failed: " + e.getMessage());
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            test.log(Status.INFO, "Test duration: " + duration + " milliseconds");
            String screenshotPath = captureScreenshot("SelectCountry");
            test.addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Test(priority = 3)
    public void ConfirmOtp() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Confirm OTP");
        long startTime = System.currentTimeMillis();
        try {
            BenepikPlusWebPage page = new BenepikPlusWebPage(driver);
            page.ConfirmOtp();
            test.log(Status.PASS, "Confirm OTP Passed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Confirm OTP Failed: " + e.getMessage());
            Assert.fail("Confirm OTP Failed: " + e.getMessage());
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            test.log(Status.INFO, "Test duration: " + duration + " milliseconds");
            String screenshotPath = captureScreenshot("ConfirmOTP");
            test.addScreenCaptureFromPath(screenshotPath);
            extent.flush();
        }
    }

    @Test(priority = 4)
    public void SearchDeals() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("Search Deals");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
            BenepikPlusWebPage page = new BenepikPlusWebPage(driver);
            page.SearchBar();
            test.log(Status.PASS, "Search Deals Passed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Search Deals Failed: " + e.getMessage());
            Assert.fail("Search Deals Failed: " + e.getMessage());
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            test.log(Status.INFO, "Test duration: " + duration + " milliseconds");
            String screenshotPath = captureScreenshot("SearchDeals");
            test.addScreenCaptureFromPath(screenshotPath);
            extent.flush();
        }
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
