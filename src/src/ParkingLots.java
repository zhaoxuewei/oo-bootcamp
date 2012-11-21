package src;

import src.exception.ParkingLotsIsFullException;
import src.exception.UnknownCarException;

import java.util.HashMap;

public class ParkingLots {
    private int capacity;
    private HashMap<Ticket, Car> cars = new HashMap<Ticket, Car>();

    public ParkingLots(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car){
        if(getAvailableSlots() == 0){
            throw new ParkingLotsIsFullException();
        }
        Ticket ticket = new Ticket();
        cars.put(ticket, car);
        return ticket;
    }

    private int getAvailableSlots() {
        return capacity - cars.size();
    }

    public Car unPark(Ticket ticket) {
        if(!cars.containsKey(ticket)){
            throw new UnknownCarException();
        }
        return cars.remove(ticket);
    }
}
