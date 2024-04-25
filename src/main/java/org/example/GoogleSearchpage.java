package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchpage {
    WebDriver driver;

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
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());
        }
    }

    public void Benepikplus() {
        try {
            driver.findElement(Benepik_Plus).click();

            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());

        }

    }
}
