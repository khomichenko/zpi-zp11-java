package tasks.task2.model;

import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String phone;
    private String address;

    public Student(){};
    public Student(String firstName, String lastName, Date birthdate, String phone, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public boolean equals(Object another) {
        if (another instanceof Student == false) {
            return false;
        }
        return firstName.equals(((Student) another).firstName) &&
               lastName.equals(((Student) another).lastName)   &&
               birthdate.equals(((Student) another).birthdate);
    }

    @Override
    public String toString() {
        return "" + firstName + " " + lastName + " " + birthdate;
    }
}
