package org.lunatech.assessment.repository;

import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.dto.CountryCountDto;
import org.lunatech.assessment.model.projection.CountryCountProjection;
import org.springframework.data.domain.Page;
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
public interface IAirportRepository extends JpaRepository<Airport, String> {

    @Query("select a from Airport a where lower(a.country.code) like lower(concat('%',:code,'%'))")
    Page<Airport> findByCountryCode(@Param("code") String countryCode, Pageable pageable);

    @Query("select a from Airport as a where lower(a.country.name) like lower(concat('%',:name,'%'))")
    Page<Airport> findByCountryName(@Param("name") String countryName, Pageable pageable);

    @Query("select a from Airport a where lower(a.country.code) like lower(concat('%',:country,'%'))" +
            "or lower(a.country.name) like lower(concat('%',:country,'%'))")
    Page<Airport> getAirportsByCountry(@Param("country") String country, Pageable pageable);

    @Query("select new org.lunatech.assessment.model.dto.CountryCountDto(a.country.name, count(a.id)) " +
            "from Airport as a group by a.country order by count (a.id) desc ")
    List<CountryCountDto> getCountriesWithHighestNumberOfAirports(Pageable pageable);


    /*@Query("select new org.lunatech.assessment.model.dto.CountryCountDto(a.country.name, count(a.id)) " +
            "from Airport as a join a.country c on a.country.id = c.id group by c.id order by count (a.id) asc ")*/
    //select c.name as name, count(a.id) as count from tbl_airport a right join tbl_country c on a.country_id=c.id
    // and (a.country_id=c.id) group by c.id order by count(a.id) asc limit 10

    @Query(name = "test", value = "select c.name as country, count(a.id) as count from tbl_airport as a " +
            "right join tbl_country as c on a.country_id = c.id group by c.id order by count(a.id) asc",
            nativeQuery = true)
    List<CountryCountProjection> getCountriesWithLowestNumberOfAirports(Pageable pageable);
}
