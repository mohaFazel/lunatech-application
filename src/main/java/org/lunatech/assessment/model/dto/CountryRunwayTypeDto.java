package org.lunatech.assessment.model.dto;

import java.util.List;

/**
 * Created by m.fazel on 8/14/2018.
 */
public class CountryRunwayTypeDto {

    public CountryRunwayTypeDto(String countryCode, List<String> runwayTypes) {
        this.countryCode = countryCode;
        this.runwayTypes = runwayTypes;
    }

    private String countryCode;
    private List<String> runwayTypes;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<String> getRunwayTypes() {
        return runwayTypes;
    }

    public void setRunwayTypes(List<String> runwayTypes) {
        this.runwayTypes = runwayTypes;
    }
}
