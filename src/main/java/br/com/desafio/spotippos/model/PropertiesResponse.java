package br.com.desafio.spotippos.model;

import java.util.List;

public class PropertiesResponse {

	private List<Properties> properties;
	
	private Integer totalProperties;
	
	public List<Properties> getProperties() {
		return properties;
	}

	public void setPropertiesList(List<Properties> properties) {
		this.properties = properties;
	}

	public Integer getTotalProperties() {
		return totalProperties;
	}

	public void setTotalProperties(Integer totalProperties) {
		this.totalProperties = totalProperties;
	}
}

