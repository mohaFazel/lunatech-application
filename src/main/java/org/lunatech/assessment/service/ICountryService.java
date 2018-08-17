package org.lunatech.assessment.service;

import org.lunatech.assessment.model.Country;
import org.lunatech.assessment.model.dto.CountryCountDto;
import org.lunatech.assessment.model.projection.CountryCountProjection;

import java.util.List;

/**
 * Created by m.fazel on 8/12/2018.
 */
public interface ICountryService {

    List<Country> getAll();

    List<CountryCountProjection> getCountryWithLowestNumberOfAirports();

    List<CountryCountDto> getCountryWithHighestNumberOfAirports();
}
