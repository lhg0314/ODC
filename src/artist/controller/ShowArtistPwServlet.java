package artist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowArtistPwServlet
 */
@WebServlet("/show/artistpw")
public class ShowArtistPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pw=(String) req.getParameter("pw");
		req.setAttribute("pw", pw);
		
		req.getRequestDispatcher("/WEB-INF/views/artist/join/showpw.jsp").forward(req, resp);
		}

}
