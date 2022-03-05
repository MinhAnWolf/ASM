package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Untils.jpaUts;
import model.Historys;

public class HistoryDao {

	EntityManager em = jpaUts.getEntityManager();

	public List<Historys> listHistory(String idU) {
		String sql = "select o from Historys o where o.users.id =:idU";
		TypedQuery<Historys> query = em.createQuery(sql, Historys.class);
		query.setParameter("idU", idU);
		return query.getResultList();
	}

	public void create(Historys model) {
		em.getTransaction().begin();
		em.persist(model);
		em.getTransaction().commit();
	}

	public boolean checkVideo(String idV) {
		boolean check;
		String sql = "select o from Historys o where o.video.id =:idV ";
		TypedQuery<Historys> query = em.createQuery(sql, Historys.class);
		query.setParameter("idV", idV);
		List<Historys> list = query.getResultList();
		if (list.isEmpty()) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public static void main(String[] args) {
		HistoryDao his = new HistoryDao();

		System.out.println("check : " + his.checkVideo("oFDiafRcOcA"));

	}

}
