package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.util.List;

public class RegistrationPage {
    protected WebDriver driver;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(css = "#Email-error")
    public WebElement emailError;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    @FindBy (id = "ConfirmPassword-error")
    public List<WebElement> confirmationPasswordErrors;

    @FindBy (xpath = "//li")
    public List<WebElement> passwordError;


    public RegistrationPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);

        return this;

    }

    public RegistrationPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        return this;
    }

    public RegistrationPage typeConfirmPassword(String confirmPassword) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(confirmPassword);

        return this;
    }

    public HomePage submitRegister() {
        registerBtn.click();
        return new HomePage(driver);
    }

    public RegistrationPage submitRegisterWithFailure() {
        registerBtn.click();
        return this;
    }

    public RegistrationPage assertPasswordErrorIsShown(String expectedError) {
        boolean doesErrorExists = false;
        for (int i = 0; i < confirmationPasswordErrors.size(); i++) {
            if (confirmationPasswordErrors.get(i).getText().equals(expectedError)) {
                doesErrorExists = true;
                break;
            }}

        Assert.assertTrue(doesErrorExists);

        return this;

    }

    public RegistrationPage assertPasswordErrorIsShownUppercase (String expectedError) {
        boolean doesErrorExists = true;
        for (int i = 0; i < passwordError.size(); i++) {
            if (passwordError.get(i).getText().equals(expectedError)) {
                doesErrorExists = false;
                break;
            }}

        Assert.assertTrue(doesErrorExists);

        return this;

    }
}


