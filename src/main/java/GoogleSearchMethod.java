

import io.github.bonigarcia.wdm.WebDriverManager;

import object.GoogleSearchpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class GoogleSearchMethod {
    WebDriver driver;
    GoogleSearchpage objectrepo;
    ChromeOptions opt = new ChromeOptions();


    @BeforeTest
    public void beforetest() {
        opt.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
        //This line will disable the information bar which it display while running automation.
        WebDriverManager.chromedriver().setup(); // This line will automatically set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(opt); // Use the driver instance declared in the class
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

    }

    @Test(priority = 0)
    public void SearchOperation() throws InterruptedException {
        GoogleSearchpage page = new GoogleSearchpage(driver);
        page.searchgoogle("Benepik Plus");

    }
    @Test(priority = 1)
    public void clckonBenepikplus() {
        objectrepo = new GoogleSearchpage(driver);
        objectrepo.Benepikplus();
    }
    @Test(priority = 2)
    public void Selectcountry() {
        BenepikPluswebpage page = new BenepikPluswebpage(driver);
        page.Choosecountry();


    }
}
