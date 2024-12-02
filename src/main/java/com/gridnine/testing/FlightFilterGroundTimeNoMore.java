package com.gridnine.testing;

import com.gridnine.testing.exeptions.IncorrectTimeException;
import com.gridnine.testing.exeptions.NegativeWaitException;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

class FlightFilterGroundTimeNoMore implements FlightFilterSetting {
    public List<Flight> filter(List<Flight> flights, int timeH) {
        if (timeH < 1) {
            throw new IncorrectTimeException("time must be greater than 0");
        }
        return flights.stream()
                .filter(flight -> {
                    Duration groundTime = Duration.ofDays(0);
                    List<Segment> segments = flight.getSegments();
                    for (int i = 1; i < segments.size(); i++) {
                        Duration difference = Duration.between(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate());
                        if (difference.isNegative()) {
                            throw new NegativeWaitException("flight is broken. caused by negative time");
                        }
                        groundTime = groundTime.plus(difference);
                        if (groundTime.toHours() > timeH) {
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}
