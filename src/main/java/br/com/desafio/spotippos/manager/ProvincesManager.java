package br.com.desafio.spotippos.manager;

import br.com.desafio.spotippos.model.ProvincesResponse;

public class ProvincesManager {
	
	private static ProvincesResponse provinces;
	
	private static ProvincesManager instance;
	
	private ProvincesManager() {}
	
	public static ProvincesManager getInstance() {
		if(provinces == null)
			throw new IllegalAccessError();
		if(instance == null) 
			instance = new ProvincesManager();
		return instance;
	}
	
	public ProvincesManager(ProvincesResponse provinces) {
		this.provinces = provinces;
	}
	
	public ProvincesResponse getProvinces() {
		return provinces;
	}
}
