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
import static com.gridnine.testing.CONSTANTS.FLIGHTSB1;
import static com.gridnine.testing.CONSTANTS.FLIGHTSB11;
import static com.gridnine.testing.CONSTANTS.FLIGHTSB111;
import static com.gridnine.testing.CONSTANTS.FLIGHTSB22;
import static com.gridnine.testing.CONSTANTS.FLIGHTSB222;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightFilterBrokenSegmentTest {

    private FlightFilter filter;

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(FLIGHTSB1, List.of()),
                Arguments.of(FLIGHTSB11, FLIGHTSB22),
                Arguments.of(FLIGHTSB111, FLIGHTSB222),
                Arguments.of(FLIGHTSF1, FLIGHTSF1),
                Arguments.of(FLIGHTSF11, FLIGHTSF11)
        );
    }

    @BeforeEach
    public void setUp() {
        filter = new FlightFilterBrokenSegment();
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void flightFilterBrokenSegmentTest(List<Flight> inputFlights, List<Flight> outputFlights) {
        List<Flight> result = filter.filter(inputFlights);
        assertEquals(outputFlights, result);
    }

    @Test
    public void flightTestEmpty() {
        List<Flight> flights = List.of();
        List<Flight> result = filter.filter(flights);
        assertEquals(0, result.size());
    }
}
