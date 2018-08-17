package org.lunatech.assessment.service;

import org.lunatech.assessment.model.Runway;
import org.lunatech.assessment.model.dto.RunwayIdentCountDto;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by m.fazel on 8/14/2018.
 */
public interface IRunwayService {

    List<RunwayIdentCountDto> getRunwayIdentCounts();

    List<Runway> getRunwaysByAirportId(String airportId);

    Map<String,Set<String>> getRunwayTypesByCountry();
}
