import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BenepikPluswebpage {
    By SelectCountry = By.xpath("//*[@id=\"continueId\"]");

    WebDriver driver;

    public BenepikPluswebpage(WebDriver driver) {
        this.driver = driver;
    }


        public void Choosecountry () {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(SelectCountry).click();
        }

    }
