package org.lunatech.assessment.model.dto;

import java.util.List;

/**
 * Created by m.fazel on 8/14/2018.
 */
public class CountryRunwayTypeDto {

    public CountryRunwayTypeDto(String countryName, List<String> runwayTypes) {
        this.countryName = countryName;
        this.runwayTypes = runwayTypes;
    }

    private String countryName;
    private List<String> runwayTypes;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<String> getRunwayTypes() {
        return runwayTypes;
    }

    public void setRunwayTypes(List<String> runwayTypes) {
        this.runwayTypes = runwayTypes;
    }
}
