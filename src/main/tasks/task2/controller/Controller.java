package tasks.task2.controller;

import tasks.task2.model.Student;
import tasks.task2.view.StudentView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private List<Student> students = new ArrayList<>();

    public Student inputStudent() {
        Scanner in = new Scanner(System.in);
        String firstName  = nextString(in,"Введіть ім'я: ");
        String lastName   = nextString(in,"Введіть прізвище: ");
        Date   birthday   = nextDate  (in,"Введіть дату народження (dd.MM.yyyy): ");
        String phone      = nextString(in,"Введіть номер телефона: ");
        String address    = nextString(in,"Введіть адресу: ");
        Student student = new StudentView(
                firstName, lastName, birthday, phone, address
        );
        return student;
    }

    public boolean insert(Student student) {
        for (Student st : students) {
            if (st.equals(student)) {
                System.out.println("ERROR: Студента '"+student+"' уже додано до журналу");
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public void update(Student student) {
        students.add(student);
    }

    public List<Student> select() {
        return students;
    }

    private String nextString(Scanner in, String question) {
        System.out.print(question);
        return in.nextLine();
    }

    private Date nextDate(Scanner in, String question){
        System.out.print(question);
        try {
            return strToDate(in.nextLine());
        } catch (ParseException e) {
            // System.err.println("\nНе правильна дата");
            return nextDate(in,question);
        }
    }

    private Date strToDate(String str) throws ParseException {
        return new SimpleDateFormat("dd.MM.yyyy").parse(str);
    }
}
