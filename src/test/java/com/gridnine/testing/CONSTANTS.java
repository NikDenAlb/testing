package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class CONSTANTS {
    static final Flight F1 = new Flight(List.of(
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2))));
    static final Flight F1_F1 = new Flight(List.of(
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
            new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4))));
    static final Flight P1_F1 = new Flight(List.of(
            new Segment(LocalDateTime.now().minusHours(2), LocalDateTime.now().minusHours(1)),
            new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4))));
    static final Flight P1_P1 = new Flight(List.of(
            new Segment(LocalDateTime.now().minusHours(4), LocalDateTime.now().minusHours(3)),
            new Segment(LocalDateTime.now().minusHours(2), LocalDateTime.now().minusHours(1))));
    static final Flight P1_P1_F2 = new Flight(List.of(
            new Segment(LocalDateTime.now().minusHours(4), LocalDateTime.now().minusHours(3)),
            new Segment(LocalDateTime.now().minusHours(2), LocalDateTime.now().minusHours(1)),
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3))));
    static final Flight B1 = new Flight(List.of(
            new Segment(LocalDateTime.now().plusHours(10), LocalDateTime.now().plusHours(2))));
    static final Flight P1_B1_F2 = new Flight(List.of(
            new Segment(LocalDateTime.now().minusHours(4), LocalDateTime.now().minusHours(3)),
            new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now().minusHours(2)),
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3))));
    static final Flight P1_B1 = new Flight(List.of(
            new Segment(LocalDateTime.now().minusHours(2), LocalDateTime.now().minusHours(1)),
            new Segment(LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(4))));
    static final Flight F2 = new Flight(List.of(
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3))));
    static final Flight G0 = new Flight(List.of(
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
            new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3))));
    static final Flight G1 = new Flight(List.of(
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
            new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4))));
    static final Flight G2 = new Flight(List.of(
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
            new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5))));
    static final Flight G3 = new Flight(List.of(
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
            new Segment(LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(6))));
    static final Flight G4 = new Flight(List.of(
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
            new Segment(LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(7))));
    static final Flight B2 = new Flight(List.of(
            new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)),
            new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(7))));

    static final List<Flight> FLIGHTSF1 = Arrays.asList(F1, F1_F1, P1_F1);
    static final List<Flight> FLIGHTSF2 = Arrays.asList(F1, F1_F1);

    static final List<Flight> FLIGHTSF11 = List.of(P1_P1);
    static final List<Flight> FLIGHTSF22 = List.of();

    static final List<Flight> FLIGHTSF111 = List.of(F2, F1_F1, P1_F1, P1_P1_F2);
    static final List<Flight> FLIGHTSF222 = List.of(F2, F1_F1);

    static final List<Flight> FLIGHTSB1 = List.of(B1);

    static final List<Flight> FLIGHTSB11 = List.of(F1, F1_F1, F2, P1_B1_F2, P1_F1, P1_P1_F2);
    static final List<Flight> FLIGHTSB22 = List.of(F1, F1_F1, F2, P1_F1, P1_P1_F2);

    static final List<Flight> FLIGHTSB111 = List.of(P1_B1, P1_B1_F2, P1_B1_F2, P1_F1, B1);
    static final List<Flight> FLIGHTSB222 = List.of(P1_F1);

    static final List<Flight> FLIGHTSG1 = List.of(F1);

    static final List<Flight> FLIGHTSG00 = List.of(G0);
    static final List<Flight> FLIGHTSG11 = List.of(G1);
    static final List<Flight> FLIGHTSG22 = List.of(G2);
    static final List<Flight> FLIGHTSG33 = List.of(G3);
    static final List<Flight> FLIGHTSG44 = List.of(G4);

    static final List<Flight> FLIGHTSG111 = List.of(G0, G1, G2, G3);
    static final List<Flight> FLIGHTSG222 = List.of(G0, G1, G2);
    static final List<Flight> FLIGHTSG333 = List.of(G0, G1);

    static final List<Flight> FLIGHTSB2 = List.of(B2);
}
