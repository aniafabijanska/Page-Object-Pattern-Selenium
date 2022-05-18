import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class Task_6_Correct_Process_Addition_Test extends SeleniumBaseTest{


    @Test
    public void addProcessTest() {
        String processName = UUID.randomUUID().toString().substring(0, 10);

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(processName)
                .clickCreateNewProcesses()
                .assertProcess(processName, "", "");

    }
}

