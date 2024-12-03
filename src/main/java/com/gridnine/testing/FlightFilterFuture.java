package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter flights from past events.
 */
class FlightFilterFuture implements FlightFilter {

    /**
     * Filter flights from past and already departed segments
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(f -> f.getSegments().stream()
                        .allMatch(s -> s.getDepartureDate().isAfter(now)))
                .collect(Collectors.toList());
    }
}
