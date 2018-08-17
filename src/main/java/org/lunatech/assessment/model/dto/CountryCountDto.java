package org.lunatech.assessment.model.dto;

/**
 * Created by m.fazel on 8/15/2018.
 */
public class CountryCountDto {

    public CountryCountDto(String country, Long count) {
        this.country = country;
        this.count = count;
    }

    private String country;
    private Long count;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
