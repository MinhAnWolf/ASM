package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FavoriteDao;
import DAO.ThongkeDao;
import model.Favorites;
import model.Reports;

@WebServlet({ "/thongke", "/search","/ss" })
public class ThongKeSvl extends HttpServlet {
	FavoriteDao reportDao = new FavoriteDao();
	ThongkeDao daoTk = new ThongkeDao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String method = req.getMethod();

		if (uri.contains("thongke")) {

			req.setAttribute("listThongKe", reportDao.countUserLikeVideo());
			req.getRequestDispatcher("/view/ThongKePage.jsp").forward(req, resp);

		}

		if (uri.contains("search")) {
			if (method.equalsIgnoreCase("post")) {
				req.setAttribute("listThongKe", reportDao.countUserLikeVideo());
				String keySearch = req.getParameter("keySearch");
				req.setAttribute("search", daoTk.UsFrom_idVi(keySearch));
				req.getRequestDispatcher("/view/ThongKePage.jsp").forward(req, resp);
				for (Favorites i : daoTk.UsFrom_idVi(keySearch)) {
					System.out.println("username : " + i.getLikeDate().toString());
				}
			}
		}

		if (uri.contains("ss")) {
			if (method.equalsIgnoreCase("post")) {
				req.setAttribute("listThongKe", reportDao.countUserLikeVideo());
				String keySearch = req.getParameter("keyShare");
				req.setAttribute("share", daoTk.findUs_fromShare(keySearch));
				req.getRequestDispatcher("/view/ThongKePage.jsp").forward(req, resp);
			}
		}
	}

}
