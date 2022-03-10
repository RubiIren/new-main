package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTests {
    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void successfulSubmitFormTest() {

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Ira");
        $("#lastName").setValue("Rubi");
        $("#userEmail").setValue("podic58232@itwbuy.com");
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue("8123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--022").click();
        $("#hobbies-checkbox-1").scrollTo().parent().click();
        $("#hobbies-checkbox-3").scrollTo().parent().click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("[id=state]").click();
        $("[id=react-select-3-option-0]").click();
        $("[id=city]").click();
        $("[id=react-select-4-option-0]").click();
        $("#submit").scrollTo().click();

        $(".table-responsive").shouldHave(text("Ira Rubi"),
                text("podic58232@itwbuy.com"), text("Female"),
                text("8123456789"), text("22 June,1993"), text("Sports, Music"), text("cat.jpg"), text("NCR Delhi"));

    }
}

