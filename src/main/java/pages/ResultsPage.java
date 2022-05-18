package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends HomePage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Add results sample")
    private WebElement clickAddResultSampleBtn;

    @FindBy(linkText = "Back to characteristics")
    private WebElement backBtn;

    public CreateResultsPage clickAddResult() {
        clickAddResultSampleBtn.click();
        return new CreateResultsPage(driver);

}
    public CharacteristicPage backToCharacteristics(){
        backBtn.click();

        return new CharacteristicPage (driver);
}}
