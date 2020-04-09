package com.vikram.bishwajit.coronavirustracker.beans;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.vikram.bishwajit.coronavirustracker.models.LocationStats;
import com.vikram.bishwajit.coronavirustracker.models.WorldStats;

/**
 * @author Bishwajit.
 *
 */
@Component
public class CoronaVirusTrackerBean {

	private LocationStats locationstats = new LocationStats();
	private WorldStats worldstats = new WorldStats();
	Map<String, Integer> confirmedCaseMap;
	Map<String, Integer> deathCaseMap;
	Map<String, Integer> recoverCaseMap;
	private Map<String, LocationStats> locationMasterMap;

	/**
	 * @return the locationstats
	 */
	public LocationStats getLocationstats() {
		return locationstats;
	}

	/**
	 * @param locationstats the locationstats to set
	 */
	public void setLocationstats(LocationStats locationstats) {
		this.locationstats = locationstats;
	}

	/**
	 * @return the worldstats
	 */
	public WorldStats getWorldstats() {
		return worldstats;
	}

	/**
	 * @param worldstats the worldstats to set
	 */
	public void setWorldstats(WorldStats worldstats) {
		this.worldstats = worldstats;
	}

	/**
	 * @return the confirmedCaseMap
	 */
	public Map<String, Integer> getConfirmedCaseMap() {
		return confirmedCaseMap;
	}

	/**
	 * @param confirmedCaseMap the confirmedCaseMap to set
	 */
	public void setConfirmedCaseMap(Map<String, Integer> confirmedCaseMap) {
		this.confirmedCaseMap = confirmedCaseMap;
	}

	/**
	 * @return the deathCaseMap
	 */
	public Map<String, Integer> getDeathCaseMap() {
		return deathCaseMap;
	}

	/**
	 * @param deathCaseMap the deathCaseMap to set
	 */
	public void setDeathCaseMap(Map<String, Integer> deathCaseMap) {
		this.deathCaseMap = deathCaseMap;
	}

	/**
	 * @return the recoverCaseMap
	 */
	public Map<String, Integer> getRecoverCaseMap() {
		return recoverCaseMap;
	}

	/**
	 * @param recoverCaseMap the recoverCaseMap to set
	 */
	public void setRecoverCaseMap(Map<String, Integer> recoverCaseMap) {
		this.recoverCaseMap = recoverCaseMap;
	}

	/**
	 * @return the locationMasterMap
	 */
	public Map<String, LocationStats> getLocationMasterMap() {
		return locationMasterMap;
	}

	/**
	 * @param locationMasterMap the locationMasterMap to set
	 */
	public void setLocationMasterMap(Map<String, LocationStats> locationMasterMap) {
		this.locationMasterMap = locationMasterMap;
	}

}
