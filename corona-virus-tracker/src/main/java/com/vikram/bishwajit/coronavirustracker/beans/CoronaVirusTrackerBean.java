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

	private Set<LocationStats> allLocationStats;
	private WorldStats worldStats;

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
	 * @return the worldStats
	 */
	public WorldStats getWorldStats() {
		return worldStats;
	}

	/**
	 * @param worldStats the worldStats to set
	 */
	public void setWorldStats(WorldStats worldStats) {
		this.worldStats = worldStats;
	}

}
