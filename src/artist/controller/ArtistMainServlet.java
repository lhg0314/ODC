package artist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/artist/main")
public class ArtistMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		
		System.out.println(session.getAttribute("artid"));
		if(session.getAttribute("artid")==null) {//작가가 로그인을 안했을때
			req.getRequestDispatcher("/WEB-INF/views/artist/artistpage/noLoginArtist.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/WEB-INF/views/artist/artistpage/artistpage.jsp").forward(req, resp);
		}
	}
}
