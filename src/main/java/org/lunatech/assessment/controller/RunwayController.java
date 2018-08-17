package org.lunatech.assessment.controller;

import org.lunatech.assessment.model.Runway;
import org.lunatech.assessment.model.dto.CountryRunwayTypeDto;
import org.lunatech.assessment.model.dto.RunwayIdentCountDto;
import org.lunatech.assessment.service.IRunwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author moha.fazel
 * This class was implemented for the second and third part of the second
 * task Report mentioned in the assessment.
 * Also, there is another method related to the first task.
 */
@RestController
@RequestMapping("/api/runway")
public class RunwayController {

    @Autowired
    IRunwayService runwaySrv;

    /**
     * Task 1: Query -> get all runways of each airport by id.
     * Sometimes UI developers prefer to get smaller size of data in each call. In
     * such a case, they would rather to get the List of airport first and show them
     * in a table. then by click on each airport get runways related to that airport.
     * @param airportId String parameter to get airport id.
     * @return List of Ruways related to that airport.
     * */
    @GetMapping("/query/{airportId}")
    public List<Runway> getRunwaysByAirportId(@PathVariable String airportId){
        return runwaySrv.getRunwaysByAirportId(airportId);
    }

    /**
     * Task 2: Report -> second part e.g. Type of runways (as indicated in "surface"
     * column) per country.
     * @return Map of string as key to show country name and Set of string as a value
     * include surface types of that country.
     * */
    @GetMapping("/report/runwayTypesByCountry")
    public List<CountryRunwayTypeDto> getRunwayTypesByCountry(){
        return runwaySrv.getRunwayTypesByCountry();
    }

    /**
     * Task 2: Report -> third part e.g. Print the top 10 most common runway
     * identifications (indicated in "le_ident" column).
     * @return List of a dto contains name of indentification and the number
     * airports with this specification.
     * */
    @GetMapping("/report/runwayIdentCounts")
    public List<RunwayIdentCountDto> getRunwayIdentCounts(){
        return runwaySrv.getRunwayIdentCounts();
    }
}
