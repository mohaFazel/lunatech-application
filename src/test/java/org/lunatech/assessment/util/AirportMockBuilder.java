package org.lunatech.assessment.util;

import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.Country;

public class AirportMockBuilder {

    private Airport airport = new Airport();

    public Airport build() {
        return this.airport;
    }

    public AirportMockBuilder setContinent(String continent) {
        airport.setContinent(continent);
        return this;
    }

    public AirportMockBuilder setCountry(Country country) {
        airport.setCountry(country);
        return this;
    }

    public AirportMockBuilder setId(String id) {
        airport.setId(id);
        return this;
    }

    public AirportMockBuilder setName(String name) {
        airport.setName(name);
        return this;
    }

    public AirportMockBuilder setType(String type) {
        airport.setType(type);
        return this;
    }

}
