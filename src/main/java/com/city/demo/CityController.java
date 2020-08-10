package com.city.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

	@Autowired
	CityService service;

	@GetMapping(path = "/connected")
	public String getCityConnections(@RequestParam String origin, @RequestParam String destination) {

		if (!StringUtils.hasText(origin) || !StringUtils.hasText(destination)) {
			return "no";
		}
		Boolean result = service.getCityConnections(StringUtils.trimWhitespace(origin),
				StringUtils.trimWhitespace(destination));
		if (result != null && result == Boolean.TRUE) {
			return "yes";
		}
		return "no";
	}

}
