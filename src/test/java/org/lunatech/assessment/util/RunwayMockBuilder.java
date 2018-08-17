package org.lunatech.assessment.util;

import org.apache.commons.csv.CSVRecord;
import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.Runway;

public class RunwayMockBuilder {

    private Runway runway = new Runway();

    public Runway build() {
        return this.runway;
    }

    public RunwayMockBuilder setId(String id) {
        runway.setId(id);
        return this;
    }

    public RunwayMockBuilder setAirport(Airport airport) {
        runway.setAirport(airport);
        return this;
    }

    public RunwayMockBuilder setLe_ident(String le_ident) {
        runway.setLe_ident(le_ident);
        return this;
    }

    public RunwayMockBuilder setSurface(String surface) {
        runway.setSurface(surface);
        return this;
    }
}
