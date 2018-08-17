package org.lunatech.assessment.service.impl;

import org.lunatech.assessment.model.Country;
import org.lunatech.assessment.model.dto.CountryCountDto;
import org.lunatech.assessment.model.projection.CountryCountProjection;
import org.lunatech.assessment.repository.ICountryRepository;
import org.lunatech.assessment.service.IAirportService;
import org.lunatech.assessment.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by m.fazel on 8/12/2018.
 */
@Service
public class CountryService implements ICountryService {

    @Autowired
    ICountryRepository countryRepo;

    @Autowired
    IAirportService airportSrv;

    @Override
    public List<Country> getAll() {
        return countryRepo.findAll();
    }

    @Override
    public List<CountryCountProjection> getCountryWithLowestNumberOfAirports() {
        return airportSrv.getCountriesWithLowestNumberOfAirports();
    }

    @Override
    public List<CountryCountDto> getCountryWithHighestNumberOfAirports() {
        return airportSrv.getCountriesWithHighestNumberOfAirports();
    }
}
