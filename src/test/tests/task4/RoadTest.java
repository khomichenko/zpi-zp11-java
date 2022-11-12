package tests.task4;

import org.junit.Assert;
import org.junit.Test;
import tasks.task4.Road;
import tasks.task4.people.Human;
import tasks.task4.transport.Car;
import tasks.task4.transport.Vehicle;

public class RoadTest {

    @Test public void add(){
        Road road = new Road();
        {
            Vehicle car = new Car(10);
            car.getOnQuietly(
                    new Human("Петро"),
                    new Human("Василій"),
                    new Human("Якась бабка")
            );
            road.add(car);
        }
        Assert.assertTrue(true);
    }

    @Test public void getCountOfHumans() {
        Road road = new Road();
        {
            Vehicle car = new Car(10);
            car.getOnQuietly(
                    new Human("Петро"),
                    new Human("Василій"),
                    new Human("Якась бабка")
            );
            road.add(car);
        }
        {
            Vehicle car = new Car(10);
            car.getOnQuietly(
                    new Human("Маруся"),
                    new Human("Любов"),
                    new Human("Якийсь дід")
            );
            road.add(car);
        }
        Assert.assertEquals(6, (long) road.getCountOfHumans());
    }
}
