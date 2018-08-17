package org.lunatech.assessment.controller;

import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.service.IAirportService;
import org.lunatech.assessment.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author moha.fazel
 * This class was implemented for the first task query mentioned in the assessment.
 */
@RestController
@RequestMapping("/api/airport")
public class AirportController {

    @Autowired
    IAirportService airportSrv;

    @Autowired
    ICountryService countrySrv;

    /**
     * Task 1: Query -> get all airport and runways of each country by code.
     * @param countryCode String parameter in case user pass country code to the method.
     * @return List of Airports include Ruways.
     * */
    @GetMapping("/query/byCode/{countryCode}")
    public Page<Airport> getAirportsByCode(@PathVariable String countryCode, Pageable pageable){
        return airportSrv.getAirportsByCode(countryCode, pageable);
    }

    /**
     * Task 1: Query -> get all airport and runways of each country by name.
     * @param countryName String parameter in case user pass country name to the method.
     * @return List of Airports include Ruways.
     * */
    @GetMapping("/query/byName/{countryName}")
    public Page<Airport> getAirportsByName(@PathVariable String countryName, Pageable pageable){
        return airportSrv.getAirportsByName(countryName, pageable);
    }
}
