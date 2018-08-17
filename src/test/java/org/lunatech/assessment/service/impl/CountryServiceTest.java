package org.lunatech.assessment.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lunatech.assessment.model.Country;
import org.lunatech.assessment.model.dto.CountryCountDto;
import org.lunatech.assessment.model.projection.CountryCountProjection;
import org.lunatech.assessment.repository.IAirportRepository;
import org.lunatech.assessment.repository.ICountryRepository;
import org.lunatech.assessment.service.IAirportService;
import org.lunatech.assessment.service.ICountryService;
import org.lunatech.assessment.util.CountryMockBuilder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CountryServiceTest {

    @TestConfiguration
    static class CountryServiceTestContextConfiguration{
        @Bean
        public ICountryService countryService(){
            return new CountryService();
        }

        @Bean
        public IAirportService airportService(){
            return new AirportService();
        }
    }

    @Autowired
    private IAirportService airportSrv;

    @MockBean
    private ICountryRepository countryRepo;

    @MockBean
    private IAirportRepository airportRepo;

    @Before
    public void setupCountries(){
        List<Country> countries = new ArrayList<>();
        countries.add(new CountryMockBuilder().setId("123").setCode("IR").setName("Iran").build());
        countries.add(new CountryMockBuilder().setId("321").setCode("US").setName("UnitedStates").build());
        when(countryRepo.findAll()).thenReturn(countries);
    }

    @Before
    public void setupHighest(){
        List<CountryCountDto> highest = new ArrayList<>();
        highest.add(new CountryCountDto("United States", 1257L));
        highest.add(new CountryCountDto("Brazil", 1009L));
        highest.add(new CountryCountDto("Canada", 987L));
        highest.add(new CountryCountDto("France", 867L));
        when(airportSrv.getCountriesWithHighestNumberOfAirports()).thenReturn(highest);
    }

    @Before
    public void setupLowest(){
        List<CountryCountProjection> lowest = new ArrayList<>();
        lowest.add(new CountryCountProjection() {
            @Override
            public String getCountry() {
                return "Macau";
            }

            @Override
            public Long getCount() {
                return 1L;
            }
        });
        /*lowest.add(new CountryCountDto("The Vatican", 1L));
        lowest.add(new CountryCountDto("Lichtenschtein", 2L));
        lowest.add(new CountryCountDto("Maldive", 2L));*/
        when(airportSrv.getCountriesWithLowestNumberOfAirports()).thenReturn(lowest);
    }

    @Test
    public void getAll() {
        List<Country> countries = countryRepo.findAll();
        assertEquals(countries.get(0).getCode(), "IR");
        assertEquals(countries.get(1).getCode(), "US");
    }

    @Test
    public void getCountryWithLowestNumberOfAirports() {
        List<CountryCountProjection> lowest = airportSrv.getCountriesWithLowestNumberOfAirports();
        assertEquals(lowest.get(0).getCount().longValue(), 1L);
    }

    @Test
    public void getCountryWithHighestNumberOfAirports() {
        List<CountryCountDto> highest = airportSrv.getCountriesWithHighestNumberOfAirports();
        assertEquals(highest.get(0).getCount().longValue(), 1257L);
    }
}