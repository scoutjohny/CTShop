package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CTShopRegistrationPage;
import pages.YopmailPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CTShopTest extends BaseTest{

    @BeforeMethod
    @Parameters({"browser","env"})
    public void setup(String browser, String env) throws Exception {
        init(browser,"5");
        openApp(env);
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit){
        if(quit.equalsIgnoreCase("yes")){
            quit();
        }
    }

    @Test
    public void registrationTest() throws Exception {
        CTShopRegistrationPage ctShopRegistrationPage = new CTShopRegistrationPage(driver);
        ctShopRegistrationPage.clickOnProfileLink();
        ctShopRegistrationPage.clickOnEmailLoginButton();
        ctShopRegistrationPage.clickOnCreateAccountLink();
        ctShopRegistrationPage.typeIntoTheFirstNameField();
        ctShopRegistrationPage.typeIntoTheLastNameField();
        ctShopRegistrationPage.typeIntoTheEmailField();
        ctShopRegistrationPage.typeIntoThePasswordNameField();
        ctShopRegistrationPage.clickOnSubscribeCheckbox();
        ctShopRegistrationPage.clickOnRegisterButton();

        driver.get("https://yopmail.com/");
        YopmailPage yopmailPage = new YopmailPage(driver);
        yopmailPage.typeIntoLoginField();
        driver.switchTo().frame("ifmail");
        yopmailPage.clickOnConfirmationLink();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login_email")));
        ctShopRegistrationPage.typeIntoTheEmailLoginField();
        ctShopRegistrationPage.typeIntoThePasswordLoginField();
        ctShopRegistrationPage.clickOnLoginButton();
    }
}
