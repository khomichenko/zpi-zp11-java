package tasks.task4.model.transport;

import tasks.task4.model.people.Human;

public class Car<Passenger extends Human> extends Vehicle<Passenger>{
    public Car(Integer capacity) {
        super(capacity);
    }
}
