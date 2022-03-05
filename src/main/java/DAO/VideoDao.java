package DAO;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Untils.jpaUts;
import model.Video;

public class VideoDao {
		EntityManager em = jpaUts.getEntityManager();
		
		public Video videoDetail(String idVideo){
			 Video model = em.find(Video.class, idVideo);
			 return model;
		}
		
		public List<Video> videoTop(){
			String sql = "select top 3 * from video order by newid()";
			Query query = em.createNativeQuery(sql,Video.class);
			return query.getResultList();
		}
		
		public List<Video> videoTop4(){
			String sql = "select top 4 * from video order by newid()";
			Query query = em.createNativeQuery(sql,Video.class);
			return query.getResultList();
		}
		
		public List<Video> findVideo(String key){
			String sql = "select o from Video o where o.Title like :title";
			TypedQuery<Video> query = em.createQuery(sql,Video.class);
			query.setParameter("title","%"+key+"%");
			return query.getResultList();
		}
		
		public void create(Video model) {
			em.getTransaction().begin();
			em.persist(model);
			em.getTransaction().commit();
		}
		
		public void update(Video model) {
			em.getTransaction().begin();
			em.merge(model);
			em.getTransaction().commit();
		}
		
		public void delete(Video model) {
			em.getTransaction().begin();
			em.remove(model);
			em.getTransaction().commit();
		}
		public static void main(String[] args) {
			VideoDao s = new VideoDao();
			for (Video i : s.findVideo("Vua")) {
					System.out.println("tiêu đề vidoe : "+i.getTitle());
			}
		}
}
