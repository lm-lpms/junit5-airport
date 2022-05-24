package com.pluralsight.tddjunit5.airport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Airport Class Test Suite")
class AirportTest {

    @Test
    public void testEconomyFlight_EconomyPassenger() {
        Flight economyFlight = new EconomyFlight("1");

        Passenger economySample = new Passenger("John", false);

        assertAll(
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertTrue(economyFlight.addPassenger(economySample)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("John", economyFlight.getPassengersList().get(0).getName()),
                () -> assertTrue(economyFlight.removePassenger(economySample)),
                () -> assertEquals(0, economyFlight.getPassengersList().size())
        );
    }

    @Test
    public void testEconomyFlight_BusinessPassenger() {
        Flight economyFlight = new EconomyFlight("1");

        Passenger vipSample = new Passenger("John", true);

        assertAll(
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertTrue(economyFlight.addPassenger(vipSample)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("John", economyFlight.getPassengersList().get(0).getName()),
                () -> assertFalse(economyFlight.removePassenger(vipSample)),
                () -> assertEquals(1, economyFlight.getPassengersList().size())
        );
    }

    @Test
    public void testBusinessFlight_EconomyPassenger() {
        Flight businessFlight = new BusinessFlight("2");

        Passenger economySample = new Passenger("John", false);

        assertAll(
                () -> assertEquals("2", businessFlight.getId()),
                () -> assertFalse(businessFlight.addPassenger(economySample)),
                () -> assertEquals(0, businessFlight.getPassengersList().size()),
                () -> assertFalse(businessFlight.removePassenger(economySample)),
                () -> assertEquals(0, businessFlight.getPassengersList().size())
        );
    }

    @Test
    public void testBusinessFlight_VIPPassenger() {
        Flight businessFlight = new BusinessFlight("2");

        Passenger vipSample = new Passenger("John", true);

        assertAll(
                () -> assertEquals("2", businessFlight.getId()),
                () -> assertTrue(businessFlight.addPassenger(vipSample)),
                () -> assertEquals(1, businessFlight.getPassengersList().size()),
                () -> assertEquals("John", businessFlight.getPassengersList().get(0).getName()),
                () -> assertFalse(businessFlight.removePassenger(vipSample)),
                () -> assertEquals(1, businessFlight.getPassengersList().size())
        );
    }
}