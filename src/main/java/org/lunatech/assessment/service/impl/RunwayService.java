package org.lunatech.assessment.service.impl;

import org.lunatech.assessment.model.Country;
import org.lunatech.assessment.model.Runway;
import org.lunatech.assessment.model.dto.RunwayIdentCountDto;
import org.lunatech.assessment.repository.IRunwayRepository;
import org.lunatech.assessment.service.ICountryService;
import org.lunatech.assessment.service.IRunwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by m.fazel on 8/14/2018.
 */
@Service
public class RunwayService implements IRunwayService {

    @Autowired
    IRunwayRepository runwayRepo;

    @Autowired
    ICountryService countrySrv;

    @Override
    public List<RunwayIdentCountDto> getRunwayIdentCounts() {
        return runwayRepo.getRunwayIdentCounts(PageRequest.of(0,10));
    }

    @Override
    public List<Runway> getRunwaysByAirportId(String airportId) {
        return runwayRepo.getRunwaysByAirportId(airportId);
    }

    @Override
    public Map<String, Set<String>> getRunwayTypesByCountry() {
        Map<String, Set<String>> countryRunwayTypes = new HashMap<>();
        List<Country> countries = countrySrv.getAll();
        countries.stream().forEach(country -> {
            Set<String> runwayTypes = runwayRepo.getRunwayTypesByCountry(country.getId());
            countryRunwayTypes.put(country.getName(), runwayTypes);
        });
        return countryRunwayTypes;
    }
}
