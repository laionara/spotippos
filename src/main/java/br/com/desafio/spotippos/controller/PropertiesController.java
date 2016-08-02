package br.com.desafio.spotippos.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.desafio.spotippos.manager.ProvincesManager;
import br.com.desafio.spotippos.model.PropertiesResponse;
import br.com.desafio.spotippos.model.Property;
import br.com.desafio.spotippos.model.ProvincesResponse;
import br.com.desafio.spotippos.model.Response;
import br.com.desafio.spotippos.service.PropertiesService;



@Controller
@Transactional
@RequestMapping("/properties")
public class PropertiesController {

	@Autowired
	private PropertiesService propertiesService;
	
	@RequestMapping(method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody Response include(@RequestBody Property property) {
		Response response = new Response();
		response.setSuccess(false);
		
		String errorMsg = validateProperty(property);
		if(errorMsg != null)
			response.setMessage(errorMsg);
		else if(this.propertiesService.save(property))
			response.setSuccess(true);
		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody Property getProperty(@PathVariable Long id) {
		return this.propertiesService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody PropertiesResponse findByPoints(@RequestParam(value="ax") Integer ax, @RequestParam(value="ay") Integer ay, @RequestParam(value="bx") Integer bx, @RequestParam(value="by") Integer by) {
		PropertiesResponse propertiesResponse = new PropertiesResponse();
		List<Property> properties = this.propertiesService.findByPoints(ax, ay, bx, by);
		propertiesResponse.setPropertiesList(properties);
		propertiesResponse.setTotalProperties(properties.size());
		return propertiesResponse;
		
	}
	
	private String validateProperty(Property property){
		if(property.getX() < 0 || property.getX() > 1400)
			return "X value not allowed";
		else if(property.getY() < 0 || property.getY() > 1400)
			return "Y value not allowed";
		else if(property.getBeds() < 1 || property.getBeds() > 5)
			return "Number of Beds not allowed";
		else if(property.getBaths() < 1 || property.getBaths() > 4)
			return "Number of Baths not allowed";
		else if(property.getSquareMeters() < 20 || property.getSquareMeters() > 240)
			return "Square meters value not allowed";
		return null;
	}
	
	private @ResponseBody boolean save(PropertiesResponse propertiesResponse) {
		Response response = new Response();
		if(propertiesResponse != null){
			propertiesService.save(propertiesResponse);
			response.setSuccess(true);
		}
		return response.isSuccess();
	}

	/**
	 * Para preencher os properties 
	 */
	@PostConstruct
	@RequestMapping(value = "/init", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody Response init(){
		Response response = new Response();
		String propertiesUrl = "https://raw.githubusercontent.com/VivaReal/code-challenge/master/properties.json";
		String provincesUrl = "https://raw.githubusercontent.com/VivaReal/code-challenge/master/provinces.json";
		
		Gson gson = new Gson();        
		RestTemplate restTemplate = new RestTemplate();
		String provincesJSON = restTemplate.getForObject(provincesUrl, String.class);
		new ProvincesManager(gson.fromJson(provincesJSON, ProvincesResponse.class));
		response.setSuccess(true);
		if(!this.propertiesService.hasProperties()){
	    	String propertiesJSON = restTemplate.getForObject(propertiesUrl, String.class);
	    	PropertiesResponse propertiesResponse = gson.fromJson(propertiesJSON, PropertiesResponse.class);
	    	response.setSuccess(this.save(propertiesResponse));
		}
        
		return response;
	}	
}