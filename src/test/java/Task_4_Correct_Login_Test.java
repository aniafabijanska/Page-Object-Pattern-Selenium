import org.testng.annotations.Test;
import pages.LoginPage;

public class Task_4_Correct_Login_Test extends SeleniumBaseTest{
    @Test
    public void correctLoginTest(){
        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin();

    }
}
