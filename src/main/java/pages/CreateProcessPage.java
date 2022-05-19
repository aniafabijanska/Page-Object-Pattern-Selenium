package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateProcessPage extends HomePage {
    public CreateProcessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Name")
    private WebElement nameTxt;

    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;

    @FindBy(css = ".field-validation-error[data-valmsg-for=Name]")
    private WebElement nameError;

    @FindBy(linkText = "Back to List")
    private WebElement backToListBtn;

    public ProcessesPage backToList() {
        backToListBtn.click();

        return new ProcessesPage(driver);
    }


    public CreateProcessPage typeName(String processName) {
        nameTxt.clear();
        nameTxt.sendKeys(processName);

        return this;
    }

    public ProcessesPage clickCreateNewProcesses() {

        createBtn.click();
        return new ProcessesPage(driver);
    }

    public CreateProcessPage clickCreateNewProcessesWithFailure() {

        createBtn.click();
        return new CreateProcessPage(driver);
    }


    public CreateProcessPage assertProcessNameError(String errorMessage) {
        Assert.assertTrue(nameError.isDisplayed(), "The field Name must be a string with a minimum length of 3 and a maximum length of 30.");

        return this;
    }


}


