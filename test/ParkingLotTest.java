import org.junit.Test;
import src.Car;
import src.ParkingLots;
import src.Ticket;
import src.exception.ParkingLotsIsFullException;
import src.exception.UnknownCarException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class ParkingLotTest {

    private ParkingLots parkingLots;

    @Test
    public void should_park_succeed_given_available_slots(){
        parkingLots = new ParkingLots(1);
        Ticket ticket = parkingLots.park(new Car());
        assertNotNull(ticket);
    }

    @Test(expected = ParkingLotsIsFullException.class)
    public void should_fail_given_no_available_slots(){
        parkingLots = new ParkingLots(1);
        parkingLots.park(new Car());
        parkingLots.park(new Car());
    }

    @Test
    public void should_get_correct_car_given_correct_ticket() {
       parkingLots = new ParkingLots(1);
        Car expectedCar = new Car();
        Ticket ticket = parkingLots.park(expectedCar);

       Car actualCar = parkingLots.unPark(ticket);

       assertSame(expectedCar, actualCar);
    }

    @Test(expected = UnknownCarException.class)
    public void should_fail_given_invalid_ticket() {
        parkingLots = new ParkingLots(1);

        Ticket fakeTicket = new Ticket();
        parkingLots.unPark(fakeTicket);
    }
}
