package Untils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VideoDao;
import model.Users;
import model.Video;

/**
 * Servlet Filter implementation class FilterUntils
 */
@WebFilter({"/ephim","/indexAdmin","/detail"})
public class FilterUntils extends HttpFilter implements Filter {
	VideoDao daoVid = new VideoDao();
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		Users users = (Users) request.getSession().getAttribute("userCloud");
		System.out.println("uri : "+uri);
		if (uri.contains("ephim")) {
			if (users == null) {
				System.out.println("đã vào filter");
				response.sendRedirect("/ASM/login");
			}else {
				System.out.println("đã vào filter ephim");
				chain.doFilter(request, response);
			}
		}

		if (uri.contains("indexAdmin")) {
			if (users.isAdmin() == true) {
				chain.doFilter(request, response);
			}else {
				response.sendRedirect("/ASM/ephim");
			}
		}
		
		if (uri.contains("detail")) {
			String id = request.getParameter("id");
			System.out.println("id filter from video : "+id);
			Video modelVideo = daoVid.videoDetail(id);
			int count = modelVideo.getViews();
			count++;
			Video model = new Video(id,modelVideo.getTitle(),modelVideo.getPoster(),
				count,modelVideo.getDescription(),modelVideo.isActive());
			daoVid.update(model);
			chain.doFilter(request, response);

			
		}
	}
	
	
}
