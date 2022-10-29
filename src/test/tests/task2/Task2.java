package tests.task2;

import com.google.gson.Gson;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Assert;
import org.junit.Test;
import tasks.task2.controller.Controller;
import tasks.task2.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Завдання 2.2
 * Крок 1. Реалізувати метод equals для класу Student у якого є декілька полів.
 * Крок 2. Реалізуйте наступний сценарій:
 * a. Створіть екземпляр Student
 * b. Конвертуйте його в JSON*
 * c. Конвертуйте назад в об’єкт*
 * d. Перевірте equals-ом початковий і одержаний об'єкти
 * * Для серіалізації і десеріалізації в/з JSON можна використовувати бібліотеку gson
 * (https://sites.google.com/site/gson/gson-user-guide).
 *
 * Бажано!
 * Реалізуйте unit tests для методу equals за допомогою бібліотеки equals verifier
 */
public class Task2 {
    @Test public void test() throws ParseException {
        Student student = new Student("Ruslan","PetrenKo",new SimpleDateFormat("DD.MM.YYYY").parse("01.01.2001"),"380970000000","Kiev");
        String json = new Gson().toJson(student);
        Student student2 = new Gson().fromJson(json, Student.class);
        Assert.assertEquals(student,student2);
        EqualsVerifier.forClass(Student.class).verify();
    }
}
