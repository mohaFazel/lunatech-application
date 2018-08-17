package org.lunatech.assessment.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lunatech.assessment.model.Country;
import org.lunatech.assessment.util.CountryBuilder;
import org.lunatech.assessment.util.CountryMockBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ICountryRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ICountryRepository countryRepo;

    @Test
    public void findByCode() {
        Country country = new CountryMockBuilder().setId("123").setCode("IRA").setName("Iran").build();
        entityManager.persist(country);
        entityManager.flush();
        Country found = countryRepo.findByCode("IRA");
        assertEquals(found.getName(), country.getName());
    }
}