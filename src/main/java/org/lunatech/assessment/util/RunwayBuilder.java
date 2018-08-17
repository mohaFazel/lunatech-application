package org.lunatech.assessment.util;

import org.apache.commons.csv.CSVRecord;
import org.lunatech.assessment.model.Airport;
import org.lunatech.assessment.model.Runway;
import org.lunatech.assessment.repository.IAirportRepository;
import org.lunatech.assessment.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;

public class RunwayBuilder {

	private Runway runway = new Runway();

	public RunwayBuilder(CSVRecord record) {
		setId(record.get("id")).setAirport_ident(record.get("airport_ident"))
				.setLength_ft(record.get("length_ft")).setWidth_ft(record.get("width_ft"))
				.setSurface(record.get("surface")).setLighted(record.get("lighted")).setClosed(record.get("closed"))
				.setLe_ident(record.get("le_ident")).setLe_latitude_deg(record.get("le_latitude_deg"))
				.setLe_longitude_deg(record.get("le_longitude_deg")).setLe_elevation_ft(record.get("le_elevation_ft"))
				.setLe_heading_degT(record.get("le_heading_degT"))
				.setLe_displaced_threshold_ft(record.get("le_displaced_threshold_ft"))
				.setHe_ident(record.get("he_ident")).setHe_latitude_deg(record.get("he_latitude_deg"))
				.setHe_longitude_deg(record.get("he_longitude_deg")).setHe_elevation_ft(record.get("he_elevation_ft"))
				.setHe_heading_degT(record.get("he_heading_degT"))
				.setHe_displaced_threshold_ft(record.get("he_displaced_threshold_ft"));
	}

	public Runway build() {
		return this.runway;
	}

	public RunwayBuilder setAirport_ident(String airport_ident) {
		runway.setAirport_ident(airport_ident);
		return this;
	}

	public RunwayBuilder setClosed(String closed) {
		runway.setClosed(closed);
		return this;
	}

	public RunwayBuilder setHe_displaced_threshold_ft(String he_displaced_threshold_ft) {
		runway.setHe_displaced_threshold_ft(he_displaced_threshold_ft);
		return this;
	}

	public RunwayBuilder setHe_elevation_ft(String he_elevation_ft) {
		runway.setHe_elevation_ft(he_elevation_ft);
		return this;
	}

	public RunwayBuilder setHe_heading_degT(String he_heading_degT) {
		runway.setHe_heading_degT(he_heading_degT);
		return this;
	}

	public RunwayBuilder setHe_ident(String he_ident) {
		runway.setHe_ident(he_ident);
		return this;
	}

	public RunwayBuilder setHe_latitude_deg(String he_latitude_deg) {
		runway.setHe_latitude_deg(he_latitude_deg);
		return this;
	}

	public RunwayBuilder setHe_longitude_deg(String he_longitude_deg) {
		runway.setHe_longitude_deg(he_longitude_deg);
		return this;
	}

	public RunwayBuilder setId(String id) {
		runway.setId(id);
		return this;
	}

	public RunwayBuilder setLe_displaced_threshold_ft(String le_displaced_threshold_ft) {
		runway.setLe_displaced_threshold_ft(le_displaced_threshold_ft);
		return this;
	}

	public RunwayBuilder setLe_elevation_ft(String le_elevation_ft) {
		runway.setLe_elevation_ft(le_elevation_ft);
		return this;
	}

	public RunwayBuilder setLe_heading_degT(String le_heading_degT) {
		runway.setLe_heading_degT(le_heading_degT);
		return this;
	}

	public RunwayBuilder setLe_ident(String le_ident) {
		runway.setLe_ident(le_ident);
		return this;
	}

	public RunwayBuilder setLe_latitude_deg(String le_latitude_deg) {
		runway.setLe_latitude_deg(le_latitude_deg);
		return this;
	}

	public RunwayBuilder setLe_longitude_deg(String le_longitude_deg) {
		runway.setLe_longitude_deg(le_longitude_deg);
		return this;
	}

	public RunwayBuilder setLength_ft(String length_ft) {
		runway.setLength_ft(length_ft);
		return this;
	}

	public RunwayBuilder setLighted(String lighted) {
		runway.setLighted(lighted);
		return this;
	}

	public RunwayBuilder setSurface(String surface) {
		runway.setSurface(surface);
		return this;
	}

	public RunwayBuilder setWidth_ft(String width_ft) {
		runway.setWidth_ft(width_ft);
		return this;
	}

}
