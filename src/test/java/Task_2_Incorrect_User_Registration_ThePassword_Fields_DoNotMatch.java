import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.LoginPage;


import java.time.Duration;
import java.util.Locale;

public class Task_2_Incorrect_User_Registration_ThePassword_Fields_DoNotMatch extends SeleniumBaseTest {
    Faker faker = new Faker(new Locale("pl-PL"));
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("pl-PL"), new RandomService());
    String password = faker.internet().password();
        public String password(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeSpecial, boolean includeDigit) {
            if (includeSpecial) {
                char[] password = faker.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigit).toCharArray();
                char[] special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*'};
                for (int i = 0; i < faker.random().nextInt(minimumLength); i++) {
                    password[faker.random().nextInt(password.length)] = special[faker.random().nextInt(special.length)];
                }
                return new String(password);
            } else {
                return faker.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigit);
            }
        }
        @Test()
        public void incorrectPasswordTest() {


            new LoginPage(driver)
                    .submitRegister()
                    .typeEmail(config.getApplicationUser())
                    .typePassword(password(6,15, true,true,true))
                    .typeConfirmPassword(password(6,15, true, false, true))
                    .submitRegisterWithFailure()
                    .assertPasswordErrorIsShown("The password and confirmation password do not match.");


        }

    }


