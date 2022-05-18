import org.testng.annotations.Test;
import pages.LoginPage;

public class Task_8_Invalid_Process_Addition_Test extends SeleniumBaseTest {
    @Test
    public void addProcessWithFailureTest() {

        String shortProcessName = "ab";
        String expErrorMessage = "The field Name must be a string with a minimum length of 3 and a maximum length of 30.";

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(shortProcessName)
                .clickCreateNewProcessesWithFailure()
                .assertProcessNameError(expErrorMessage)
                .backToList()
                .assertProcessIsNotShown(shortProcessName);
    }
}

