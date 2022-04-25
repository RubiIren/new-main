package quru.qa.pages.data;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

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

    public String gender() {

        return StringUtils.capitalize(faker.dog().gender());
    }

    public String number() {

        return faker.numerify("##########");
    }


    public String currentAddress() {

        return faker.address().fullAddress();
    }

}
