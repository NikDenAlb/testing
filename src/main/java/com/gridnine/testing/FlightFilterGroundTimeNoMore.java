package com.gridnine.testing;

import com.gridnine.testing.exception.IncorrectTimeException;
import com.gridnine.testing.exception.NegativeWaitException;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filters flights by ground time.
 */
class FlightFilterGroundTimeNoMore implements FlightFilterSetting {

    /**
     * Filters flights by ground time less than or equal to input hours.
     *
     * @param hours the maximum ground time in hours
     * @throws NegativeWaitException if the calculated ground time is negative
     */
    public List<Flight> filter(List<Flight> flights, int hours) {
        if (hours < 1) {
            throw new IncorrectTimeException("time must be greater than 0");
        }
        return flights.stream()
                .filter(flight -> {
                    Duration groundTime = Duration.ofDays(0);
                    List<Segment> segments = flight.getSegments();
                    Duration difference;
                    for (int i = 1; i < segments.size(); i++) {
                        difference = Duration.between(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate());
                        if (difference.isNegative()) {
                            throw new NegativeWaitException("flight is broken. caused by negative time");
                        }
                        groundTime = groundTime.plus(difference);
                        if (groundTime.toHours() > hours) {
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}
