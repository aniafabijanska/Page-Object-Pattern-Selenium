package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DashboardsPage extends HomePage {


    public DashboardsPage(WebDriver driver) {
        super(driver);

    }

    private String GENERIC_PROCESS_XPATH = "//h2[contains(text(),'%s')]";
    private String GENERIC_CHARACTERISTIC_XPATH = "//p[contains(text(),'%s')]";

    @FindBy(css = ".x_title h2")
    private WebElement dashboardHeader;

    public DashboardsPage assertDashboardUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);
        return this;
    }

    public DashboardsPage assertDashboardHeader() {
        Assert.assertEquals(dashboardHeader.getText(), "DEMO PROJECT");
        return this;
    }

    public DashboardsPage assertcharacteristicOnDashboard(String expCharacteristicName) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_XPATH, expCharacteristicName);
        WebElement characteristic = driver.findElement(By.xpath(characteristicXpath));
        Assert.assertTrue(characteristic.isDisplayed());
        return this;
    }


    public DashboardsPage assertProcessOnDashboard(String expProcessName) {
        String characteristicXpath = String.format(GENERIC_PROCESS_XPATH, expProcessName);
        WebElement process = driver.findElement(By.xpath(characteristicXpath));
        Assert.assertTrue(process.isDisplayed());
        return this;
    }
}



