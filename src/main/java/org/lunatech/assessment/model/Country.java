package org.lunatech.assessment.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by m.fazel on 8/11/2018.
 */
@Entity
@Table(name = "tbl_country")
public class Country {

    @Id
    private String id;
    private String code;
    private String name;
    private String continent;
    private String wikipedia_link;
    private String keywords;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getWikipedia_link() {
        return wikipedia_link;
    }

    public void setWikipedia_link(String wikipedia_link) {
        this.wikipedia_link = wikipedia_link;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != null ? !id.equals(country.id) : country.id != null) return false;
        if (code != null ? !code.equals(country.code) : country.code != null) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (continent != null ? !continent.equals(country.continent) : country.continent != null) return false;
        if (wikipedia_link != null ? !wikipedia_link.equals(country.wikipedia_link) : country.wikipedia_link != null)
            return false;
        return keywords != null ? keywords.equals(country.keywords) : country.keywords == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        result = 31 * result + (wikipedia_link != null ? wikipedia_link.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        return result;
    }
}
