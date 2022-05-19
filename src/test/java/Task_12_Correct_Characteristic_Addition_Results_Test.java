import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class Task_12_Correct_Characteristic_Addition_Results_Test extends SeleniumBaseTest {
    @Test
    public void reportTest() {
        String processName = "DEMO PROJECT";
        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lsl = "8";
        String usl = "10";
        String sampleName = "Test sample";
        String results = "8.0;9.0";
        String expMean = "8.5000";

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToCharacteristics()
                .addNewCharacteristicBtn()
                .selectProcess(processName)
                .typeName(characteristicName)
                .typeLsl(lsl)
                .typeUsl(usl)
                .submitCreate()
                .goToResults(characteristicName)
                .clickAddResult()
                .sampleNameTxt(sampleName)
                .resultsTxt(results)
                .createResultsBtn()
                .backToCharacteristics();


    }
}
