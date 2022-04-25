package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import quru.qa.pages.RegistrationPage;
import quru.qa.pages.data.DataFaker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class FormTests {

    RegistrationPage registrationPage = new RegistrationPage();
    DataFaker faker = new DataFaker();

    String firstName = faker.firstName(),
            lastName = faker.lastName(),
            email = faker.email(),
            expectedFullName = format("%s %s", firstName, lastName),
            gender = faker.gender(),
            number = faker.number(),
            currentAddress = faker.currentAddress();


    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }


    @Test
    void successfulSubmitFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setBirthDate("22", "June", "1993")
                .setSubjects("Math")
                .setHobbies("Sports")
                .setHobbies("Music")
                .setPicture("cat.jpg")
                .setCurrentAddress(currentAddress)
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", "22 June,1993")
                .checkResult("Hobbies", "Sports, Music")
                .checkResult("Picture", "cat.jpg")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", "NCR Delhi");
    }

}