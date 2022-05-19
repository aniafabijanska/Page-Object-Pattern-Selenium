package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.EOFException;
import java.util.List;
import java.util.NoSuchElementException;

public class CharacteristicPage<goToResults, driver> extends HomePage {


    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//td[text()='%s']/..";
    private String GENERIC_CHARACTERISTIC_RESULTS_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Results')]";
    private String GENERIC_CHARACTERISTIC_REPORT_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Report')]";


    public CharacteristicPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".page-title h3")
    private WebElement characteristicHeader;

    @FindBy(linkText = "Add new characteristic")
    private WebElement addNewCharacteristicBtn;


    public CharacteristicPage assertCharacteristicUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);
        return this;
    }

    public CharacteristicPage assertCharacteristicsHeader() {
        Assert.assertEquals(characteristicHeader.getText(), "Characteristics");
        return this;
    }


    public CreateCharacteristicPage addNewCharacteristicBtn() {
        addNewCharacteristicBtn.click();

        return new CreateCharacteristicPage(driver);
    }


    public CharacteristicPage assertCharacteristic(String expName, String expLsl, String expUsl, String expBinCount) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, expName);
        WebElement characteristicRow = driver.findElement(By.xpath(characteristicXpath));

        String actLsl = characteristicRow.findElement(By.xpath("./td[3]")).getText();
        String actUsl = characteristicRow.findElement(By.xpath("./td[4]")).getText();
        String actBinCount = characteristicRow.findElement(By.xpath("./td[5]")).getText();

        Assert.assertEquals(actLsl, expLsl);
        Assert.assertEquals(actUsl, expUsl);
        Assert.assertEquals(actBinCount, expBinCount);

        return this;
    }

    public CharacteristicPage assertCharacteristicIsNotShown(String characteristicName) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, characteristicName);
        List<WebElement> characteristic = driver.findElements(By.xpath(characteristicXpath));
        Assert.assertEquals(characteristic.size(), 0);

        return this;
    }


    public ResultsPage goToResults(String characteristicName) {
        String resultsBtnXpath = String.format(GENERIC_CHARACTERISTIC_RESULTS_XPATH, characteristicName);


        try {
            driver.findElement(By.xpath(resultsBtnXpath)).click();
            throw new Exception();
        } catch(Exception e) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            WebElement goToResults = driver.findElement(By.xpath(resultsBtnXpath));
            jse.executeScript("arguments[0].scrollIntoView()", goToResults);

        }finally {
            driver.findElement(By.xpath(resultsBtnXpath)).click();
        }return new ResultsPage(driver);
    }



    public ReportPage goToReport(String characteristicName) {
        String reportBtnXpath = String.format(GENERIC_CHARACTERISTIC_REPORT_XPATH, characteristicName);
                try {
            driver.findElement(By.xpath(reportBtnXpath)).click();
            throw new Exception();
        } catch(Exception e) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            WebElement goToResults = driver.findElement(By.xpath(reportBtnXpath));
            jse.executeScript("arguments[0].scrollIntoView()", goToResults);

        }finally {
            driver.findElement(By.xpath(reportBtnXpath)).click();
        }return new ReportPage(driver);
    }


}



