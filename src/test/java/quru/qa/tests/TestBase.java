package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import quru.qa.helpers.Attach;
import quru.qa.pages.RegistrationPage;
import quru.qa.pages.data.DataFaker;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.String.format;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    DataFaker faker = new DataFaker();

    String firstName = faker.firstName(),
            lastName = faker.lastName(),
            email = faker.email(),
            gender = faker.gender(),
            number = faker.number(),
            day = "22",
            month = "June",
            year = "1993",
            subject = "Math",
            hobbie = "Sports",
            picture = "cat.jpg",
            currentAddress = faker.currentAddress(),
            state = "NCR",
            city = "Delhi",
            expectedFullName = format("%s %s", firstName, lastName),
            birthDate = format("%s %s%s", day, month, "," + year),
            stateAndCity = format("%s %s", state, city);


    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}