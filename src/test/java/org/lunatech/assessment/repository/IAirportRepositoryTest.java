package org.lunatech.assessment.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.Country;
import org.lunatech.assessment.model.dto.CountryCountDto;
import org.lunatech.assessment.model.projection.CountryCountProjection;
import org.lunatech.assessment.util.AirportMockBuilder;
import org.lunatech.assessment.util.CountryMockBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IAirportRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IAirportRepository airportRepo;

    @Autowired
    ICountryRepository countryRepo;

    @Test
    public void findByCountryCode() {
        persistMockEntityForQuery();
        Pageable pageable = PageRequest.of(0,10);
        Page<Airport> found = airportRepo.findByCountryCode("IR", pageable);
        assertEquals(found.getContent().get(0).getName(), "Mehrabad");
    }

    @Test
    public void findByCountryName() {
        persistMockEntityForQuery();
        Pageable pageable = PageRequest.of(0,10);
        Page<Airport> found = airportRepo.findByCountryName("Iran", pageable);
        assertEquals(found.getContent().get(0).getName(), "Mehrabad");
    }

    @Test
    public void getAirportsByCountry() {
        persistMockEntityForQuery();
        Pageable pageable = PageRequest.of(0,10);
        Page<Airport> found = airportRepo.getAirportsByCountry("Ira", pageable);
        assertEquals(found.getContent().get(0).getName(), "Mehrabad");
    }

    private void persistMockEntityForQuery() {
        Country country = new CountryMockBuilder().setId("1").setCode("IR").setName("Iran").build();
        Airport airport1 = new AirportMockBuilder().setId("123").setContinent("AS")
                .setName("Mehrabad").setType("small").setCountry(country).build();
        Airport airport2 = new AirportMockBuilder().setId("234").setContinent("AS")
                .setName("IKA").setType("Huge").setCountry(country).build();
        entityManager.persist(country);
        entityManager.persist(airport1);
        entityManager.persist(airport2);
        entityManager.flush();
    }

    @Test
    public void getCountriesWithHighestNumberOfAirports() {
        persistMockEntityForReport();
        List<CountryCountDto> dtos = airportRepo
                .getCountriesWithHighestNumberOfAirports(PageRequest.of(0,10));
        assertEquals(dtos.get(0).getCount().longValue(), 19L);
    }

    @Test
    public void getCountriesWithLowestNumberOfAirports() {
        persistMockEntityForReport();
        List<CountryCountProjection> dtos = airportRepo
                .getCountriesWithLowestNumberOfAirports(PageRequest.of(0,10));
        assertEquals(dtos.get(0).getCount().longValue(), 0L);
    }

    private void persistMockEntityForReport() {
        for (Integer i = 0 ; i < 20 ; i++){
            Country country = new CountryMockBuilder().setId(i.toString()).setCode(i.toString()+"code")
                    .setName("country"+i.toString()).build();
            entityManager.persist(country);
            for (Integer j = 0 ; j < i ; j++){
                Airport airport = new AirportMockBuilder().setId(i.toString()+j.toString())
                        .setName("airport"+i.toString()+j.toString()).setType("small").setCountry(country).build();
                entityManager.persist(airport);
            }
        }
    }
}