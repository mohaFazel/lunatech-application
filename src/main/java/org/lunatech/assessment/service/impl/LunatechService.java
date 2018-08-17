package org.lunatech.assessment.service.impl;

import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.dto.ReportDto;
import org.lunatech.assessment.service.IAirportService;
import org.lunatech.assessment.service.ILunatechService;
import org.lunatech.assessment.service.IRunwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LunatechService implements ILunatechService {

    @Autowired
    IAirportService airportSrv;

    @Autowired
    IRunwayService runwaySrv;

    @Override
    public Page<Airport> getAirportsByCountry(String country, Pageable pageable) {
        return airportSrv.getAirportsByCountry(country, pageable);
    }

    @Override
    public ReportDto getReport() {
        ReportDto result = new ReportDto();
        result.getCountriesWithHighestNumberOfAirports().addAll(
                airportSrv.getCountriesWithHighestNumberOfAirports());
        result.getCountriesWithLowestNumberOfAirports().addAll(
                airportSrv.getCountriesWithLowestNumberOfAirports());
        result.setCountryRunwayTypes(runwaySrv.getRunwayTypesByCountry());
        result.getRunwayIdentCounts().addAll(runwaySrv.getRunwayIdentCounts());
        return result;
    }
}
