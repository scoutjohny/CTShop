package pages;

import org.bouncycastle.operator.bc.BcSymmetricKeyWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CTShopRegistrationPage extends BasePage{
    public CTShopRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='modal-link']")
    WebElement profileLink;

    @FindBy(xpath = "//p[text()='Email i šifra']")
    WebElement emailLoginButton;

    @FindBy(xpath = "//*[text()='Napravite nalog']")
    WebElement createAccountLink;

    @FindBy(css = "#firstname")
    WebElement firstNameField;

    @FindBy(css = "#lastname")
    WebElement lastNameField;

    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(css = "#password")
    WebElement passwordField;

    @FindBy(css = "#is_subscribed")
    WebElement subscribeCheckbox;

    @FindBy(css = "#registerBtn")
    WebElement registerButton;

    @FindBy(css = "#login_email")
    WebElement loginEmailField;

    @FindBy(css = "#login_password")
    WebElement loginPasswordField;

    @FindBy(css = "#loginBtn")
    WebElement loginButton;

    public void clickOnProfileLink () throws Exception {
        click(profileLink,"profile link");
    }

    public void clickOnEmailLoginButton() throws Exception {
        click(emailLoginButton,"email login button");
    }

    public void clickOnCreateAccountLink() throws Exception {
        click(createAccountLink,"Create account link");
    }

    public void typeIntoTheFirstNameField() throws Exception {
        typeText(firstNameField,"Tester","First name field");
    }

    public void typeIntoTheLastNameField() throws Exception {
        typeText(lastNameField,"Testerovic","Last name field");
    }

    public void typeIntoTheEmailField() throws Exception {
        typeText(emailField,"tester6@yopmail.com","email field");
    }

    public void typeIntoThePasswordNameField() throws Exception {
        typeText(passwordField,"Tester001!","Password field");
    }

    public void clickOnSubscribeCheckbox() throws Exception {
        click(subscribeCheckbox,"Subscribe checkbox");
    }

    public void clickOnRegisterButton() throws Exception {
        click(registerButton,"Register Button");
    }

    public void typeIntoTheEmailLoginField() throws Exception {
        typeText(loginEmailField,"tester6@yopmail.com","email login field");
    }

    public void typeIntoThePasswordLoginField() throws Exception {
        typeText(loginPasswordField,"Tester001!","password login field");
    }

    public void clickOnLoginButton() throws Exception {
        click(loginButton,"Login Button");
    }

}
