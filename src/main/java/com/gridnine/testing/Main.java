package com.gridnine.testing;

import java.util.List;

/**
 * Verification code
 */
public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilterFuture futureFlightFilter = new FlightFilterFuture();
        FlightFilterBrokenSegment brokenSegmentFlightFilter = new FlightFilterBrokenSegment();
        FlightFilterGroundTimeNoMore groundLimitFlightFilter = new FlightFilterGroundTimeNoMore();

        System.out.println("All flights:");
        flights.forEach(System.out::println);

        System.out.println("Future flights:");
        futureFlightFilter.filter(flights).forEach(System.out::println);

        System.out.println("BrokenSegment flights filtered:");
        brokenSegmentFlightFilter.filter(flights).forEach(System.out::println);

        System.out.println("groundLimit flights:");
        groundLimitFlightFilter.filter(flights, 2).forEach(System.out::println);
    }
}
