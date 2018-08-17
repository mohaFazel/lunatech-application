package org.lunatech.assessment.repository;

import org.lunatech.assessment.model.Runway;
import org.lunatech.assessment.model.dto.RunwayIdentCountDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mohammad on 8/11/2018.
 */
@Repository
public interface IRunwayRepository extends JpaRepository<Runway, String> {

    @Query("select distinct(r.surface) from Runway as r where r.surface <> '' and r.airport.country.id = :countryId")
    List<String> getRunwayTypesByCountry(@Param("countryId") String countryId);

    @Query("select new org.lunatech.assessment.model.dto.RunwayIdentCountDto(r.le_ident, count(r.id)) " +
            "from Runway as r group by r.le_ident order by count(r.id) desc ")
    List<RunwayIdentCountDto> getRunwayIdentCounts(Pageable pageable);

    @Query("select r from Runway as r where r.airport.id = :airportId")
    List<Runway> getRunwaysByAirportId(@Param("airportId") String airportId);
}
