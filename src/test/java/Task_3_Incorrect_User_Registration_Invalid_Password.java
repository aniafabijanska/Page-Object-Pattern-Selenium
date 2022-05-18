import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Task_3_Incorrect_User_Registration_Invalid_Password  extends SeleniumBaseTest{
    @DataProvider
    public static Object[][] getWrongPasswords() {
        return new Object[][] {
                { "test" , "Password is to short" },
                { "test1!" , "Password does not have capital letter" },
                { "test1" , "Passwords must have at least one non alphanumeric character." }
        };
    }
    @Test (dataProvider = "getWrongPasswords" )
    public void incorrectPasswordTest(String wrongPassword, String expErrorMessage) {


        new LoginPage(driver)
                .submitRegister()
                .typeEmail(config.getApplicationUser())
                .typePassword(wrongPassword)
                .typeConfirmPassword(wrongPassword)
                .submitRegisterWithFailure()
                .assertPasswordErrorIsShownUppercase(expErrorMessage);


    }
}
