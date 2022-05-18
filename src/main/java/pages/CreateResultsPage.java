package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateResultsPage extends HomePage {
    public CreateResultsPage(WebDriver driver) {
        super(driver);
}

@FindBy (css = "#Sample")
private WebElement sampleNameTxt;

@FindBy (css ="#Values")
private WebElement resultsTxt;

    @FindBy(css = "input[type=submit]")
    private WebElement createResultsBtn;

    public CreateResultsPage sampleNameTxt(String sampleName) {
        sampleNameTxt.clear();
        sampleNameTxt.sendKeys(sampleName);

        return this;
    }
    public CreateResultsPage resultsTxt(String results){
        resultsTxt.clear();
        resultsTxt.sendKeys(results);
        return this;
    }

    public ResultsPage createResultsBtn(){
            createResultsBtn.click();
        return new ResultsPage(driver);
    }

}

