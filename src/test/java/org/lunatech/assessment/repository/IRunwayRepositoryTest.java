package org.lunatech.assessment.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.Country;
import org.lunatech.assessment.model.Runway;
import org.lunatech.assessment.model.dto.RunwayIdentCountDto;
import org.lunatech.assessment.util.AirportMockBuilder;
import org.lunatech.assessment.util.CountryMockBuilder;
import org.lunatech.assessment.util.RunwayBuilder;
import org.lunatech.assessment.util.RunwayMockBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IRunwayRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IRunwayRepository runwayRepo;

    @Autowired
    IAirportRepository airportRepo;

    @Autowired
    ICountryRepository countryRepo;

    @Test
    public void getRunwayTypesByCountry() {
        persistMockEntityForReport();
        List<String> runwayTypes = runwayRepo.getRunwayTypesByCountry("13");
        assertTrue(runwayTypes.contains("surface0"));
    }

    @Test
    public void getRunwayIdentCounts() {
        persistMockEntityForReport();
        List<RunwayIdentCountDto> dtos = runwayRepo.getRunwayIdentCounts(PageRequest.of(0, 10));
        assertEquals(dtos.get(0).getCount().longValue(), 171L);
    }

    @Test
    public void getRunwaysByAirportId() {
        persistMockEntityForReport();
        List<Runway> runways = runwayRepo.getRunwaysByAirportId("42");
        assertEquals(runways.get(0).getAirport().getName(), "airport4initial2");
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
                for (Integer z = 0 ; z < j ; z++){
                    Runway runway = new RunwayMockBuilder().setId("runway"+i.toString()+j.toString()+z.toString())
                            .setAirport(airport).setSurface("surface"+z.toString()).setLe_ident("ident"+z.toString())
                            .build();
                    entityManager.persist(runway);
                }
            }
        }
    }
}