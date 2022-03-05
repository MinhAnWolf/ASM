package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FavoriteDao;
import model.Users;

@WebServlet({ "/pgLoveVi" })
public class FavoriteSvl extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		if (uri.contains("pgLoveVi")) {
			FavoriteDao dao = new FavoriteDao();
			System.out.println("đã vào !!!");
			System.out.println("đã vào pgLoveVi");
			Users model = (Users) request.getSession().getAttribute("userCloud");
			request.setAttribute("listFavorite", dao.findFavorite_fromUser(model.getId()));
			request.getRequestDispatcher("/viewCustomer/customerPage.jsp").forward(request, response);
		}
	}

}
