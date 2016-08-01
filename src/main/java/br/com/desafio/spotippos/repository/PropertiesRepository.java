package br.com.desafio.spotippos.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafio.spotippos.model.Property;

@Repository
public class PropertiesRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional(readOnly = false)
	public boolean save(Property property){
		return manager.merge(property) != null;
	}
	
	public Property update(Property properties){
		manager.merge(properties);
		return properties;
	}
	
	public Property findById(Long id) {
		try {
			Query q = manager.createQuery("SELECT p FROM " + Property.class.getName() + " p where p.id = :id");
			q.setParameter("id", id);
			Property property = (Property) q.getSingleResult();
			return property;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Property> findAll() {
		List<Property> properties = new ArrayList<Property>();
		Query q = manager.createQuery("SELECT p FROM " + Property.class.getName() + " p ");
		properties= q.getResultList();
		return properties;
	}
}
