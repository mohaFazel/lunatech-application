package org.lunatech.assessment.controller;

import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.dto.ReportDto;
import org.lunatech.assessment.service.ILunatechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author moha.fazel
 * This class is used just to return those actions mentioned in the email
 * for assessment without taking UI concerns into consideration.
 * In fact, these actions is repeat in the other rest Controllers e.g.
 * CountryController, AirportController and RunwayController.
 * If one wanted to implements UI for this Web Application, it will recommended
 * to use other methods in those Conrollers instead of these methods.
 * */
@RestController
@RequestMapping("/api/lunatech")
public class LunatechController {

    @Autowired
    ILunatechService lunatechSrv;

    /**
     * Action 1: Query
     * This method is used to return list of airports and runways at each airport
     * for any country, of course you can use getAirportsByCdde() and
     * getAirportsByName() in AirportController instead.
     * @param country This is a string parameter which can be used to pass the
     *                country code or name to the method.
     * @return List of Airports include Ruways.
     * */
    @GetMapping("/query/{country}")
    public Page<Airport> getQuery(@PathVariable String country, Pageable pageable){
        return lunatechSrv.getAirportsByCountry(country, pageable);
    }

    /**
     * Action 2: Report
     * This method is used to return a report from the dataset include:
     * 1- 10 countries with highest number of airports (with count) and countries
     *    with lowest number of airports.
     * 2- Type of runways (as indicated in "surface" column) per country.
     * 3- Print the top 10 most common runway identifications (indicated in
     *    "le_ident" column).
     * Like previous method, one can use other methods which were implemented in
     * CountryController and RunwayController instead to get the result from different
     * rest services, in case he/she would rather to implements them in different page
     * ans tables
     * @return ReportDto This entity contains Lists of mentioned result
     * */
    @GetMapping("/report")
    public ReportDto getReport(){
        return lunatechSrv.getReport();
    }
}
