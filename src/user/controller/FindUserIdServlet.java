package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.face.UserService;
import user.service.impl.UserServiceImpl;

/**
 * Servlet implementation class FindUserIdServlet
 */
@WebServlet("/find/userid")
public class FindUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService=new UserServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/WEB-INF/views/user/join/findid.jsp").forward(req, resp);
		}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			
			PrintWriter out= resp.getWriter();
		
			String email=req.getParameter("email");
			String name=req.getParameter("name");
			
			System.out.println(email+","+name);
			
			int res=userService.selectUserIdByEN(email,name);//일치하는 회원정보가 있는지 조회
			
			System.out.println(res);
			
			if(res==1) {//일치하는 회원정보가 있으면
				String id=userService.getIdByEN(email,name);
				System.out.println(id);
				out.println(id);
			}else {//일치하는 회원정보가 없을떄
				out.println(0);
			}
			
			
		}

}
