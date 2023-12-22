package org.example.hcm;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
public class Business {

    private String businessName;

    private List<Person> listOfEmployees = new ArrayList<>();

    public Person getEmployeeByName(String name) {
        return listOfEmployees.stream()
                .filter(employee -> employee.getFullName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
