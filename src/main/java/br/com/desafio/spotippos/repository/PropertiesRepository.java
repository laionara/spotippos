package br.com.desafio.spotippos.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.desafio.spotippos.model.Properties;

@Repository
public class PropertiesRepository {

	@PersistenceContext
	private EntityManager manager;
	
	public Properties save(Properties properties){
		manager.persist(properties);
		return properties;
	}
	
	public Properties update(Properties properties){
		manager.merge(properties);
		return properties;
	}
	
	public Properties findById(Long id) {
		try {
			Query q = manager.createQuery("SELECT a FROM Properties a where a.id = :id");
			q.setParameter("id", id);
			Properties properties = (Properties) q.getSingleResult();
			return properties;
		} catch (NoResultException e) {
			return null;
		}
	}
}
