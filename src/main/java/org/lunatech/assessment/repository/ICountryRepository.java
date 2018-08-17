package org.lunatech.assessment.repository;

import org.lunatech.assessment.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mohammad on 8/11/2018.
 */
@Repository
public interface ICountryRepository extends JpaRepository<Country, String> {

    Country findByCode(String code);
}
