package com.gridnine.testing;

import java.util.List;

/**
 * Flight filter with settings interface.
 */
interface FlightFilterSetting {
    List<Flight> filter(List<Flight> flights, int set);
}
