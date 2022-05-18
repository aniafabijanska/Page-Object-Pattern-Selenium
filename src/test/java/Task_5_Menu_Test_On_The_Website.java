import org.testng.annotations.Test;
import pages.LoginPage;

public class Task_5_Menu_Test_On_The_Website extends SeleniumBaseTest{
    @Test
    public void correctMenuTest(){
        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .assertProcessesUrl("http://localhost:4444/Projects")
                .assertProcessesHeader()
                .goToCharacteristics()
                .assertCharacteristicUrl("http://localhost:4444/Characteristics")
                .assertCharacteristicsHeader()
                .goToDashboard()
                .assertDashboardUrl("http://localhost:4444/")
                .assertDashboardHeader();




    }
}