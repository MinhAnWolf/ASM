package controler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDao;
import model.Users;

@MultipartConfig
@WebServlet({"/profileU","/showUs","/Udelete_u"})
public class UserSvl extends HttpServlet{
		UserDao daoU = new UserDao();
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("utf-8");
			
			String uri = req.getRequestURI();
			String idU = req.getParameter("id");
			String method = req.getMethod();
			List<Users> list;
			if (uri.contains("profileU")) {
				list = daoU.listUser_full();
				req.setAttribute("itemsU",list);
				req.getRequestDispatcher("/view/editUser.jsp").forward(req, resp);
			}
			if (uri.contains("showUs")) {
				Users model = daoU.findOneUser(idU);
				if(method.equalsIgnoreCase("get")) {
					System.out.println("idU : "+idU);				
					System.out.println("fullname : "+model.getFullname());
					req.setAttribute("id",model.getId());
					req.setAttribute("email",model.getEmail());
					req.setAttribute("password",model.getPassword());
					req.setAttribute("fullname",model.getFullname());
					req.setAttribute("admin",model.isAdmin());
					 list = daoU.listUser_full();
					req.setAttribute("itemsU",list);
					req.getRequestDispatcher("/view/editUser.jsp").forward(req, resp);
				}
				else{
						try {
							BeanUtils.populate(model,req.getParameterMap());
							daoU.UpdateUser(model);
							 list = daoU.listUser_full();							
							req.setAttribute("itemsU",list);
							req.getRequestDispatcher("/view/editUser.jsp").forward(req, resp);
						} catch (IllegalAccessException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				}
			}else if (uri.contains("Udelete_u")) {
				Users model = daoU.findOneUser(idU);
				daoU.remove(model);
				 list = daoU.listUser_full();
				req.setAttribute("itemsU",list);
				req.getRequestDispatcher("/view/editUser.jsp").forward(req, resp);
			}

		}
		
}
