package tasks.task2.model;

import java.util.Date;
import java.util.Objects;

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
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Student==false) return false;
        Student student = (Student) o;
        if (!Objects.equals(firstName, student.firstName)) return false;
        if (!Objects.equals(lastName, student.lastName)) return false;
        return Objects.equals(birthdate, student.birthdate);
    }

    @Override
    public final int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "" + firstName + " " + lastName + " " + birthdate;
    }
}
