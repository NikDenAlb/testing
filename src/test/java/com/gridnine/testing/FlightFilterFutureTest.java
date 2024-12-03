package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.gridnine.testing.CONSTANTS.FLIGHTSF1;
import static com.gridnine.testing.CONSTANTS.FLIGHTSF11;
import static com.gridnine.testing.CONSTANTS.FLIGHTSF111;
import static com.gridnine.testing.CONSTANTS.FLIGHTSF2;
import static com.gridnine.testing.CONSTANTS.FLIGHTSF22;
import static com.gridnine.testing.CONSTANTS.FLIGHTSF222;
import static com.gridnine.testing.CONSTANTS.FLIGHTSB1;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightFilterFutureTest {

    private FlightFilter filter;

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(FLIGHTSF1, FLIGHTSF2),
                Arguments.of(FLIGHTSF11, FLIGHTSF22),
                Arguments.of(FLIGHTSF111, FLIGHTSF222)
        );
    }

    @BeforeEach
    public void setUp() {
        filter = new FlightFilterFuture();
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void flightFilterFutureTest(List<Flight> inputFlights, List<Flight> outputFlights) {
        List<Flight> result = filter.filter(inputFlights);
        assertEquals(result, outputFlights);
    }

    @Test
    public void flightTestEmpty() {
        List<Flight> flights = List.of();
        List<Flight> result = filter.filter(flights);
        assertEquals(0, result.size());
    }

    @Test
    public void flightTestBrokenElement() {
        List<Flight> result = filter.filter(FLIGHTSB1);
        assertEquals(FLIGHTSB1 , result);
    }
}
