package tasks.task4.transport;

import tasks.task4.people.Human;

public class Bus extends Vehicle<Human> {
    public Bus(Integer capacity) {
        super(capacity);
    }
}
