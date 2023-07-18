package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import pages.faker.GenerateDataForFormOfBirthday;
import pages.helpers.Attach;

import java.util.Map;

import static com.codeborne.selenide.Configuration.*;

public class TestBase {

    RegistrationPage page = new RegistrationPage();
    GenerateDataForFormOfBirthday generateDataForFormOfBirthday = new GenerateDataForFormOfBirthday();
    @BeforeAll
    static void beforeAll() {
        browser = System.getProperty("browser", "chrome");//"chrome";
        browserVersion = System.getProperty("version", "100");//"100.0";
        baseUrl = "https://demoqa.com";
        browserSize = System.getProperty("browser_size", "1920x1080");//"1920x1080";
        remote = System.getProperty("remote_url", "https://user1:1234@selenoid.autotests.cloud/wd/hub");//"https://user1:1234@selenoid.autotests.cloud/wd/hub";

        System.out.println(String.format("Browser is %s, version is %s, browser size is equal to %s, remote address is $s", browser, browserVersion, browserSize, remote));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot name");
        Attach.pageSource();
        Attach.addVideo();
        Attach.browserConsoleLogs();
        Attach.attachAsText("Simple text", "simple text");
    }
}
