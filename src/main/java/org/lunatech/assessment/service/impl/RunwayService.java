package org.lunatech.assessment.service.impl;

import org.lunatech.assessment.model.Country;
import org.lunatech.assessment.model.Runway;
import org.lunatech.assessment.model.dto.CountryRunwayTypeDto;
import org.lunatech.assessment.model.dto.RunwayIdentCountDto;
import org.lunatech.assessment.repository.IRunwayRepository;
import org.lunatech.assessment.service.ICountryService;
import org.lunatech.assessment.service.IRunwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<CountryRunwayTypeDto> getRunwayTypesByCountry() {
        List<CountryRunwayTypeDto> countryRunwayTypes = new ArrayList<>();
        List<Country> countries = countrySrv.getAll();
        countries.stream().forEach(country -> {
            List<String> runwayTypes = runwayRepo.getRunwayTypesByCountry(country.getId());
            countryRunwayTypes.add(new CountryRunwayTypeDto(country.getCode(), runwayTypes));
        });
        return countryRunwayTypes;
    }
}
