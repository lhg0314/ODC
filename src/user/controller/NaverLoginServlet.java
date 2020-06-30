package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/naver/login")
public class NaverLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String email=req.getParameter("email");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		
		session.setAttribute("userid", id);
		//System.out.println(email);
		//System.out.println(name);
		//System.out.println(id);
		
		resp.sendRedirect("/main");
		
		
	}
}
