package quru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput =$("#lastName");

    public void typeFirstName(String value){
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value){
        lastNameInput.setValue(value);
    }

}
