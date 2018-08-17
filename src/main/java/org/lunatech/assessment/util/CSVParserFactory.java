package org.lunatech.assessment.util;

import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.apache.commons.csv.CSVFormat.DEFAULT;

public final class CSVParserFactory {

	public enum CSVParserType {
		AIRPORT, COUNTRY, RUNWAY
	}
	private static final String AIRPORTS_CSV = "/file/airports.csv";
	private static final String COUNTRIES_CSV = "/file/countries.csv";
	private static final String RUNWAYS_CSV = "/file/runways.csv";

	public static CSVParser getParser(CSVParserType type) {

		try {
			Reader in = null;
			switch (type) {
			case COUNTRY:
				in = new InputStreamReader(
						CSVParserFactory.class.getResourceAsStream(COUNTRIES_CSV));
				break;
			case AIRPORT:
				in = new InputStreamReader(
						CSVParserFactory.class.getResourceAsStream(AIRPORTS_CSV));
				break;
			case RUNWAY:
				in = new InputStreamReader(
						CSVParserFactory.class.getResourceAsStream(RUNWAYS_CSV));
				break;
			default:
				break;
			}
			return new CSVParser(in, DEFAULT.withFirstRecordAsHeader());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private CSVParserFactory() {
	}

}
