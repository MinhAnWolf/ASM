package DAO;

import javax.persistence.EntityManager;

import Untils.jpaUts;
import model.Shares;

public class ShareDao  {
	
	EntityManager em = jpaUts.getEntityManager();
	
	public void create(Shares model) {
		em.getTransaction().begin();
		em.persist(model);
		em.getTransaction().commit();
	}
	
}
