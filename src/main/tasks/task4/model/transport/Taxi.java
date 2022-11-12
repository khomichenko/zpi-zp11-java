package tasks.task4.model.transport;

import tasks.task4.model.people.Human;

public class Taxi extends Car<Human>{
    public Taxi(Integer capacity) {
        super(capacity);
    }
}
