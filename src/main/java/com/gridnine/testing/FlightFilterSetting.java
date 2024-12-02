package com.gridnine.testing;

import java.util.List;

interface FlightFilterSetting {
    List<Flight> filter(List<Flight> flights, int set);
}
