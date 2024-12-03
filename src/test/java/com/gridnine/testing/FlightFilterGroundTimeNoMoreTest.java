package com.gridnine.testing;

import com.gridnine.testing.exception.IncorrectTimeException;
import com.gridnine.testing.exception.NegativeWaitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.gridnine.testing.CONSTANTS.FLIGHTSB2;
import static com.gridnine.testing.CONSTANTS.FLIGHTSG00;
import static com.gridnine.testing.CONSTANTS.FLIGHTSG1;
import static com.gridnine.testing.CONSTANTS.FLIGHTSG11;
import static com.gridnine.testing.CONSTANTS.FLIGHTSG111;
import static com.gridnine.testing.CONSTANTS.FLIGHTSG22;
import static com.gridnine.testing.CONSTANTS.FLIGHTSG222;
import static com.gridnine.testing.CONSTANTS.FLIGHTSG33;
import static com.gridnine.testing.CONSTANTS.FLIGHTSG333;
import static com.gridnine.testing.CONSTANTS.FLIGHTSG44;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlightFilterGroundTimeNoMoreTest {

    private FlightFilterSetting filter;

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(FLIGHTSG1, FLIGHTSG1, 1),
                Arguments.of(FLIGHTSG1, FLIGHTSG1, 2),
                Arguments.of(FLIGHTSG1, FLIGHTSG1, 3),

                Arguments.of(FLIGHTSG11, FLIGHTSG11, 1),
                Arguments.of(FLIGHTSG11, FLIGHTSG11, 2),
                Arguments.of(FLIGHTSG11, FLIGHTSG11, 3),
                Arguments.of(FLIGHTSG22, List.of(), 1),
                Arguments.of(FLIGHTSG22, FLIGHTSG22, 2),
                Arguments.of(FLIGHTSG22, FLIGHTSG22, 3),

                Arguments.of(FLIGHTSG33, List.of(), 1),
                Arguments.of(FLIGHTSG33, List.of(), 2),
                Arguments.of(FLIGHTSG33, FLIGHTSG33, 3),

                Arguments.of(FLIGHTSG44, List.of(), 1),
                Arguments.of(FLIGHTSG44, List.of(), 2),
                Arguments.of(FLIGHTSG44, List.of(), 3),

                Arguments.of(FLIGHTSG00, FLIGHTSG00, 1),
                Arguments.of(FLIGHTSG00, FLIGHTSG00, 2),
                Arguments.of(FLIGHTSG00, FLIGHTSG00, 3),

                Arguments.of(FLIGHTSG111, FLIGHTSG111, 3),
                Arguments.of(FLIGHTSG111, FLIGHTSG222, 2),
                Arguments.of(FLIGHTSG111, FLIGHTSG333, 1)
        );
    }

    @BeforeEach
    public void setUp() {
        filter = new FlightFilterGroundTimeNoMore();
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void flightFilterGroundTimeNoMoreTest(List<Flight> inputFlights, List<Flight> outputFlights, int set) {
        List<Flight> result = filter.filter(inputFlights, set);
        assertEquals(outputFlights, result);
    }

    @Test
    public void flightTestEmpty() {
        List<Flight> flights = List.of();
        List<Flight> result = filter.filter(flights,2);
        assertEquals(0, result.size());
    }

    @Test
    public void flightTestBrokenGround() {
        assertThrows(NegativeWaitException.class, () -> filter.filter(FLIGHTSB2,2));
    }
    @Test
    public void flightTestBrokenSet() {
        assertThrows(IncorrectTimeException.class, () -> filter.filter(FLIGHTSG11,-1));
    }
}
