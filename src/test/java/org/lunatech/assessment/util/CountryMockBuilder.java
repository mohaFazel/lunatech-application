package org.lunatech.assessment.util;

import org.lunatech.assessment.model.Country;

public class CountryMockBuilder {

    private Country country = new Country();

    public Country build(){
        return this.country;
    }

    public CountryMockBuilder setCode(String code){
        country.setCode(code);
        return this;
    }

    public CountryMockBuilder setId(String id) {
        country.setId(id);
        return this;
    }

    public CountryMockBuilder setName(String name) {
        country.setName(name);
        return this;
    }
}
