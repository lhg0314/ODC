package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowFindPwServlet
 */
@WebServlet("/show/pw")
public class ShowFindPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pw=(String) req.getParameter("pw");
		req.setAttribute("pw", pw);
		//System.out.println("userpw="+pw);
		
		req.getRequestDispatcher("/WEB-INF/views/user/join/showPw.jsp").forward(req, resp);
	}
}
