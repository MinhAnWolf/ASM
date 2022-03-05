package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Untils.jpaUts;
import model.Favorites;
import model.Reports;
import model.Shares;

public class ThongkeDao  {
	EntityManager em = jpaUts.getEntityManager();
	
	public List<Favorites> UsFrom_idVi(String title){
		String sql = "select distinct o from Favorites o "
				+ " where o.video.Title Like :title ";
		TypedQuery<Favorites> query = em.createQuery(sql,Favorites.class);
		query.setParameter("title","%"+title+"%");
		List<Favorites> list = query.getResultList();
		return list;
	}
	
	public List<Shares> findUs_fromShare(String title){
		String sql = "select distinct o from Shares o "
				+ " where o.video.Title Like :title";
		TypedQuery<Shares> query = em.createQuery(sql,Shares.class);
		query.setParameter("title","%"+title+"%");
		List<Shares> list = query.getResultList();
		return list;
	}
	
//	public static void main(String[] args) {
//			ThongkeDao dao = new ThongkeDao();
//			System.out.println("tạo hàm main");
//			for (Shares i : dao.findUs_fromShare("22")) {
//			System.out.println("đã vào foreach");
//					System.out.println("username : "+i.getUser().getId());
//			}
//			System.out.println("kết thúc hàm main");
//	}
}
