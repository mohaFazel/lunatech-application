package org.lunatech.assessment.service;

import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.dto.ReportDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILunatechService {

    Page<Airport> getAirportsByCountry(String country, Pageable pageable);

    ReportDto getReport();
}
