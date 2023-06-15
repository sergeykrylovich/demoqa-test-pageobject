package tests;

import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.faker.GenerateDataForFormOfBirthday;

import static com.codeborne.selenide.Configuration.*;

public class TestBase {

    RegistrationPage page = new RegistrationPage();
    GenerateDataForFormOfBirthday generateDataForFormOfBirthday = new GenerateDataForFormOfBirthday();
    @BeforeAll
    static void beforeAll() {

        browser = "chrome";
        baseUrl = "https://demoqa.com";
        browserSize = "1920x1080";
    }
}
