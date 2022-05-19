package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ReportPage extends HomePage {
    public ReportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[text()='Mean (x)']/../td[2]")
    private WebElement meanCell;
    @FindBy(xpath = "//td[text()='Lower Specification Limit (LSL)']/../td[2]")
    private WebElement lslCell;
    @FindBy(xpath = "//td[text()='Upper Specification Limit (USL)']/../td[2]")
    private WebElement uslCell;
    @FindBy(xpath = "//td[text()='Standard deviation (s)']/../td[2]")
    private WebElement standardDeviationCell;

    public ReportPage assertMean(String expMean) {
        Assert.assertEquals(meanCell.getText(), expMean);
        return this;
    }
    public ReportPage assertLSL(String expLSL) {
        Assert.assertEquals(lslCell.getText(), expLSL);
        return this;
    }
    public ReportPage assertUSL(String expUSL) {
        Assert.assertEquals(uslCell.getText(), expUSL);
        return this;
    }
    public ReportPage assertDeviation(String expDeviation) {
        Assert.assertEquals(standardDeviationCell.getText(), expDeviation);
        return this;
    }

}
