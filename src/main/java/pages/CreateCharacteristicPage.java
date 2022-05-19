package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateCharacteristicPage extends HomePage{


    public CreateCharacteristicPage(WebDriver driver) {
            super(driver);
        }

    @FindBy(id = "ProjectId")
    private WebElement projectSlc;

    @FindBy(css = ".field-validation-error[data-valmsg-for=UpperSpecificationLimit]")
    private WebElement processError;

    @FindBy(id = "Name")
    private WebElement nameTxt;

    @FindBy(id = "LowerSpecificationLimit")
    private WebElement lslTxt;

    @FindBy(id = "UpperSpecificationLimit")
    private WebElement uslTxt;

    @FindBy(linkText = "Back to List")
    private WebElement backToListBtn;

    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;


    public CreateCharacteristicPage selectProcess(String processName) {
        new Select(projectSlc).selectByVisibleText(processName);

        return this;
    }

    public CreateCharacteristicPage typeName(String characteristicName) {
        nameTxt.clear();
        nameTxt.sendKeys(characteristicName);

        return this;
    }

    public CreateCharacteristicPage typeLsl(String lsl) {
        lslTxt.clear();
        lslTxt.sendKeys(lsl);

        return this;
    }

    public CreateCharacteristicPage typeUsl(String usl) {
        uslTxt.clear();
        uslTxt.sendKeys(usl);

        return this;
    }


    public CharacteristicPage backToList() {
        backToListBtn.click();

        return new CharacteristicPage(driver);
    }

    public CharacteristicPage submitCreate() {
        createBtn.click();

        return new CharacteristicPage(driver);
    }

    public CreateCharacteristicPage submitCreateWithFailure() {
        createBtn.click();

        return this;
    }

    public CreateCharacteristicPage assertProcessError(String expError) {
        Assert.assertEquals(processError.getText(), expError);

        return this;
    }
}



