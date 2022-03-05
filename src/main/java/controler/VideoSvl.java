package controler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.FavoriteDao;
import DAO.ShareDao;
import DAO.UserDao;
import DAO.VideoDao;
import Untils.Mail;
import Untils.UpPicture;
import Untils.jpaUts;
import model.Shares;
import model.Users;
import model.Video;

@MultipartConfig
@WebServlet({ "/editV", "/RemoveV", "/new", "/Uvideo" })
public class VideoSvl extends HttpServlet {

	UserDao daoUs = new UserDao();
	VideoDao daoVi = new VideoDao();
	FavoriteDao daoFav = new FavoriteDao();
	UpPicture upPic = new UpPicture();
	// bỏ đở hôm, chừng rãnh fix tiếp (đem qua share)
	ShareDao daoSh = new ShareDao();
	Mail sendMail = new Mail();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");

		String uri = req.getRequestURI();
		String method = req.getMethod();
		Users model = new Users();
		String idVid = req.getParameter("id");
		if (uri.contains("editV")) {
			Video modelVi = daoVi.videoDetail(idVid);
			req.setAttribute("id", modelVi.getId());
			req.setAttribute("title", modelVi.getTitle());
			req.setAttribute("views", modelVi.getViews());
			req.setAttribute("description", modelVi.getDescription());
			req.setAttribute("active", modelVi.isActive());
			req.setAttribute("poster", modelVi.getPoster());
			req.setAttribute("listVideo", showVideo());
//				daoVi.update(modelVi);
			forwardSp("/view/AdminForm.jsp", req, resp);
		} else if (uri.contains("RemoveV")) {
			Video modelVi = daoVi.videoDetail(idVid);
			req.setAttribute("listVideo", showVideo());
			daoVi.delete(modelVi);
			forwardSp("/view/AdminForm.jsp", req, resp);
		} else if (uri.contains("new")) {
			if (method.equalsIgnoreCase("post")) {
				String id = req.getParameter("id");
				String title = req.getParameter("title");
				int views = Integer.parseInt(req.getParameter("views"));
				String description = req.getParameter("description");
				Boolean active = Boolean.parseBoolean(req.getParameter("active"));
				String poster = upPic.Up(req, resp);
				Video video = new Video(id, title, poster, views, description, active);
				daoVi.create(video);
				req.setAttribute("listVideo", showVideo());
				forwardSp("/view/AdminForm.jsp", req, resp);
			}
		} else if (uri.contains("/Uvideo")) {
			if (method.equalsIgnoreCase("post")) {
				String id = req.getParameter("id");
				String title = req.getParameter("title");
				int views = Integer.parseInt(req.getParameter("views"));
				String description = req.getParameter("description");
				Boolean active = Boolean.parseBoolean(req.getParameter("active"));
				try {
					String poster = upPic.Up(req, resp);
					Video modelVideo = new Video(id, title, poster, views, description, active);
					daoVi.update(modelVideo);
					req.setAttribute("listVideo", showVideo());
					resp.sendRedirect("/ASM/indexAdmin");
				} catch (FileNotFoundException e) {
					req.setAttribute("mess","xin lỗi ảnh này đã có được sử dung T_T ");
				}
			}
		}
	}

	private void forwardSp(String uri, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher(uri).forward(req, resp);
	}

	private List<Video> showVideo() {
		TypedQuery<Video> query = jpaUts.getEntityManager().createNamedQuery("fillVideo", Video.class);
		List<Video> list = query.getResultList();
		return list;
	}
}
