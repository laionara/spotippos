package br.com.desafio.spotippos.service;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.spotippos.manager.ProvincesManager;
import br.com.desafio.spotippos.model.Point;
import br.com.desafio.spotippos.model.PropertiesResponse;
import br.com.desafio.spotippos.model.Property;
import br.com.desafio.spotippos.model.Province;
import br.com.desafio.spotippos.model.ProvincesResponse;
import br.com.desafio.spotippos.repository.PropertiesRepository;

@Service
public class PropertiesService {
	
	@Autowired
	private PropertiesRepository propertiesDAO;

	/*
	 * Consulta um imóvel a partir do id  
	 */
	public Property findById(Long id) {
		Property property = propertiesDAO.findById(id);	
		if(property != null) {
			List<String> provinceList = getOwnProvinces(property.getX(), property.getY());
			property.setProvinces(provinceList);
		}
		return property;
	}
	
	public boolean save(Property property){
		return propertiesDAO.save(property);
	}
	
	public void save(PropertiesResponse propertiesResponse){
		
		for(Property property: propertiesResponse.getProperties()){
			propertiesDAO.save(property);
		}
	}
	
	/*
	 * Obtem uma instância do objeto provincia e verifica em qual delas o imóvel está contido  
	 */
	private List<String> getOwnProvinces(int x, int y) {
		List<String> provinceList = new ArrayList<String>();
		
		ProvincesResponse provinces = ProvincesManager.getInstance().getProvinces();
		if(verifyProvinceContainsPoint(provinces.getGode(), x, y))
			provinceList.add("Gode");
		if(verifyProvinceContainsPoint(provinces.getGroola(), x, y))
			provinceList.add("Groola");
		if(verifyProvinceContainsPoint(provinces.getJaby(), x, y))
			provinceList.add("Jaby");
		if(verifyProvinceContainsPoint(provinces.getNova(), x, y))
			provinceList.add("Nova");
		if(verifyProvinceContainsPoint(provinces.getRuja(), x, y))
			provinceList.add("Ruja");
		if(verifyProvinceContainsPoint(provinces.getScavy(), x, y))
			provinceList.add("Scavy");
		return provinceList;
	}
	
	/*
	 * Cria um retângulo de acordo com pontos superior esquerdo e inferior direito da provincia 
	 * e verifica se o imóvel está contido nesta região.  
	 */
	private boolean verifyProvinceContainsPoint(Province province, int x, int y) {
		Point ul = province.getBoundaries().getUpperLeft();
		Point br = province.getBoundaries().getBottomRight();
		
		Rectangle rectangle = new Rectangle(ul.getX(), br.getY(), 
				br.getX() - ul.getX(), ul.getY() - br.getY());

		return rectangle.contains(x, y);
	}
	
	public boolean hasProperties(){
		return !this.propertiesDAO.checkIfIsEmpty();
	}

	/*
	 * Identifica os imóveis contidos em determinada região e obtem a provincia referente
	 */
	public List<Property> findByPoints(Integer ax, Integer ay, Integer bx, Integer by) {
		List<Property> properties = propertiesDAO.findByPoints(ax, ay, bx, by);
		for(Property property: properties){
			List<String> provinces = this.getOwnProvinces(property.getX(), property.getY());
			property.setProvinces(provinces);
		}
		return properties;
	}
	
}
