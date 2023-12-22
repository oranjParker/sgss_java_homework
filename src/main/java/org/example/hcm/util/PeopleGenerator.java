package org.example.hcm.util;

import com.github.javafaker.Faker;
import org.example.hcm.Person;

import java.util.Random;

public class PeopleGenerator {
    private final Faker faker = new Faker();
    private final Random random = new Random();
    public Person generate() {
        Person person = new Person();
        person.setFirstName(faker.name().firstName());
        person.setLastName(faker.name().lastName());
        person.setMiddleName(faker.bool().bool() ? faker.name().firstName() : "");
        person.setEmployeeId(faker.number().randomNumber());

        Title[] titles = Title.values();
        person.setTitle(titles[random.nextInt(titles.length)]);

        return person;
    }
}
