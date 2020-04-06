package com.vikram.bishwajit.coronavirustracker.models;

/**
 * @author Bishwajit.
 *
 */
public class WorldStats {
	private int totalNumberOfCases;
	private int totalNumberOfDeath;
	private int totalNumberOfRecoveries;
	/**
	 * @return the totalNumberOfCases
	 */
	public int getTotalNumberOfCases() {
		return totalNumberOfCases;
	}
	/**
	 * @param totalNumberOfCases the totalNumberOfCases to set
	 */
	public void setTotalNumberOfCases(int totalNumberOfCases) {
		this.totalNumberOfCases = totalNumberOfCases;
	}
	/**
	 * @return the totalNumberOfDeath
	 */
	public int getTotalNumberOfDeath() {
		return totalNumberOfDeath;
	}
	/**
	 * @param totalNumberOfDeath the totalNumberOfDeath to set
	 */
	public void setTotalNumberOfDeath(int totalNumberOfDeath) {
		this.totalNumberOfDeath = totalNumberOfDeath;
	}
	/**
	 * @return the totalNumberOfRecoveries
	 */
	public int getTotalNumberOfRecoveries() {
		return totalNumberOfRecoveries;
	}
	/**
	 * @param totalNumberOfRecoveries the totalNumberOfRecoveries to set
	 */
	public void setTotalNumberOfRecoveries(int totalNumberOfRecoveries) {
		this.totalNumberOfRecoveries = totalNumberOfRecoveries;
	}
}
