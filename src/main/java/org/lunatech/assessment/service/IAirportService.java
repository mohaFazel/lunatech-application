package org.lunatech.assessment.service;

import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.dto.CountryCountDto;
import org.lunatech.assessment.model.projection.CountryCountProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by mohammad on 8/11/2018.
 */
public interface IAirportService {

    Page<Airport> getAirportsByCode(String countryCode, Pageable pageable);

    Page<Airport> getAirportsByName(String countryName, Pageable pageable);

    Page<Airport> getAirportsByCountry(String country, Pageable pageable);

    List<CountryCountDto> getCountriesWithHighestNumberOfAirports();

    List<CountryCountProjection> getCountriesWithLowestNumberOfAirports();
}
