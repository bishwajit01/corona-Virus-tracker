package com.vikram.bishwajit.coronavirustracker.helper;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.vikram.bishwajit.coronavirustracker.beans.CoronaVirusTrackerBean;
import com.vikram.bishwajit.coronavirustracker.models.LocationStats;

/**
 * @author Bishwajit.
 *
 */
public class CoronaVirusTrackerHelper {

	public void parsingCSVForConfirmedCases(String encodedString, CoronaVirusTrackerBean coronaVirusTrackerBean)
			throws IOException {
		LocationStats locationStats = null;
		Map<String, Integer> locationStatMap = new HashMap<String, Integer>();
		int totalConfirmedCases = 0;
		StringReader stringToBeParsed = new StringReader(encodedString);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringToBeParsed);
		for (CSVRecord record : records) {
			int cases = Integer.parseInt(record.get(record.size() - 1));
			totalConfirmedCases += cases;
			locationStats = new LocationStats();
			locationStats.setCountry(record.get("Country/Region"));
			if (locationStatMap.containsKey(record.get("Country/Region"))) {
				int countrycase = 0;
				if (null != locationStatMap.get(record.get("Country/Region"))) {
					countrycase = locationStatMap.get(record.get("Country/Region"));
				}
				locationStatMap.put(record.get("Country/Region"), countrycase + cases);
			} else {
				locationStatMap.put(record.get("Country/Region"), cases);
			}
		}
		coronaVirusTrackerBean.getWorldstats().setTotalNumberOfCases(totalConfirmedCases);
		coronaVirusTrackerBean.setConfirmedCaseMap(locationStatMap);
	}

	public void parsingCSVForDeathCases(String encodedString, CoronaVirusTrackerBean coronaVirusTrackerBean)
			throws IOException {
		LocationStats locationStats = null;
		int totalDeathCases = 0;
		Map<String, Integer> locationStatMap = new HashMap<String, Integer>();
		StringReader stringToBeParsed = new StringReader(encodedString);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringToBeParsed);
		for (CSVRecord record : records) {
			int cases = Integer.parseInt(record.get(record.size() - 1));
			totalDeathCases += cases;
			locationStats = new LocationStats();
			locationStats.setCountry(record.get("Country/Region"));
			if (locationStatMap.containsKey(record.get("Country/Region"))) {
				int countrycase = 0;
				if (null != locationStatMap.get(record.get("Country/Region"))) {
					countrycase = locationStatMap.get(record.get("Country/Region"));
				}
				locationStatMap.put(record.get("Country/Region"), countrycase + cases);
			} else {
				locationStatMap.put(record.get("Country/Region"), cases);
			}
		}
		coronaVirusTrackerBean.getWorldstats().setTotalNumberOfDeath(totalDeathCases);
		coronaVirusTrackerBean.setDeathCaseMap(locationStatMap);
	}

	public void parsingCSVForRecoveredCases(String encodedString, CoronaVirusTrackerBean coronaVirusTrackerBean)
			throws IOException {
		LocationStats locationStats = null;
		Map<String, Integer> locationStatMap = new HashMap<String, Integer>();
		int totalRecoveredCases = 0;
		StringReader stringToBeParsed = new StringReader(encodedString);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringToBeParsed);
		for (CSVRecord record : records) {
			int cases = Integer.parseInt(record.get(record.size() - 1));
			totalRecoveredCases += cases;
			locationStats = new LocationStats();
			locationStats.setCountry(record.get("Country/Region"));
			if (locationStatMap.containsKey(record.get("Country/Region"))) {
				int countrycase = 0;
				if (null != locationStatMap.get(record.get("Country/Region"))) {
					countrycase = locationStatMap.get(record.get("Country/Region"));
				}
				locationStatMap.put(record.get("Country/Region"), countrycase + cases);
			} else {
				locationStatMap.put(record.get("Country/Region"), cases);
			}
		}
		coronaVirusTrackerBean.getWorldstats().setTotalNumberOfRecoveries(totalRecoveredCases);
		coronaVirusTrackerBean.setRecoverCaseMap(locationStatMap);
	}

	public void preparingMasterMap(CoronaVirusTrackerBean coronaVirusTrackerBean) {
		Map<String, LocationStats> locationMap = new HashMap<String, LocationStats>();
		LocationStats locationStats = null;
		for (String country : coronaVirusTrackerBean.getConfirmedCaseMap().keySet()) {
			locationStats = new LocationStats();
			int confirmedCases = coronaVirusTrackerBean.getConfirmedCaseMap().get(country);
			int deathCases = coronaVirusTrackerBean.getDeathCaseMap().get(country);
			int recoveredCases = coronaVirusTrackerBean.getRecoverCaseMap().get(country);
			locationStats.setTotalNumberOfConfirmedCasesPerCountry(confirmedCases);
			locationStats.setTotalNumberOfDeathCasesPerCountry(deathCases);
			locationStats.setTotalNumberOfRecoveredCasesPerCountry(recoveredCases);
			locationStats.setActiveCasesPerCountry(confirmedCases - deathCases - recoveredCases);
			locationMap.put(country, locationStats);
		}
		coronaVirusTrackerBean.setLocationMasterMap(locationMap);
	}
}
