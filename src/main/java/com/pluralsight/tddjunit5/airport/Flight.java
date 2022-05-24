package com.pluralsight.tddjunit5.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Flight {

    List<Passenger> passengerList = new ArrayList<Passenger>();
    private final String id;

    public Flight(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Passenger> getPassengersList() {
        return Collections.unmodifiableList(passengerList);
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

}
