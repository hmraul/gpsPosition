package com.rhm;

import com.rhm.core.services.GeoCoordinateService;
import com.rhm.infrastructure.services.GeoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GpsPositionApplication {

	@Bean
	public GeoCoordinateService geoCoordinateService() {
		return new GeoService();
	}

	public static void main(String[] args) {
		SpringApplication.run(GpsPositionApplication.class, args);
	}
}
