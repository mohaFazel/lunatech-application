package org.lunatech.assessment.controller;

import org.lunatech.assessment.model.dto.CountryCountDto;
import org.lunatech.assessment.model.projection.CountryCountProjection;
import org.lunatech.assessment.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author moha.fazel
 * This class was implemented for the first part of the second task Report
 * mentioned in the assessment.
 */
@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    ICountryService countrySrv;

    /**
     * Task 2: Report -> first part e.g. 10 countries with highest number of
     * airports (with count)
     * @return List of dto contains name of the country and the number of airports
     * it has
     * */
    @GetMapping("/report/countryWithHighestNumberOfAirports")
    public List<CountryCountDto> getCountryWithHighestNumberOfAirports(){
        return countrySrv.getCountryWithHighestNumberOfAirports();
    }

    /**
     * Task 2: Report -> first part e.g. 10 countries with lowest number of
     * airports (with count)
     * @return List of dto contains name of the country and the number of airports
     * it has
     * */
    @GetMapping("/report/countryWithLowestNumberOfAirports")
    public List<CountryCountProjection> getCountryWithLowestNumberOfAirports(){
        return countrySrv.getCountryWithLowestNumberOfAirports();
    }
}
