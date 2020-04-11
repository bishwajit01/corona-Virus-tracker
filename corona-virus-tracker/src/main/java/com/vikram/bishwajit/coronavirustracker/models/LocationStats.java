package com.vikram.bishwajit.coronavirustracker.models;

/**
 * @author Bishwajit.
 *
 */
public class LocationStats {

	private String country;
	private int totalNumberOfConfirmedCasesPerCountry;
	private int totalNumberOfDeathCasesPerCountry;
	private int totalNumberOfRecoveredCasesPerCountry;
	private int activeCasesPerCountry;
	private int closedCasesPerCountry;

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	public int getTotalNumberOfConfirmedCasesPerCountry() {
		return totalNumberOfConfirmedCasesPerCountry;
	}

	public void setTotalNumberOfConfirmedCasesPerCountry(int totalNumberOfConfirmedCasesPerCountry) {
		this.totalNumberOfConfirmedCasesPerCountry = totalNumberOfConfirmedCasesPerCountry;
	}

	public int getTotalNumberOfDeathCasesPerCountry() {
		return totalNumberOfDeathCasesPerCountry;
	}

	public void setTotalNumberOfDeathCasesPerCountry(int totalNumberOfDeathCasesPerCountry) {
		this.totalNumberOfDeathCasesPerCountry = totalNumberOfDeathCasesPerCountry;
	}

	public int getTotalNumberOfRecoveredCasesPerCountry() {
		return totalNumberOfRecoveredCasesPerCountry;
	}

	public void setTotalNumberOfRecoveredCasesPerCountry(int totalNumberOfRecoveredCasesPerCountry) {
		this.totalNumberOfRecoveredCasesPerCountry = totalNumberOfRecoveredCasesPerCountry;
	}

	/**
	 * @return the activeCasesPerCountry
	 */
	public int getActiveCasesPerCountry() {
		return activeCasesPerCountry;
	}

	/**
	 * @param activeCasesPerCountry the activeCasesPerCountry to set
	 */
	public void setActiveCasesPerCountry(int activeCasesPerCountry) {
		this.activeCasesPerCountry = activeCasesPerCountry;
	}

	/**
	 * @return the closedCasesPerCountry
	 */
	public int getClosedCasesPerCountry() {
		return closedCasesPerCountry;
	}

	/**
	 * @param closedCasesPerCountry the closedCasesPerCountry to set
	 */
	public void setClosedCasesPerCountry(int closedCasesPerCountry) {
		this.closedCasesPerCountry = closedCasesPerCountry;
	}
	
}
