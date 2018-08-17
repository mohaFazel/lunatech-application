package org.lunatech.assessment.util;

import org.apache.commons.csv.CSVRecord;
import org.lunatech.assessment.model.Airport;

public class AirportBuilder {

	private Airport airport = new Airport();

	public AirportBuilder(CSVRecord record) {
		setId(record.get("id")).setIdent(record.get("ident")).setType(record.get("type")).setName(record.get("name"))
				.setLatitude_deg(record.get("latitude_deg")).setLongitude_deg(record.get("longitude_deg"))
				.setElevation_ft(record.get("elevation_ft")).setContinent(record.get("continent"))
				.setIso_region(record.get("iso_region")).setMunicipality(record.get("municipality"))
				.setScheduled_service(record.get("scheduled_service")).setGps_code(record.get("gps_code"))
				.setIata_code(record.get("iata_code")).setLocal_code(record.get("local_code"))
				.setHome_link(record.get("home_link")).setWikipedia_link(record.get("wikipedia_link"))
				.setKeywords(record.get("keywords"));
	}

	public Airport build() {
		return this.airport;
	}

	public AirportBuilder setContinent(String continent) {
		airport.setContinent(continent);
		return this;
	}

	public AirportBuilder setElevation_ft(String elevation_ft) {
		airport.setElevation_ft(elevation_ft);
		return this;
	}

	public AirportBuilder setGps_code(String gps_code) {
		airport.setGps_code(gps_code);
		return this;
	}

	public AirportBuilder setHome_link(String home_link) {
		airport.setHome_link(home_link);
		return this;
	}

	public AirportBuilder setIata_code(String iata_code) {
		airport.setIata_code(iata_code);
		return this;
	}

	public AirportBuilder setId(String id) {
		airport.setId(id);
		return this;
	}

	public AirportBuilder setIdent(String ident) {
		airport.setIdent(ident);
		return this;
	}

	public AirportBuilder setIso_region(String iso_region) {
		airport.setIso_region(iso_region);
		return this;
	}

	public AirportBuilder setKeywords(String keywords) {
		airport.setKeywords(keywords);
		return this;
	}

	public AirportBuilder setLatitude_deg(String latitude_deg) {
		airport.setLatitude_deg(latitude_deg);
		return this;
	}

	public AirportBuilder setLocal_code(String local_code) {
		airport.setLocal_code(local_code);
		return this;
	}

	public AirportBuilder setLongitude_deg(String longitude_deg) {
		airport.setLongitude_deg(longitude_deg);
		return this;
	}

	public AirportBuilder setMunicipality(String municipality) {
		airport.setMunicipality(municipality);
		return this;
	}

	public AirportBuilder setName(String name) {
		airport.setName(name);
		return this;
	}

	public AirportBuilder setScheduled_service(String scheduled_service) {
		airport.setScheduled_service(scheduled_service);
		return this;
	}

	public AirportBuilder setType(String type) {
		airport.setType(type);
		return this;
	}

	public AirportBuilder setWikipedia_link(String wikipedia_link) {
		airport.setWikipedia_link(wikipedia_link);
		return this;
	}

}
