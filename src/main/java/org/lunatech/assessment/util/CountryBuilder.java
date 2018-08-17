package org.lunatech.assessment.util;

import org.apache.commons.csv.CSVRecord;
import org.lunatech.assessment.model.Country;

/**
 * Created by m.fazel on 8/15/2018.
 */
public class CountryBuilder {

    private Country country = new Country();

    public CountryBuilder(CSVRecord record) {
        setId(record.get("id")).setCode(record.get("code")).setName(record.get("name"))
                .setContinent(record.get("continent")).setWikipedia_link(record.get("wikipedia_link"))
                .setKeywords(record.get("keywords"));
    }

    public Country build(){
        return this.country;
    }

    public CountryBuilder setCode(String code){
        country.setCode(code);
        return this;
    }

    public CountryBuilder setContinent(String continent) {
        country.setContinent(continent);
        return this;
    }

    public CountryBuilder setId(String id) {
        country.setId(id);
        return this;
    }

    public CountryBuilder setKeywords(String keywords) {
        country.setKeywords(keywords);
        return this;
    }

    public CountryBuilder setName(String name) {
        country.setName(name);
        return this;
    }

    public CountryBuilder setWikipedia_link(String wikipedia_link) {
        country.setWikipedia_link(wikipedia_link);
        return this;
    }
}
