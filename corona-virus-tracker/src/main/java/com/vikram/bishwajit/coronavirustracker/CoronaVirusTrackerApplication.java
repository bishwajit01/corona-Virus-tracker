package com.vikram.bishwajit.coronavirustracker;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * @author Bishwajit.
 *
 */
@SpringBootApplication
@EnableScheduling
public class CoronaVirusTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaVirusTrackerApplication.class, args);
	}

}
