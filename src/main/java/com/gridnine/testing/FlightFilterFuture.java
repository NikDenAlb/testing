package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

class FlightFilterFuture implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(f -> f.getSegments().stream()
                        .allMatch(s -> s.getDepartureDate().isAfter(now)))
                .collect(Collectors.toList());
    }
}
