package com.vikram.bishwajit.coronavirustracker.helper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
			locationStats.setClosedCasesPerCountry(deathCases + recoveredCases);
			locationMap.put(country, locationStats);
		}
		coronaVirusTrackerBean.setLocationMasterMap(locationMap);
	}

	public void parsingCSVFILE(String filePath, CoronaVirusTrackerBean coronaVirusTrackerBean) throws IOException {
		LocationStats locationStats = null;
		Map<String, LocationStats> locationStatMap = new HashMap<String, LocationStats>();
		Reader in = new FileReader(filePath);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		int totalConfirmedCases = 0;
		int totalRecoveredCases = 0;
		int totalDeathCases = 0;
		for (CSVRecord record : records) {
			int cases = 0;
			locationStats = new LocationStats();
			locationStats.setCountry(record.get("Countries"));
			System.out.println("----->" + record.get("Total Cases").replaceAll(",", ""));
			String totalConfirmedCasesPerCountry = record.get("Total Cases").replaceAll(",", "").trim();
			String totlRecoveredCasesPerCountry = record.get("Total Recovered").replaceAll(",", "").trim();
			String totalDeathCasesPerCountry = record.get("Total Death").replaceAll(",", "").trim();
			if (!totalConfirmedCasesPerCountry.equals("N/A") && !totalConfirmedCasesPerCountry.equals("")) {
				cases = Integer.parseInt(totalConfirmedCasesPerCountry);
				totalConfirmedCases += cases;
				locationStats.setTotalNumberOfConfirmedCasesPerCountry(cases);
			} else {
				totalConfirmedCases += 0;
				locationStats.setTotalNumberOfConfirmedCasesPerCountry(0);
			}
			if (!totlRecoveredCasesPerCountry.equals("N/A") && !totlRecoveredCasesPerCountry.equals("")) {
				cases = Integer.parseInt(totlRecoveredCasesPerCountry);
				totalRecoveredCases += cases;
				locationStats.setTotalNumberOfRecoveredCasesPerCountry(cases);
			} else {
				totalRecoveredCases += 0;
				locationStats.setTotalNumberOfRecoveredCasesPerCountry(0);
			}
			if (!totalDeathCasesPerCountry.equals("N/A") && !totalDeathCasesPerCountry.equals("")) {
				cases = Integer.parseInt(totalDeathCasesPerCountry);
				totalDeathCases += cases;
				locationStats.setTotalNumberOfDeathCasesPerCountry(cases);
			} else {
				totalDeathCases += 0;
				locationStats.setTotalNumberOfDeathCasesPerCountry(0);
			}
			locationStatMap.put(record.get("Countries"), locationStats);
		}
		coronaVirusTrackerBean.getWorldstats().setTotalNumberOfCases(totalConfirmedCases);
		coronaVirusTrackerBean.getWorldstats().setTotalNumberOfDeath(totalDeathCases);
		coronaVirusTrackerBean.getWorldstats().setTotalNumberOfRecoveries(totalRecoveredCases);
		coronaVirusTrackerBean.setLocationMasterMap(locationStatMap);
	}
}
