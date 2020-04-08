package com.vikram.bishwajit.coronavirustracker.beans;

import java.util.Set;

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
	private Set<LocationStats> allLocationStats;

	/**
	 * @return the allLocationStats
	 */
	public Set<LocationStats> getAllLocationStats() {
		return allLocationStats;
	}

	/**
	 * @param allLocationStats the allLocationStats to set
	 */
	public void setAllLocationStats(Set<LocationStats> allLocationStats) {
		this.allLocationStats = allLocationStats;
	}

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

}
