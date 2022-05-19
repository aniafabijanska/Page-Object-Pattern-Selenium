import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class Task_11_Invalid_Characteristic_Addition_Test_BlankUpperSpecificaField extends SeleniumBaseTest {
    @Test
    public void addCharacteristic() {
        String processName = "DEMO PROJECT";
        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lsl = "8";

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToCharacteristics()
                .addNewCharacteristicBtn()
                .selectProcess(processName)
                .typeName(characteristicName)
                .typeLsl(lsl)
                .submitCreateWithFailure()
                .assertProcessError("The value '' is invalid.")
                .backToList()
                .assertCharacteristicIsNotShown(characteristicName);

    }
}
