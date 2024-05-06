package Crossbrowsertest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

    WebDriver driver;
    FirefoxOptions firefoxOptions=new FirefoxOptions();
    ChromeOptions chromeOptions = new ChromeOptions();
    EdgeOptions edgeOptions=new EdgeOptions();
    @Parameters("browser")
    @BeforeTest
    public void initialize(@Optional("chrome")String browser){

        if(browser.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            System.out.println("Firefox browser launched");
            driver.manage().window().maximize();

        }

        else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("Chrome browser launched");

        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            System.setProperty("webdriver.edge.driver","D:\\edgedriver_win64\\edgedriver.exe");
            driver=new EdgeDriver();
            System.out.println("Edge browser launched");

        }

    }

@Test
    public void Benepikpluslogin(){
        driver.get("https://www.benepik.com/");
        String actual=driver.getTitle();
        String expected="Benepik";
    Assert.assertEquals(actual.contains("Benepik"),expected.contains("Benepik"));

    }
}
