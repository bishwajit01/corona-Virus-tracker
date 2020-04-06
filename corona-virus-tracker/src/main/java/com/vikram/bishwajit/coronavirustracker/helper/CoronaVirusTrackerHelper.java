package com.vikram.bishwajit.coronavirustracker.helper;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.vikram.bishwajit.coronavirustracker.beans.CoronaVirusTrackerBean;
import com.vikram.bishwajit.coronavirustracker.models.LocationStats;
import com.vikram.bishwajit.coronavirustracker.models.WorldStats;

/**
 * @author Bishwajit.
 *
 */
public class CoronaVirusTrackerHelper {

	WorldStats worldStats = new WorldStats();

	public void parsingCSVForConfirmedCases(String encodedString, CoronaVirusTrackerBean coronaVirusTrackerBean)
			throws IOException {
		LocationStats locationStats = null;
		Set<LocationStats> locationStatsSet = new HashSet<LocationStats>();
		int totalConfirmedCases = 0;
		StringReader stringToBeParsed = new StringReader(encodedString);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringToBeParsed);
		for (CSVRecord record : records) {
			int cases = Integer.parseInt(record.get(record.size() - 1));
			totalConfirmedCases += cases;
			locationStats = new LocationStats();
			locationStats.setProvince(record.get("Province/State"));
			locationStats.setCountry(record.get("Country/Region"));
			locationStats.setTotalNumberOfConfirmedCasesPerCountry(cases);
			locationStatsSet.add(locationStats);
		}
		worldStats.setTotalNumberOfCases(totalConfirmedCases);
		System.out.println("Confirmd : " + totalConfirmedCases);
		coronaVirusTrackerBean.setAllLocationStats(locationStatsSet);
		coronaVirusTrackerBean.setWorldStats(worldStats);
	}

	public void parsingCSVForDeathCases(String encodedString, CoronaVirusTrackerBean coronaVirusTrackerBean)
			throws IOException {
		LocationStats locationStats = null;
		Set<LocationStats> locationStatsSet = new HashSet<LocationStats>();
		int totalDeathCases = 0;
		StringReader stringToBeParsed = new StringReader(encodedString);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringToBeParsed);
		for (CSVRecord record : records) {
			int cases = Integer.parseInt(record.get(record.size() - 1));
			totalDeathCases += cases;
			locationStats = new LocationStats();
			locationStats.setProvince(record.get("Province/State"));
			locationStats.setCountry(record.get("Country/Region"));
			locationStats.setTotalNumberOfDeathCasesPerCountry(cases);
			locationStatsSet.add(locationStats);
		}
		worldStats.setTotalNumberOfDeath(totalDeathCases);
		System.out.println("Death Case : " + totalDeathCases);
		coronaVirusTrackerBean.setAllLocationStats(locationStatsSet);
		coronaVirusTrackerBean.setWorldStats(worldStats);
	}

	public void parsingCSVForRecoveredCases(String encodedString, CoronaVirusTrackerBean coronaVirusTrackerBean)
			throws IOException {
		LocationStats locationStats = null;
		Set<LocationStats> locationStatsSet = new HashSet<LocationStats>();
		int totalRecoveredCases = 0;
		StringReader stringToBeParsed = new StringReader(encodedString);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringToBeParsed);
		for (CSVRecord record : records) {
			int cases = Integer.parseInt(record.get(record.size() - 1));
			totalRecoveredCases += cases;
			locationStats = new LocationStats();
			locationStats.setProvince(record.get("Province/State"));
			locationStats.setCountry(record.get("Country/Region"));
			locationStats.setTotalNumberOfRecoveredCasesPerCountry(cases);
			locationStatsSet.add(locationStats);
		}
		worldStats.setTotalNumberOfRecoveries(totalRecoveredCases);
		System.out.println("Recovered : " + totalRecoveredCases);
		coronaVirusTrackerBean.setAllLocationStats(locationStatsSet);
		coronaVirusTrackerBean.setWorldStats(worldStats);
	}
}
