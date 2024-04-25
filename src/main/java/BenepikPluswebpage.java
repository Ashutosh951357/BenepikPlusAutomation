import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BenepikPluswebpage {
    By India =By.xpath("/html/body/app-root/div/app-newmain/div[1]/app-newheader/div/div[2]/div/div/div/div[2]/div[1]/div/div[1]");
    By SelectCountry = By.xpath("//*[@id=\"continueId\"]");
    By Handlenotification =By.xpath("/html/body/app-root/div/app-newmain/div[2]/div/div[1]/div/div/div/app-newlogin/div[2]/div/div/div[3]/button[1]");
    By EnterPhonenumber= By.xpath("//*[@id=\"inputID\"]");
    By Submit=By.xpath("//*[@id=\"loginSubmitID\"]");
    By OTP=By.xpath("//*[@id=\"submitOtpId\"]");

    WebDriver driver;

    public BenepikPluswebpage(WebDriver driver) {
        this.driver = driver;
    }


        public void Choosecountry () throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(India).click();
            Thread.sleep(2000);
            driver.findElement(SelectCountry).click();
            driver.findElement(EnterPhonenumber).clear();
            driver.findElement(EnterPhonenumber).sendKeys("9953272445");
            driver.findElement(Submit).click();
            Thread.sleep(3000);
            driver.findElement(Submit).click();
            Thread.sleep(3000);
            driver.findElement(Handlenotification).click();

        }
        public void ConfirmOtp() throws InterruptedException {
        Thread.sleep(22000);
        driver.findElement(OTP).click();

        }

    }
