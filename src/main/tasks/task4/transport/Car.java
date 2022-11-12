package tasks.task4.transport;

import tasks.task4.people.Human;

public class Car<Passenger extends Human> extends Vehicle<Passenger>{
    public Car(Integer capacity) {
        super(capacity);
    }
}
