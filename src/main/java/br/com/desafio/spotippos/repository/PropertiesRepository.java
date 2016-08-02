package br.com.desafio.spotippos.repository;

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

	public boolean checkIfIsEmpty() {
		Query q = manager.createQuery("SELECT p FROM " + Property.class.getName() + " p limit 1");
		return q.getResultList().isEmpty();
	}

	public List<Property> findByPoints(Integer ax, Integer ay, Integer bx, Integer by) {
		Query q = manager.createQuery("SELECT p FROM " + Property.class.getName() + " p where p.x >= :ax and p.x <= :bx and p.y <= :ay and p.y >= :by");
		q.setParameter("ax", ax);
		q.setParameter("ay", ay);
		q.setParameter("bx", bx);
		q.setParameter("by", by);
		return q.getResultList();
	}
}
