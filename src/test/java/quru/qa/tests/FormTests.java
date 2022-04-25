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
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbie)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmit();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", birthDate)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", stateAndCity);

    }

}