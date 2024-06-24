package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoogleSearchpage {
    static WebDriver driver;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;

    public GoogleSearchpage(WebDriver driver) {
        this.driver = driver;
    }
    By searchbox = By.xpath("//*[@name=\"q\"]");
    By search_btn = By.xpath(("(//input[@name='btnK'])[1]"));
    By Benepik_Plus = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/div/div/div/div[1]/span");

     public void searchgoogle(String searchinput) {
        try {
            driver.findElement(searchbox).sendKeys(searchinput);
            driver.findElement(search_btn).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());
        }
    }
    public void Benepikplus() {
        try {
            driver.findElement(Benepik_Plus).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());
        }

    }

}
