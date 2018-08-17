package org.lunatech.assessment.model.dto;

import org.lunatech.assessment.model.projection.CountryCountProjection;

import java.util.*;

/**
 * Created by m.fazel on 8/12/2018.
 */
public class ReportDto {

    public ReportDto() {
        this.countriesWithHighestNumberOfAirports = new ArrayList<CountryCountDto>();
        this.countriesWithLowestNumberOfAirports = new ArrayList<CountryCountProjection>();
        this.countryRunwayTypes = new HashMap<String, Set<String>>();
        this.runwayIdentCounts = new ArrayList<RunwayIdentCountDto>();
    }

    private List<CountryCountDto> countriesWithHighestNumberOfAirports;
    private List<CountryCountProjection> countriesWithLowestNumberOfAirports;
    private Map<String, Set<String>> countryRunwayTypes;
    private List<RunwayIdentCountDto> runwayIdentCounts;

    public List<CountryCountDto> getCountriesWithHighestNumberOfAirports() {
        return countriesWithHighestNumberOfAirports;
    }

    public void setCountriesWithHighestNumberOfAirports(List<CountryCountDto> countriesWithHighestNumberOfAirports) {
        this.countriesWithHighestNumberOfAirports = countriesWithHighestNumberOfAirports;
    }

    public List<CountryCountProjection> getCountriesWithLowestNumberOfAirports() {
        return countriesWithLowestNumberOfAirports;
    }

    public void setCountriesWithLowestNumberOfAirports(List<CountryCountProjection> countriesWithLowestNumberOfAirports) {
        this.countriesWithLowestNumberOfAirports = countriesWithLowestNumberOfAirports;
    }

    public Map<String, Set<String>> getCountryRunwayTypes() {
        return countryRunwayTypes;
    }

    public void setCountryRunwayTypes(Map<String, Set<String>> countryRunwayTypes) {
        this.countryRunwayTypes = countryRunwayTypes;
    }

    public List<RunwayIdentCountDto> getRunwayIdentCounts() {
        return runwayIdentCounts;
    }

    public void setRunwayIdentCounts(List<RunwayIdentCountDto> runwayIdentCounts) {
        this.runwayIdentCounts = runwayIdentCounts;
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "countriesWithHighestNumberOfAirports=" + countriesWithHighestNumberOfAirports +
                ", countriesWithLowestNumberOfAirports=" + countriesWithLowestNumberOfAirports +
                ", countryRunwayTypes=" + countryRunwayTypes +
                ", runwayIdentCounts=" + runwayIdentCounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportDto reportDto = (ReportDto) o;
        return Objects.equals(countriesWithHighestNumberOfAirports, reportDto.countriesWithHighestNumberOfAirports) &&
                Objects.equals(countriesWithLowestNumberOfAirports, reportDto.countriesWithLowestNumberOfAirports) &&
                Objects.equals(countryRunwayTypes, reportDto.countryRunwayTypes) &&
                Objects.equals(runwayIdentCounts, reportDto.runwayIdentCounts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countriesWithHighestNumberOfAirports, countriesWithLowestNumberOfAirports, countryRunwayTypes, runwayIdentCounts);
    }
}
