package com.vikram.bishwajit.coronavirustracker.models;

/**
 * @author Bishwajit.
 *
 */
public class LocationStats {
	
	private String province;
	private String country;
	private int totalNumberOfConfirmedCasesPerCountry;
	private int totalNumberOfDeathCasesPerCountry;
	private int totalNumberOfRecoveredCasesPerCountry;

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

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

	/**
	 * @return the totalNumberOfConfirmedCasesPerCountry
	 */
	public int getTotalNumberOfConfirmedCasesPerCountry() {
		return totalNumberOfConfirmedCasesPerCountry;
	}

	/**
	 * @param totalNumberOfConfirmedCasesPerCountry the
	 *                                              totalNumberOfConfirmedCasesPerCountry
	 *                                              to set
	 */
	public void setTotalNumberOfConfirmedCasesPerCountry(int totalNumberOfConfirmedCasesPerCountry) {
		this.totalNumberOfConfirmedCasesPerCountry = totalNumberOfConfirmedCasesPerCountry;
	}

	/**
	 * @return the totalNumberOfDeathCasesPerCountry
	 */
	public int getTotalNumberOfDeathCasesPerCountry() {
		return totalNumberOfDeathCasesPerCountry;
	}

	/**
	 * @param totalNumberOfDeathCasesPerCountry the
	 *                                          totalNumberOfDeathCasesPerCountry to
	 *                                          set
	 */
	public void setTotalNumberOfDeathCasesPerCountry(int totalNumberOfDeathCasesPerCountry) {
		this.totalNumberOfDeathCasesPerCountry = totalNumberOfDeathCasesPerCountry;
	}

	/**
	 * @return the totalNumberOfRecoveredCasesPerCountry
	 */
	public int getTotalNumberOfRecoveredCasesPerCountry() {
		return totalNumberOfRecoveredCasesPerCountry;
	}

	/**
	 * @param totalNumberOfRecoveredCasesPerCountry the
	 *                                              totalNumberOfRecoveredCasesPerCountry
	 *                                              to set
	 */
	public void setTotalNumberOfRecoveredCasesPerCountry(int totalNumberOfRecoveredCasesPerCountry) {
		this.totalNumberOfRecoveredCasesPerCountry = totalNumberOfRecoveredCasesPerCountry;
	}

}
