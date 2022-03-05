package controler;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ShareDao;
import DAO.VideoDao;
import Untils.Mail;
import model.*;

@WebServlet({ "/send","/share" })
public class ShareSvl extends HttpServlet {
	VideoDao daoVi = new VideoDao();
	ShareDao daoSh = new ShareDao();
	Mail sendMail = new Mail();
	HomeSvl home = new HomeSvl();
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		System.out.println("uri : "+uri);
//		String idVid = req.getParameter("id");
//		System.out.println("idVid : " + idVid);
		String method = req.getMethod();

		if (uri.contains("send")) {
			if (method.equalsIgnoreCase("post")) {
//				System.out.println("id : "+req.getParameter("vid"));
//				System.out.println("sb : "+req.getParameter("subject"));
//				System.out.println("to : "+req.getParameter("to"));
//				System.out.println("ct : "+req.getParameter("content"));
				String idVid = req.getParameter("vid");
				Users user = (Users) req.getSession().getAttribute("userCloud");
				Video modelVi = daoVi.videoDetail(idVid);
				System.out.println("title video nè ô nội : " + modelVi.getTitle());
				daoSh.create(new Shares(user, modelVi, user.getEmail(), new Date()));
				resp.sendRedirect("/ASM/detail?id=" + idVid);
				String subject = req.getParameter("subject");
				String to = req.getParameter("to");
				String content = req.getParameter("content");
				sendMail.sendMail(req, resp,to,subject,content);
			}
		}
	}
}
