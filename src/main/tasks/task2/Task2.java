package tasks.task2;

import tasks.task2.controller.Controller;
import tasks.task2.model.Student;

/**
 * Завдання 2.1
 * Напишіть консольну програму, яка дозволяє створювати сутність "Запис в
 * журналі куратора".
 * Для цього потрібно:
 *  організувати введення даних з командної строки і передати результат
 * введення у відповідну сутність;
 *  перевіряти на правильність введення даних (зберігаючи правильно
 * введені) і в разі повної коректності всіх даних – передати їх до
 * відповідного класу в моделі; якщо дані не відповідають необхідному
 * формату, то запропонувати повторне введення.
 *  відображати всі записи журналу.
 * Сутність "Запис в журналі куратора" описана наступним набором:
 *  прізвище студента;
 *  ім'я студента;
 *  дата народження студента;
 *  телефон студента;
 *  домашня адреса (вулиця, будинок, квартира).
 */
public class Task2 {

    public static void main(String[] args) {

        Controller controller = new Controller();

        System.out.println("\nВводимо дані першого студента ...");
        {
            Student student = controller.inputStudent();
            Boolean studentInserted = controller.insert(student);
            if (studentInserted) {
                System.out.println("Студента "+student+" добавлено до журналу.");
            }
            System.out.println("Добавляємо студента "+student+" до журналу повторно ...");
            controller.insert(student);
        }
        System.out.println("Вводимо дані другого студента ...");
        {
            Student student = controller.inputStudent();
            Boolean studentInserted = controller.insert(student);
            if (studentInserted) {
                System.out.println("Студента "+student+" добавлено до журналу.");
            }
            controller.insert(student);
        }
        System.out.println("Список всіх студентів: ");
        for (Student student: controller.select()) {
            System.out.println("Cтудент: "+student);
        }
    }
}
