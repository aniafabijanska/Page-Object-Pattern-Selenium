package pages;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProcessesPage extends HomePage {

    private String PAGE_URL = new Config().getApplicationUrl() + "Projects";

    private String GENERIC_PROCESS_ROW_XPATH = "//td[text()='%s']/..";

    public ProcessesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-title h3")
    private WebElement processesHeader;

    @FindBy(linkText = "Add new process")
    private WebElement addProcessBtn;

    public CreateProcessPage clickAddProcess() {
        addProcessBtn.click();

        return new CreateProcessPage(driver);
    }

    public ProcessesPage assertProcessesUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);

        return this;
    }


    public ProcessesPage assertProcessesHeader() {
        Assert.assertEquals(processesHeader.getText(), "Processes");

        return this;
    }


    public ProcessesPage assertProcess(String expName, String expDescription, String expNotes) {
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, expName);

        WebElement processRow = driver.findElement(By.xpath(processXpath));

        String actDescription = processRow.findElement(By.xpath("./td[2]")).getText();
        String actNotes = processRow.findElement(By.xpath("./td[2]")).getText();

        Assert.assertEquals(actDescription, expDescription);
        Assert.assertEquals(actNotes, expNotes);

        return this;
    }

    public ProcessesPage assertProcessIsNotShown(String processName) {
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, processName);
        List<WebElement> process = driver.findElements(By.xpath(processXpath));
        Assert.assertEquals(process.size(), 0);

        return this;
    }
}
