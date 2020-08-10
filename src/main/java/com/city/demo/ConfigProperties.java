package com.city.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class ConfigProperties {

	@Value("${cities.file}")
	private String cityFile;

	public String getCityFile() {
		return cityFile;
	}

	public void setCityFile(String cityFile) {
		this.cityFile = cityFile;
	}
}
