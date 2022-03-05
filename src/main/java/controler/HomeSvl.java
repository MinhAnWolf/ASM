package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import DAO.FavoriteDao;
import DAO.HistoryDao;
import DAO.UserDao;
import DAO.VideoDao;
import Untils.UpPicture;
import Untils.jpaUts;
import model.Favorites;
import model.Historys;
import model.Users;
import model.Video;

@MultipartConfig
@WebServlet({ "/login", "/register", "/detail", "/like", "/unFavorite", "/ephim", "/indexAdmin", "/updateUser",
		"/create", "/goOut", "/film" })
public class HomeSvl extends HttpServlet {
	UserDao daoUs = new UserDao();
	VideoDao daoVi = new VideoDao();
	FavoriteDao daoFav = new FavoriteDao();
	UpPicture upPic = new UpPicture();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		String method = req.getMethod();
		Users model = new Users();
		String idVid = req.getParameter("id");
		
		if (uri.contains("ephim")) {
			req.setAttribute("title", showVideo());
			req.setAttribute("top4x1", daoVi.videoTop4());
			req.setAttribute("top4x2", daoVi.videoTop4());
			for (Video i : daoVi.videoTop4()) {
				System.out.println("Title : " + i.getTitle());
			}
			req.getRequestDispatcher("/views/indexCinema.jsp").forward(req, resp);
		}
		if (uri.contains("login")) {
			if (method.equalsIgnoreCase("get")) {
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			} else {
				String userName = req.getParameter("email");
				String pass = req.getParameter("password");
				checkLogin(userName, pass, req, resp);
			}
		} else if (uri.contains("register")) {
			if (method.equalsIgnoreCase("get")) {
				req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			} else {
				inserUser(model, req, resp);
//				req.setAttribute("title", showVideo());
//				req.setAttribute("top4x1", daoVi.videoTop4());
//				req.setAttribute("top4x2", daoVi.videoTop4());
//				req.getRequestDispatcher("/views/indexCinema.jsp").forward(req, resp);
//				resp.sendRedirect("/ASM/login");
//				System.out.println("đã vào post");
			}

		} else if (uri.contains("detail")) {
			try {
				HttpSession session = req.getSession();
				Users users = (Users) session.getAttribute("userCloud");
				String on_off = null;
				if (daoFav.findFavorite(users.getId(), idVid) == null) {
					on_off = "on";
				} else {
					on_off = "off";
				}		
				// save lịch sử của người dùng
				HistoryDao daoHis = new HistoryDao();
				if (daoHis.checkVideo(idVid) == true) {
					Video videoModel = daoVi.videoDetail(idVid);
					Historys modelHis = new Historys(users, videoModel, new Date());
					daoHis.create(modelHis);
					req.setAttribute("historyShowDetaile",daoHis.listHistory(users.getId()));
					for (Historys i : daoHis.listHistory(users.getId())) {
						System.out.println("name trong true : "+i.getUsers().getId());
					}
					
				}else {
					req.setAttribute("historyShowDetaile",daoHis.listHistory(users.getId()));
					for (Historys i : daoHis.listHistory(users.getId())) {
						System.out.println("name trong false: "+i.getUsers().getId());
					}
				}
				showDetail(idVid, req, resp, on_off);
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
		} else if (uri.contains("like")) {
			if (method.equalsIgnoreCase("post")) {
				String id = req.getParameter("id");
				System.out.println("id cua bo m : " + id);
				try {
					HttpSession session = req.getSession();
					Users users = (Users) session.getAttribute("userCloud");
					if (daoFav.findFavorite(users.getId(), idVid) == null) {
						System.out.println("đã vào like");
						Video videos = daoVi.videoDetail(idVid);
						daoFav.create(new Favorites(users, videos, new Date()));
						showDetail(idVid, req, resp, "on");
					} else {
						System.out.println("đã vào unlike");
						Favorites oneEnty = daoFav.findFavorite(users.getId(), idVid);
						daoFav.remove(oneEnty);
						showDetail(idVid, req, resp, "off");
					}
				} catch (Exception e) {
					resp.setStatus(400);
				}
			}
		} else if (uri.contains("updateUser")) {
			if (method.equalsIgnoreCase("get")) {
				forwardSp("/view/UpdateUser.jsp", req, resp);
			} else {
				try {
					System.out.println("đã chạy vào update");
					Users modelUs = new Users();
					BeanUtils.populate(modelUs, req.getParameterMap());
					System.out.println("iduS : " + modelUs.getId());
					daoUs.UpdateUser(modelUs);
					forwardSp("/views/indexCinema.jsp", req, resp);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}

			}

		} else if (uri.contains("goOut")) {
			HttpSession session = req.getSession();
			session.removeAttribute("userCloud");
			resp.sendRedirect("/ASM/login");
		}

		// xử lý admin
		if (uri.contains("Admin")) {
			req.setAttribute("listVideo", showVideo());
			forwardSp("/view/AdminForm.jsp", req, resp);
		}

		if (uri.contains("film")) {
			if (method.equalsIgnoreCase("post")) {
				resp.setContentType("text/html;charset=UTF-8");
				resp.setCharacterEncoding("UTF-8");
				String search = req.getParameter("id");
				VideoDao daoVideo = new VideoDao();
				List<Video> list = daoVideo.findVideo(search);
				PrintWriter out = resp.getWriter();

				for (Video o : list) {
					out.println("<div class=\"col-6 col-md-2 py-3\">\r\n"
							+ "								<div class=\"bg-image hover-overlay ripple position-relative\"\r\n"
							+ "									data-mdb-ripple-color=\"light\">\r\n"
							+ "									<img src=\"./imgs/" + o.getPoster() + "\"\r\n"
							+ "										class=\"img-fluid\" />\r\n"
							+ "									<div class=\"mask\"\r\n"
							+ "										style=\"background-color: rgba(251, 251, 251, 0.2)\">\r\n"
							+ "										<a href=\"./detail?id=" + o.getId() + "\"><i\r\n"
							+ "											class=\"far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle\"></i></a>\r\n"
							+ "\r\n" + "									</div>\r\n"
							+ "								</div>\r\n"
							+ "								<a href=\"./detail?id=" + o.getId() + "\"><small\r\n"
							+ "									class=\"text-light py-1\">" + o.getTitle()
							+ "</small></a>\r\n" + "							</div>");
				}
			} else {
				forwardSp("/views/searchFilm.jsp", req, resp);
			}
		}

	}

	// check login
	private void checkLogin(String userName, String passWord, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Users model = daoUs.loginUs(userName, passWord);
			if (model == null) {
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			} else {
				req.getSession().setAttribute("userCloud", model);
				req.setAttribute("title", showVideo());
				req.getAttribute("userCloud");
				req.setAttribute("top4x1", daoVi.videoTop4());
				req.setAttribute("top4x2", daoVi.videoTop4());
				req.getRequestDispatcher("/views/indexCinema.jsp").forward(req, resp);
				model = null;
			}

		} catch (Exception e) {
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}

	}

	// inser User
	private void inserUser(Users model, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			BeanUtils.populate(model, req.getParameterMap());
			daoUs.create(model);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		} catch (IllegalAccessException | InvocationTargetException e) {
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		}

	}

	// show video
	private List<Video> showVideo() {
		TypedQuery<Video> query = jpaUts.getEntityManager().createNamedQuery("fillVideo", Video.class);
		List<Video> list = query.getResultList();
		return list;
	}

	// show detail

	private void showDetail(String idVid, HttpServletRequest req, HttpServletResponse resp, String on_off)
			throws ServletException, IOException {
		System.out.println("chạy vào showDetail rồi nè");
		VideoDao daoViD = new VideoDao();
		req.setAttribute("itemVid", daoViD.videoDetail(idVid));
		req.setAttribute("cardVid", daoViD.videoTop());
		req.setAttribute("on_off", on_off);
		req.getRequestDispatcher("/views/detailVideo.jsp").forward(req, resp);
	}

	// forword Support

	private void forwardSp(String uri, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(uri).forward(req, resp);
	}

}
