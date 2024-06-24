package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BenepikPlusWebPage {
    By India =By.xpath("/html/body/app-root/div/app-newmain/div[1]/app-newheader/div/div[2]/div/div/div/div[2]/div[1]/div/div[1]");
    By SelectCountry = By.xpath("//*[@id=\"continueId\"]");
    By HandleNotification =By.xpath("/html/body/app-root/div/app-newmain/div[2]/div/div[1]/div/div/div/app-newlogin/div[2]/div/div/div[3]/button[1]");
    By EnterPhoneNumber= By.xpath("//*[@id=\"inputID\"]");
    By Submit=By.xpath("//*[@id=\"loginSubmitID\"]");
    By Six_digit_OTP=By.xpath("//*[@id=\"otpNoId\"]");
    // Click on the blank portion for OTP
    By OTP=By.xpath("//*[@id=\"submitOtpId\"]");
    By Search =By.xpath("//*[@id=\"navbarSupportedContent\"]/div/div/div[2]/div/div/div[1]/div/div/div");
    By Search_Bar=By.xpath("//*[@id=\"test\"]");
    By UpiTransferButton= By.xpath("//*[@id=\"upiHomeBtnId\"]");
    //To transfer reward points to UPI account
    By SelectUpiId = By.xpath("//*[@id=\"upilListInputId0\"]");
    // To select UPI account you want to transfer
    By ClientTransfer = By.xpath("//*[@id=\"upiListBtnId1\"]");
    //To Select the client amount you want to transfer
    By Upi_Transfer_amount =By.xpath("//*[@id=\"addAccountHolderNameInp\"]");
    //Enter the UPI amount you want to transfer
    By Upi_Transfer_Confirm=By.xpath("//*[@id=\"transferBtn\"]");
    //confirm the amount
    By Upi_Transfer_Confirm_Otp=By.xpath("/html/body/app-root/div/app-upitransfer/div[2]/div[2]/div/div/div/div[2]/button");
            //confirm the otp so that money transfer into selected account
    By Delete_UPI_Account=By.xpath("//*[@id=\"upilListRemoveId0\"]");
    //Delete UPI Account
    By Confirm_delete_UPI_account=By.xpath("//*[@id=\"upiRemoveOkId\"]");
    //Confirm if you really wants to delete
    By Add_new_upi_account=By.xpath("//*[@id=\"addNewUpiAccountBtn\"]");
    //Add new upi account
    By Add_Beneficiary_Name=By.xpath("//*[@id=\"formarrinput0\"]");
    //Add Beneficiary name for new upi account
    By New_UPI_Id=By.xpath("//*[@id=\"formarrinput1\"]");
    // Add new upi id
    By Save_UPI_Id=By.xpath("//*[@id=\"saveAccountDetailBtn\"]");
    //Save new upi id
    By Confirm_UPI_Id=By.xpath("//*[@id=\"upiAddId\"]");
    // confirm the new account by entering otp
    By Bank_Transfer_Button= By.xpath("//*[@id=\"bankHomeBtnId\"]");
    //click on bank transfer button
    By Select_Bank_Account=By.xpath("//*[@id=\"SelectId0\"]");
    //Select bank account details
    By Transfer_amount_bank=By.xpath("//*[@id=\"addNewAccountBtn1\"]");
    //select the client reward point
    By Bank_Transfer_Amount=By.xpath("//*[@id=\"addAccountHolderNameInp\"]");
    //Enter the amount you want to tranfer into bank
    By Confirm_Bank_amount=By.xpath("//*[@id=\"transferBtn\"]");
    //confirm the amount you want to deduct
    By Confirm_OTP_Bank_Transfer=By.xpath("/html/body/app-root/div/app-finalbanktransfer/div[2]/div[2]/div/div/div/div[2]/button");
    //Click on Redemption code Button
    By Redemption_Button = By.xpath("//button[text()='ACTIVATE NOW']");
    // Click on Add money after entering redemption code
    By Add_Money_Redemption =By.xpath("//*[@id=\"addMoneyId\"]");

    WebDriver driver;
    public BenepikPlusWebPage(WebDriver driver) {
        this.driver = driver;
    }
        public void ChooseCountry () throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(India).click();
            Thread.sleep(2000);
            driver.findElement(SelectCountry).click();
            driver.findElement(EnterPhoneNumber).clear();
            driver.findElement(EnterPhoneNumber).sendKeys("9953272445");
            driver.findElement(Submit).click();
            Thread.sleep(3000);
            driver.findElement(Submit).click();
            driver.findElement(HandleNotification).click();
        }
        public void ConfirmOtp() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(Six_digit_OTP).click();
        Thread.sleep(19000);
        driver.findElement(OTP).click();

        }
        public void SearchBar() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(Search_Bar).click();
        driver.findElement(Search_Bar).sendKeys("Flipkart");
        Thread.sleep(4000);
        driver.findElement(Search).click(); // click on flipkart
        }
        public void Upi_Transfer() throws InterruptedException
        //Transfer Reward point through UPI
        {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(4000);
            driver.findElement(UpiTransferButton).click();
        }
        public void Select_Upi_Account() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);
            driver.findElement(SelectUpiId).click();
            Thread.sleep(1000);
            driver.findElement(ClientTransfer).click();
            driver.findElement(Upi_Transfer_amount).sendKeys("2");
            Thread.sleep(2000);
            driver.findElement(Upi_Transfer_Confirm).click();
            Thread.sleep(18000);
            driver.findElement(Upi_Transfer_Confirm_Otp).click();
        }
        public void Delete_UPI_Id() throws InterruptedException
        //Delete UPI Id so that we can add new UPI Id
        {
            Thread.sleep(8000);
            driver.findElement(UpiTransferButton).click();
        }
        public void Confirm_delete_upi() throws InterruptedException {
            //Delete UPI Id so that we can add new UPI Id
            Thread.sleep(3000);
            driver.findElement(Delete_UPI_Account).click();
            Thread.sleep(2000);
            driver.findElement(Confirm_delete_UPI_account).click();
        }

        public void Add_new_UPI_Account() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(Add_new_upi_account).click();
        Thread.sleep(3000);
        driver.findElement(Add_Beneficiary_Name).sendKeys("Ashutosh Kumar Gupta");
        driver.findElement(New_UPI_Id).sendKeys("9953272445@paytm");
        driver.findElement(Save_UPI_Id).click();
        Thread.sleep(18000);
        driver.findElement(Confirm_UPI_Id).click();
        }
        public void Bank_Transfer() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(Bank_Transfer_Button).click();
        Thread.sleep(3000);
        driver.findElement(Select_Bank_Account).click();
        driver.findElement(Transfer_amount_bank).click();
        driver.findElement(Bank_Transfer_Amount).sendKeys("4");
        driver.findElement(Confirm_Bank_amount).click();
        Thread.sleep(19000);
        driver.findElement(Confirm_OTP_Bank_Transfer).click();
        }
        public void Redemption() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(Redemption_Button).click();
        Thread.sleep(19000);
        driver.findElement(Add_Money_Redemption).click();

        }
}


