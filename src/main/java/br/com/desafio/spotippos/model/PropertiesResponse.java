package br.com.desafio.spotippos.model;

import java.util.List;

public class PropertiesResponse {

	private List<Property> properties;
	
	private Integer totalProperties;
	
	public List<Property> getProperties() {
		return properties;
	}

	public void setPropertiesList(List<Property> properties) {
		this.properties = properties;
	}

	public Integer getTotalProperties() {
		return totalProperties;
	}

	public void setTotalProperties(Integer totalProperties) {
		this.totalProperties = totalProperties;
	}
}

