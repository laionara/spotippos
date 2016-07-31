package br.com.desafio.spotippos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.desafio.spotippos.model.PropertiesResponse;
import br.com.desafio.spotippos.model.ProvincesResponse;
import br.com.desafio.spotippos.service.PropertiesService;



@Controller
@Transactional
@RequestMapping("/")
public class PropertiesController {

	@Autowired
	private PropertiesService propertiesService;
	
	
//	
//		
//	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
//	public @ResponseBody Properties findProperties(Long id) {
//		return this.propertiesService.findById(id);
//		
//	}
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
//	public @ResponseBody Properties saveProperties() {
//		
//		return this.propertiesService.findById(id);
//		
//	}
	
	/**
	 * Para preencher os properties 
	 */
	@RequestMapping(value = "init", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody String init(){
		String propertiesUrl = "https://raw.githubusercontent.com/VivaReal/code-challenge/master/properties.json";
		String provincesUrl = "https://raw.githubusercontent.com/VivaReal/code-challenge/master/properties.json";
		
    	RestTemplate restTemplate = new RestTemplate();
    	String propertiesJSON = restTemplate.getForObject(propertiesUrl, String.class);
    	String provincesJSON = restTemplate.getForObject(provincesUrl, String.class);
        
        Gson gson = new Gson();        
    	PropertiesResponse propertiesResponse = gson.fromJson(propertiesJSON, PropertiesResponse.class);
    	ProvincesResponse provincesResponse = gson.fromJson(provincesJSON, ProvincesResponse.class);
        
        System.out.println(propertiesResponse.getTotalProperties());
        
        return gson.toJson("Success");
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    int timeout = 5000;
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
	      new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(timeout);
	    return clientHttpRequestFactory;
	}
}
