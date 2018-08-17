package org.lunatech.assessment.service.impl;

import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.dto.CountryCountDto;
import org.lunatech.assessment.model.projection.CountryCountProjection;
import org.lunatech.assessment.repository.IAirportRepository;
import org.lunatech.assessment.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by mohammad on 8/11/2018.
 */
@Service
public class AirportService implements IAirportService {

    @Autowired
    IAirportRepository airportRepo;

    @Override
    public Page<Airport> getAirportsByCode(String countryCode, Pageable pageable) {
        return airportRepo.findByCountryCode(countryCode, pageable);
    }

    @Override
    public Page<Airport> getAirportsByName(String countryName, Pageable pageable) {
        return airportRepo.findByCountryName(countryName, pageable);
    }

    @Override
    public Page<Airport> getAirportsByCountry(String country, Pageable pageable) {
        return airportRepo.getAirportsByCountry(country, pageable);
    }

    @Override
    public List<CountryCountDto> getCountriesWithHighestNumberOfAirports() {
        return airportRepo.getCountriesWithHighestNumberOfAirports(PageRequest.of(0, 10));
    }

    @Override
    public List<CountryCountProjection> getCountriesWithLowestNumberOfAirports() {
        return airportRepo.getCountriesWithLowestNumberOfAirports(PageRequest.of(0, 10));
    }

}
