import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;


import java.time.Duration;
import java.util.Locale;
import java.util.UUID;


public class Task_1_Correct_User_Registration_Test extends SeleniumBaseTest{
  @Test
    public void playWithWebDriver() {
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.quit();}



        @DataProvider
        public Object[][] getCorrectEmails() {
            return new Object[][]{
                    {email}
            };
        }
    Faker faker = new Faker(new Locale("pl-PL"));
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("pl-PL"), new RandomService());
    String email = faker.internet().emailAddress();

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
        @Test(dataProvider = "getCorrectEmails")
        public void correctEmailTest(String CorrectEmail) {


            new LoginPage(driver)
                    .submitRegister()
                    .typeEmail(CorrectEmail)
                    .typePassword(password(6,15, true, true, true))
                    .typeConfirmPassword(CorrectEmail)
                    .submitRegister();


        }

    }




