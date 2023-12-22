package org.example.hcm;

import lombok.Getter;
import lombok.Setter;
import org.example.hcm.util.Title;

@Getter @Setter
public class Person {
    private String firstName;

    private String lastName;

    private String middleName;

    private long employeeId;

    private Title title;

    public String getFullName() {
        String fullName = (this.middleName.isBlank() || this.middleName == null) ? this.firstName + " " + this.lastName :
                this.firstName + " " + this.middleName + " " + this.lastName;

        return fullName;
    }

}