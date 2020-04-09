package com.vikram.bishwajit.coronavirustracker.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@GetMapping("home")
	public String coronaVirusInitialView(Model model) throws IOException, InterruptedException {
		model.addAttribute("worldStats", coronaVirusDataService.getCoronaVirusTrackerBean().getWorldstats());
		System.out.println(
				"Cases:" + coronaVirusDataService.getCoronaVirusTrackerBean().getWorldstats().getTotalNumberOfCases());
		System.out.println(
				"Death:" + coronaVirusDataService.getCoronaVirusTrackerBean().getWorldstats().getTotalNumberOfDeath());
		System.out.println("Recover:"
				+ coronaVirusDataService.getCoronaVirusTrackerBean().getWorldstats().getTotalNumberOfRecoveries());
		return "coronaIntialView";
	}

	@GetMapping("location")
	public String viewByLocation(Model model) {
		model.addAttribute("locationStats", coronaVirusDataService.getCoronaVirusTrackerBean().getLocationMasterMap());
		System.out.println(coronaVirusDataService.getCoronaVirusTrackerBean().getLocationMasterMap());
		return "viewByLocation";
	}

	@GetMapping("errorView")
	public String coronaErrorView() {
		return "coronaErrorView";
	}
}
