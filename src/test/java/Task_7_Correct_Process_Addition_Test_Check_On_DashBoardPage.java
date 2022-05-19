import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class Task_7_Correct_Process_Addition_Test_Check_On_DashBoardPage extends SeleniumBaseTest {
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
                .goToDashboard()
                .assertProcessOnDashboard(processName);

    }
}
