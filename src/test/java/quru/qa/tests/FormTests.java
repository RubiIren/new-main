package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import quru.qa.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void successfulSubmitFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('fixedban').remove()");

      //  executeJavaScript("document.querySelector('footer').hidden = 'true'");//скрывает футер
      //  executeJavaScript("document.querySelector('#fixedban').hidden = 'true'");//скрывает рекламу

        registrationPage.typeFirstName("Ira");
        registrationPage.typeLastName("Rubi");
        $("#userEmail").setValue("podic58232@itwbuy.com");
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue("8123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--022").click();
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("[id=state]").scrollIntoView(true).click();
        $("[id=react-select-3-option-0]").click();
        $("[id=city]").click();
        $("[id=react-select-4-option-0]").click();
        $("#submit").click();
        $(".table-responsive").shouldHave(text("Student Name Ira Rubi"),
                text("Student Email podic58232@itwbuy.com"), text("Gender Female"),
                text("Mobile 8123456789"), text("Date of Birth 22 June,1993"),
                text("Hobbies Sports, Music"), text("Picture cat.jpg"), text("State and City NCR Delhi"));

    }
}