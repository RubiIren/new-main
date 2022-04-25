package quru.qa.pages.data;

import com.github.javafaker.Faker;

public class DataFaker {
    Faker faker = new Faker();

    public String firstName() {
        return faker.name().firstName();
    }

    public String lastName() {

        return faker.name().lastName();
    }

    public String email() {

        return faker.internet().emailAddress();
    }

}
