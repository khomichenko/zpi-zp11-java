package tests.task4.transport;

import org.junit.Test;
import tasks.task4.people.Human;
import tasks.task4.transport.Car;
import tasks.task4.transport.Vehicle;
import tasks.task4.transport.exceptions.NoFreeSeatException;
import tasks.task4.transport.exceptions.NoPassenger;

public class VehicleTest {

    @Test (expected = NoFreeSeatException.class)
    public void getOnNoFreeSeat() throws NoFreeSeatException {
        Vehicle car = new Car(2);
        car.getOn(new Human("Петро"));
        car.getOn(new Human("Василій"));
        car.getOn(new Human("Маруся"));
    }

    @Test (expected = NoPassenger.class)
    public void getOffNoPassenger() throws NoPassenger, NoFreeSeatException {
        Vehicle car = new Car(1);
        car.getOn(new Human("Петро"));
        car.getOff(new Human("Василій"));
    }

}
