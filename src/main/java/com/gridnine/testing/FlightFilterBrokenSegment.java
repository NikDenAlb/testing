package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter flights from broken segments.
 */
class FlightFilterBrokenSegment implements FlightFilter {

    /**
     * Filter flights from broken segments where departureDate if after arrivalDate.
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(s -> s.getArrivalDate().isAfter(s.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
