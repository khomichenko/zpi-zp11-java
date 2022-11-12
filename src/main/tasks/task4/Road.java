package tasks.task4;

import lombok.Getter;
import tasks.task4.people.Human;
import tasks.task4.transport.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private @Getter List<Vehicle<? extends Human>> vehicles = new ArrayList<>();
    public Integer getCountOfHumans() {
        return this.vehicles.stream().mapToInt(v -> v.getUsedSeatsCount()).sum();
    }
    public void add(Vehicle<? extends Human> vehicle) {
        this.vehicles.add(vehicle);
    }
}
