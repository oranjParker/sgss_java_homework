package org.example;

import org.example.hcm.Business;
import org.example.hcm.Person;
import org.example.hcm.util.BusinessGenerator;

import java.util.*;

public class Main {
    private static final BusinessGenerator businessMaker = new BusinessGenerator();

    public static void main(String[] args) {
        Map<String, Business> businesses = new HashMap<>();
        Map<String, String> personMap = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            Business business = businessMaker.generate();
            businesses.put(business.getBusinessName(), business);
        }

        businesses.forEach((businessName, business) -> {
            Iterator<Person> iterator = business.getListOfEmployees().listIterator();
            System.out.println(business.getBusinessName() + ": Employees {\nUsing While loop");
            while (iterator.hasNext()) {
                Person employee = iterator.next();
                System.out.println(employee.getFullName() + " { ID: " + employee.getEmployeeId() + ", Title: "
                        + employee.getTitle() + " }");
            }

            System.out.println("\nUsing For loop");
            for (int i = 0; i < business.getListOfEmployees().size(); i++) {
                System.out.println(business.getListOfEmployees().get(i).getFullName() + " { ID: "
                        + business.getListOfEmployees().get(i).getEmployeeId() + ", Title: "
                        + business.getListOfEmployees().get(i).getTitle() + " }");
            }

            System.out.println("\nUsing ForEach loop");
            for (Person employee : business.getListOfEmployees()) {
                personMap.put(employee.getFullName(), business.getBusinessName());
                System.out.println(employee.getFullName() + " { ID: " + employee.getEmployeeId() + ", Title: " + employee.getTitle() + " }");
            }

            System.out.println("\nUsing Java Streams loop");
            business.getListOfEmployees().stream().forEach(employee ->
                    System.out.println(employee.getFullName() + " { ID: " + employee.getEmployeeId() + ", Title: "
                            + employee.getTitle() + " }"));
            System.out.println("}\n");
        });

        Random random = new Random();
        List<String> names = new ArrayList<String>(personMap.keySet());
        String someName = names.get(random.nextInt(names.size()));
        String businessName = personMap.get(someName);

        Business business = findBusinessByName(businessName, businesses);
        System.out.println("Finding " + someName + " of " + businessName + ": ");
        Person employee = business.getEmployeeByName(someName);
        System.out.println(employee.getFullName() + " { ID: " + employee.getEmployeeId() + ", Title: " + employee.getTitle() + " }");

    }

    public static Business findBusinessByName(String name, Map<String, Business> businessMap) {
        return businessMap.get(name);
    }
}
