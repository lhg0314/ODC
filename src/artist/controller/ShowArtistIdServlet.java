package artist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowArtistIdServlet
 */
@WebServlet("/show/artistid")
public class ShowArtistIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String) req.getParameter("id");
		req.setAttribute("id", id);
		System.out.println("userid="+id);
		
		req.getRequestDispatcher("/WEB-INF/views/artist/join/showid.jsp").forward(req, resp);
	}

}
