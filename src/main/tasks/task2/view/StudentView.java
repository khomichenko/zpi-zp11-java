package tasks.task2.view;

import tasks.task2.model.Student;

import java.util.Date;

public final class StudentView extends Student {
    public StudentView(String firstName, String lastName, Date birthdate, String phone, String address) {
        super(firstName,lastName,birthdate,phone,address);
    }
}
