package tasks.task4.model.transport;

import tasks.task4.model.people.Human;

public class Bus extends Vehicle<Human> {
    public Bus(Integer capacity) {
        super(capacity);
    }
}
