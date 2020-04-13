package com.vikram.bishwajit.coronavirustracker.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vikram.bishwajit.coronavirustracker.services.CoronaVirusDataService;

/**
 * @author Bishwajit.
 *
 */
@Controller
@RequestMapping("/")
public class CoronaVirusController {

	@Autowired
	CoronaVirusDataService coronaVirusDataService;

	@GetMapping("/")
	public String choice() {
		return "dashboard";
	}

	@GetMapping("home")
	public String coronaVirusInitialView(Model model, @RequestParam String id)
			throws IOException, InterruptedException {
		if (id.equals("1")) {
			coronaVirusDataService.fetchCasesDataFromURL();
			model.addAttribute("worldStats", coronaVirusDataService.getCoronaVirusTrackerBean().getWorldstats());
			return "coronaIntialView";
		} else if (id.equals("2")) {
			coronaVirusDataService.fetchCasesDataFromCSV();
			model.addAttribute("worldStats", coronaVirusDataService.getCoronaVirusTrackerBean().getWorldstats());
			return "coronaIntialView";
		}
		return "coronaErrorView";
	}

	@GetMapping("location")
	public String viewByLocation(Model model) {
		model.addAttribute("locationStats", coronaVirusDataService.getCoronaVirusTrackerBean().getLocationMasterMap());
		return "viewByLocation";
	}

	@GetMapping("errorView")
	public String coronaErrorView() {
		return "coronaErrorView";
	}
}
