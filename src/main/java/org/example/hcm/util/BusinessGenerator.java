package org.example.hcm.util;

import com.github.javafaker.Faker;
import org.example.hcm.Business;
import org.example.hcm.Person;

import java.util.Random;

public class BusinessGenerator {
    private final Faker faker = new Faker();
    private final PeopleGenerator peopleMaker = new PeopleGenerator();

    public Business generate() {
        Random random = new Random();

        Business business = new Business();
        business.setBusinessName(faker.company().name());
        int numOfEmployees = random.ints(5, 10).findFirst().getAsInt();

        for(int i = 0; i < numOfEmployees; i++){
            Person newEmployee = peopleMaker.generate();

            business.getListOfEmployees().add(newEmployee);
        }
        return business;
    }
}
