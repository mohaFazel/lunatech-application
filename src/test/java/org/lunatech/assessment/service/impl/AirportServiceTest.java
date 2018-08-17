package org.lunatech.assessment.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.Country;
import org.lunatech.assessment.model.dto.CountryCountDto;
import org.lunatech.assessment.repository.IAirportRepository;
import org.lunatech.assessment.service.IAirportService;
import org.lunatech.assessment.util.AirportMockBuilder;
import org.lunatech.assessment.util.CountryMockBuilder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AirportServiceTest {

    @MockBean
    private IAirportRepository airportRepo;

    @Before
    public void setupAirportsForCode(){
        Page<Airport> page = getMockAirports();
        when(airportRepo.findByCountryCode("IR", PageRequest.of(0,10)))
                .thenReturn(page);
    }

    @Before
    public void setupAirportsForName(){
        Page<Airport> page = getMockAirports();
        when(airportRepo.findByCountryName("iran", PageRequest.of(0,10)))
                .thenReturn(page);
    }

    @Before
    public void setupAirportsForCountry(){
        Page<Airport> page = getMockAirports();
        when(airportRepo.getAirportsByCountry("ira", PageRequest.of(0,10)))
                .thenReturn(page);
    }

    private Page<Airport> getMockAirports() {
        List<Airport> airports = new ArrayList<>();
        Country country = new CountryMockBuilder().setId("1").setCode("IR")
                .setName("Iran").build();
        airports.add(new AirportMockBuilder().setId("123").setCountry(country)
                .setName("airport1").build());
        airports.add(new AirportMockBuilder().setId("321").setCountry(country)
                .setName("airport2").build());
        return (Page<Airport>) new PageImpl(airports);
    }

    @Test
    public void getAirportsByCode() {
        Page<Airport> page = airportRepo.findByCountryCode("IR", PageRequest.of(0, 10));
        assertEquals(page.getContent().get(0).getId(), "123");
    }

    @Test
    public void getAirportsByName() {
        Page<Airport> page = airportRepo.findByCountryName("iran", PageRequest.of(0, 10));
        assertEquals(page.getContent().get(0).getId(), "123");
    }

    @Test
    public void getAirportsByCountry() {
        Page<Airport> page = airportRepo.getAirportsByCountry("ira", PageRequest.of(0, 10));
        assertEquals(page.getContent().get(0).getId(), "123");
    }
}