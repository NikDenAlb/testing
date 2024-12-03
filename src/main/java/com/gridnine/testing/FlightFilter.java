package com.gridnine.testing;

import java.util.List;

/**
 * Main flight filter interface
 */
interface FlightFilter {
    List<Flight> filter(List<Flight> flights);
}
