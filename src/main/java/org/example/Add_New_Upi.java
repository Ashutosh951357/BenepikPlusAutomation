package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Add_New_Upi {
    public static WebDriver driver;
    org.example.GoogleSearchpage objectrepo;
    ChromeOptions opt = new ChromeOptions();
    @BeforeTest
    public void Browser() {
        opt.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
        //This line will disable the information bar which it display while running automation.
        WebDriverManager.chromedriver().setup(); // This line will automatically set up ChromeDriver
        driver = new ChromeDriver(opt); // Use the driver instance declared in the class
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @Test(priority = 0)
    public void GoogleSearchOperation() throws InterruptedException {
        org.example.GoogleSearchpage page = new org.example.GoogleSearchpage(driver);
        page.searchgoogle("Benepik Plus");

    }

    @Test(priority = 1)
    public void ClickOnBenepikPlus() throws InterruptedException {
        objectrepo = new org.example.GoogleSearchpage(driver);
        objectrepo.Benepikplus();
    }

    @Test(priority = 2)
    public void ValidatedPhoneNumber() throws InterruptedException {
        BenepikPlusWebPage obj2 = new BenepikPlusWebPage(driver);
        obj2.ChooseCountry();
        obj2.ConfirmOtp();
    }
    @Test(priority = 3)
    public void Upi_button() throws InterruptedException {
        BenepikPlusWebPage obj2=new BenepikPlusWebPage(driver);
        obj2.Upi_Transfer();
    }
    @Test(priority = 4)
    public void Add_new_upi_account() throws InterruptedException {
        BenepikPlusWebPage obj2=new BenepikPlusWebPage(driver);
        obj2.Add_new_UPI_Account();
    }


}
