package com.pluralsight.tddjunit5.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    @Test
    public void testAirport(){
        Flight economyFlight = new Flight("1", "Economy");
        Flight businessFlight = new Flight("1", "Business");

        Passenger vipSample = new Passenger("John", true);
        Passenger economySample = new Passenger("Mike", false);

        assertAll(
            () -> assertTrue(economyFlight.addPassenger(vipSample)),
            () -> assertFalse(economyFlight.removePassenger(vipSample)),
            () -> assertTrue(businessFlight.addPassenger(vipSample)),
            () -> assertFalse(businessFlight.removePassenger(vipSample)),

            () -> assertTrue(economyFlight.addPassenger(economySample)),
            () -> assertTrue(economyFlight.removePassenger(economySample)),
            () -> assertFalse(businessFlight.addPassenger(economySample)),
            () -> assertFalse(businessFlight.removePassenger(economySample))
        );

    }

}