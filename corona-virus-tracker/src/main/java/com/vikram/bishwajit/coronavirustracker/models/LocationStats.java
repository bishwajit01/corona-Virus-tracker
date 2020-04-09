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

}
