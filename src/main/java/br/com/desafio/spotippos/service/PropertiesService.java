package br.com.desafio.spotippos.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import br.com.desafio.spotippos.model.Properties;
import br.com.desafio.spotippos.repository.PropertiesRepository;

@Service
public class PropertiesService {
	
	@Autowired
	private PropertiesRepository propertiesDAO;

	public Properties findById(Long id) {
		return propertiesDAO.findById(id);		
	}

}
