package org.lunatech.assessment.config;

import org.apache.commons.csv.CSVParser;
import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.Country;
import org.lunatech.assessment.model.Runway;
import org.lunatech.assessment.repository.IAirportRepository;
import org.lunatech.assessment.repository.ICountryRepository;
import org.lunatech.assessment.repository.IRunwayRepository;
import org.lunatech.assessment.util.AirportBuilder;
import org.lunatech.assessment.util.CSVParserFactory;
import org.lunatech.assessment.util.CountryBuilder;
import org.lunatech.assessment.util.RunwayBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

import static org.lunatech.assessment.util.CSVParserFactory.CSVParserType.AIRPORT;
import static org.lunatech.assessment.util.CSVParserFactory.CSVParserType.COUNTRY;
import static org.lunatech.assessment.util.CSVParserFactory.CSVParserType.RUNWAY;

/**
 * Created by mohammad on 8/11/2018.
 */
@Configuration
public class ReadCsvConfig {

    @Autowired
    private ICountryRepository countryRepo;

    @Autowired
    private IAirportRepository airportRepo;

    @Autowired
    private IRunwayRepository runwayRepo;

    @PostConstruct
    public void initDB() throws IOException {
        storeCountries();
        storeAirports();
        storeRunways();
    }

    private void storeRunways() throws IOException {

        CSVParser parser = CSVParserFactory.getParser(RUNWAY);
        parser.getRecords().forEach(record -> {
            Runway runway = new RunwayBuilder(record).build();
            runway.setAirport(airportRepo.findById(record.get("airport_ref")).get());
            runwayRepo.save(runway);
        });
        parser.close();
    }

    private void storeAirports() throws IOException {

        CSVParser parser = CSVParserFactory.getParser(AIRPORT);
        parser.getRecords().forEach(record -> {
            Airport airport = new AirportBuilder(record).build();
            airport.setCountry(countryRepo.findByCode(record.get("iso_country")));
            airportRepo.save(airport);
        });
        parser.close();
    }

    public void storeCountries() throws IOException {

        CSVParser parser = CSVParserFactory.getParser(COUNTRY);
        parser.getRecords().forEach(record -> {
            Country country = new CountryBuilder(record).build();
            countryRepo.save(country);
        });
        parser.close();
    }
}
