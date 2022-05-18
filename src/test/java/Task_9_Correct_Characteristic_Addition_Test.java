import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class Task_9_Correct_Characteristic_Addition_Test extends SeleniumBaseTest{
    @Test
    public void addCharacteristic(){
        String processName = "DEMO PROJECT";
        String characteristicName = UUID.randomUUID().toString().substring(0, 10);
        String lsl = "8";
        String usl = "10";

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
                .assertCharacteristic(characteristicName, lsl, usl, "");
    }
}


