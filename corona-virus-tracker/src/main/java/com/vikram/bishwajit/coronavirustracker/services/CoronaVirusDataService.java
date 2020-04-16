package com.vikram.bishwajit.coronavirustracker.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.vikram.bishwajit.coronavirustracker.beans.CoronaVirusTrackerBean;
import com.vikram.bishwajit.coronavirustracker.constant.CoronaVirusTrackerConstant;
import com.vikram.bishwajit.coronavirustracker.helper.CoronaVirusTrackerHelper;

/**
 * @author Bishwajit.
 *
 */
@Service
public class CoronaVirusDataService {

	@Autowired
	CoronaVirusTrackerBean coronaVirusTrackerBean;

	// @PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchCasesDataFromURL() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = null;
		HttpResponse<String> response = null;
		CoronaVirusTrackerHelper coronaVirusTrackerHelper = new CoronaVirusTrackerHelper();

		/**
		 * Confirmed Cases
		 */
		request = HttpRequest.newBuilder().uri(URI.create(CoronaVirusTrackerConstant.CONFIRMED_CASES_URL)).build();
		response = client.send(request, HttpResponse.BodyHandlers.ofString());
		coronaVirusTrackerHelper.parsingCSVForConfirmedCases(response.body(), coronaVirusTrackerBean);

		/**
		 * Death Cases
		 */
		request = HttpRequest.newBuilder().uri(URI.create(CoronaVirusTrackerConstant.DEATH_CASES_URL)).build();
		response = client.send(request, HttpResponse.BodyHandlers.ofString());
		coronaVirusTrackerHelper.parsingCSVForDeathCases(response.body(), coronaVirusTrackerBean);

		/**
		 * Recoveries.
		 */
		request = HttpRequest.newBuilder().uri(URI.create(CoronaVirusTrackerConstant.RECOVERED_CASES_URL)).build();
		response = client.send(request, HttpResponse.BodyHandlers.ofString());
		coronaVirusTrackerHelper.parsingCSVForRecoveredCases(response.body(), coronaVirusTrackerBean);

		/**
		 * Map Preparation.
		 */
		coronaVirusTrackerHelper.preparingMasterMap(coronaVirusTrackerBean);
	}

	@Scheduled(cron = "* * 1 * * *")
	public void fetchCasesDataFromCSV() throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec(CoronaVirusTrackerConstant.PYTHON + " "
				+ CoronaVirusTrackerConstant.PATH + CoronaVirusTrackerConstant.PYTHON_FILE_NAME);
		Thread.sleep(10000);
		CoronaVirusTrackerHelper coronaVirusTrackerHelper = new CoronaVirusTrackerHelper();
		String filePath = CoronaVirusTrackerConstant.PATH + CoronaVirusTrackerConstant.CSV_FILE_NAME;
		coronaVirusTrackerHelper.parsingCSVFILE(filePath, coronaVirusTrackerBean);
	}

	/**
	 * @return the coronaVirusTrackerBean
	 */
	public CoronaVirusTrackerBean getCoronaVirusTrackerBean() {
		return coronaVirusTrackerBean;
	}

	/**
	 * @param coronaVirusTrackerBean the coronaVirusTrackerBean to set
	 */
	public void setCoronaVirusTrackerBean(CoronaVirusTrackerBean coronaVirusTrackerBean) {
		this.coronaVirusTrackerBean = coronaVirusTrackerBean;
	}

}
