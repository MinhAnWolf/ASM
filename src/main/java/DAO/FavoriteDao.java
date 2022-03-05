package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import Untils.jpaUts;
import model.Favorites;
import model.Reports;
import model.Users;
import model.Video;

public class FavoriteDao {
	static EntityManager em = jpaUts.getEntityManager();

	public void create(Favorites model) {
		em.getTransaction().begin();
		em.persist(model);
		em.getTransaction().commit();
	}

	public List<Favorites> findlistFav(String idu, String vid) {
		String sql = "select o from Favorites o where o.user.id=:idu and o.video.id=:vid";
		TypedQuery<Favorites> query = em.createQuery(sql, Favorites.class);
		query.setParameter("idu", idu);
		query.setParameter("vid", vid);
		return query.getResultList();
	}

	public Favorites findFavorite(String idu, String vid) {
		Favorites model = new Favorites();
		String sql = "select o from Favorites o where o.user.id=:idu and o.video.id=:vid";
		TypedQuery<Favorites> query = em.createQuery(sql, Favorites.class);
		query.setParameter("idu", idu);
		query.setParameter("vid", vid);
		try {
			model = query.getSingleResult();
		} catch (NoResultException nre) {
			model = null;
		}
		return model;
	}

	public List<Favorites> findFavorite_fromUser(String idU) {
		String sql = "select o from Favorites o where o.user.id=:idu";
		TypedQuery<Favorites> query = em.createQuery(sql, Favorites.class);
		query.setParameter("idu", idU);
		List<Favorites> list = query.getResultList();
		return list;
	}

	public void remove(Favorites model) {
		em.getTransaction().begin();
		em.remove(model);
		em.getTransaction().commit();
	}
	
	// show trong thống kê
	public List<Reports> countUserLikeVideo(){
		String sql = "select  new Reports(o.video.Title,COUNT(o.user.id) ,o.LikeDate) from Favorites o"
				+ " group by o.LikeDate, o.video.Title";
		TypedQuery<Reports> query = em.createQuery(sql,Reports.class);
		List<Reports> list = query.getResultList();
		return list;
	}
	
	public static void main(String[] args) {
		FavoriteDao dao = new FavoriteDao();
		List<Reports> list = dao.countUserLikeVideo();
		for (Reports i : list) {
			System.out.println("user : "+i.getCount());
			System.out.println("video : "+i.getGroup());
		}
	}
	
}
