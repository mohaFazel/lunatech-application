package org.lunatech.assessment.service;

import org.lunatech.assessment.model.Runway;
import org.lunatech.assessment.model.dto.CountryRunwayTypeDto;
import org.lunatech.assessment.model.dto.RunwayIdentCountDto;

import java.util.List;

/**
 * Created by m.fazel on 8/14/2018.
 */
public interface IRunwayService {

    List<RunwayIdentCountDto> getRunwayIdentCounts();

    List<Runway> getRunwaysByAirportId(String airportId);

    List<CountryRunwayTypeDto> getRunwayTypesByCountry();
}
