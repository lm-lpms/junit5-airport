package com.pluralsight.tddjunit5.airport;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Airport Class Test Suite")
class AirportTest {

    @Nested
    @DisplayName("Given an economy flight")
    class EconomyFlightTest {
        private Flight economyFlight;
        private Passenger economySample;
        private Passenger vipSample;

        @BeforeEach
        void setup() {
            economyFlight = new EconomyFlight("1");
            economySample = new Passenger("John", false);
            vipSample = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When an economy passenger books")
        class EconomyPassenger {

            @Test
            @DisplayName("Then economy passenger can be added and removed from an economy flight")
            public void testEconomyFlight_EconomyPassenger() {
                assertAll(
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertTrue(economyFlight.addPassenger(economySample)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertTrue(economyFlight.getPassengersList().contains(economySample)),
                        () -> assertTrue(economyFlight.removePassenger(economySample)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size())
                );
            }

            @RepeatedTest(5)
            @DisplayName("Then economy passenger can be added and removed from an economy flight")
            public void testEconomyFlight_EconomyPassengerCanOnlyBeAddedOnce(RepetitionInfo repetitionInfo) {

                for (int i=0; i < repetitionInfo.getCurrentRepetition(); i++){
                    economyFlight.addPassenger(economySample);
                }

                assertAll( "Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertTrue(economyFlight.getPassengersList().contains(economySample)),
                        () -> assertTrue(economyFlight.getPassengersList().contains(economySample))
                );
            }
        }

        @Nested
        @DisplayName("When a business passenger books")
        class BusinessPassenger {

            @Test
            @DisplayName("Then business passenger can be added but not removed from an economy flight")
            public void testEconomyFlight_BusinessPassenger() {
                assertAll(
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertTrue(economyFlight.addPassenger(vipSample)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertTrue(economyFlight.getPassengersList().contains(vipSample)),
                        () -> assertFalse(economyFlight.removePassenger(vipSample)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size())
                );
            }
        }
    }

    @Nested
    @DisplayName("Given a business Flight")
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger economySample;
        private Passenger vipSample;

        @BeforeEach
        void setup() {
            businessFlight = new BusinessFlight("2");
            economySample = new Passenger("John", false);
            vipSample = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When an economy passenger books a flight")
        class EconomyPassenger {

            @Test
            @DisplayName("Then an economy passenger cannot be added or removed from the business flight")
            public void testBusinessFlight_EconomyPassenger() {
                assertAll(
                        () -> assertEquals("2", businessFlight.getId()),
                        () -> assertFalse(businessFlight.addPassenger(economySample)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertFalse(businessFlight.removePassenger(economySample)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("When a business passenger books a flight")
        class BusinessPassenger{

            @Test
            @DisplayName("Then the business passenger can be added but not removed from the business flight")
            public void testBusinessFlight_BusinessPassenger() {
                assertAll(
                        () -> assertEquals("2", businessFlight.getId()),
                        () -> assertTrue(businessFlight.addPassenger(vipSample)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertTrue(businessFlight.getPassengersList().contains(vipSample)),
                        () -> assertFalse(businessFlight.removePassenger(vipSample)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size())
                );
            }
        }
    }

    @Nested
    @DisplayName("Given a premium Flight")
    class PremiumFlightTest {
        private Flight premiumFlight;
        private Passenger economySample;
        private Passenger vipSample;

        @BeforeEach
        void setup() {
            premiumFlight = new PremiumFlight("2");
            economySample = new Passenger("John", false);
            vipSample = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When an economy passenger books a flight")
        class EconomyPassenger {

            @Test
            @DisplayName("Then an economy passenger cannot be added or removed from the premium flight")
            public void testBusinessFlight_EconomyPassenger() {
                assertAll(
                        () -> assertEquals("2", premiumFlight.getId()),
                        () -> assertFalse(premiumFlight.addPassenger(economySample)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size()),
                        () -> assertFalse(premiumFlight.removePassenger(economySample)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("When a business passenger books a flight")
        class BusinessPassenger{

            @Test
            @DisplayName("Then the business passenger can be added and removed from the business flight")
            public void testBusinessFlight_BusinessPassenger() {
                assertAll(
                        () -> assertEquals("2", premiumFlight.getId()),
                        () -> assertTrue(premiumFlight.addPassenger(vipSample)),
                        () -> assertEquals(1, premiumFlight.getPassengersList().size()),
                        () -> assertTrue(premiumFlight.getPassengersList().contains(vipSample)),
                        () -> assertTrue(premiumFlight.removePassenger(vipSample)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }
    }



}