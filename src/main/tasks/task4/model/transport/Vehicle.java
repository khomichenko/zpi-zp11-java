package tasks.task4.model.transport;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import tasks.task4.model.people.Human;
import tasks.task4.model.transport.exceptions.NoFreeSeatException;
import tasks.task4.model.transport.exceptions.NoPassenger;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Vehicle<Passenger extends Human> {
    private @Getter List<Passenger> passengers = new ArrayList<>();
    private @Getter @NotNull Integer capacity;
    public Integer getUsedSeatsCount() {
        return this.passengers.size();
    }
    public void getOn(Passenger passenger) throws NoFreeSeatException {
        if (this.getUsedSeatsCount()==this.getCapacity()) {
            throw new NoFreeSeatException();
        }
        this.passengers.add(passenger);
    }

    public @SneakyThrows void getOnQuietly(Passenger... passengers) {
        for ( Passenger passenger: passengers) {
            if (this.getUsedSeatsCount()<this.getCapacity()) {
                this.getOn(passenger);
            }
        }
    }
    public void getOff(Passenger passenger) throws NoPassenger {
        if (this.passengers.remove(passenger)==false) {
            throw new NoPassenger();
        }
    }
}
