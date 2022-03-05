package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Untils.jpaUts;
import model.Favorites;
import model.Users;

public class UserDao  {
		EntityManager em = jpaUts.getEntityManager();	

		public Users loginUs(String userName,String passWord) {
			String sql = "select o from Users o where o.Email=:email and o.Password=:pass";
			TypedQuery<Users> query = em.createQuery(sql,Users.class);
			query.setParameter("email",userName);
			query.setParameter("pass",passWord);
			Users model = query.getSingleResult();
			return model;
		}
		
		public void create(Users model) {
			em.getTransaction().begin();
			em.persist(model);
			em.getTransaction().commit();
		}
		
		public Users findOneUser(String id) {
			Users model = em.find(Users.class, id);
			return model;
		}
		
		public void UpdateUser(Users model) {
			em.getTransaction().begin();
			em.merge(model);
			em.getTransaction().commit();
		}
		
		public List<Users> listUser_full(){
			String sql = "select o from Users o";
			TypedQuery<Users> query = em.createQuery(sql,Users.class);
			return query.getResultList();
		}
		
		public void remove(Users model) {
			em.getTransaction().begin();
			em.remove(model);
			em.getTransaction().commit();
		}
}
