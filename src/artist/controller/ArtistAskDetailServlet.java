package artist.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.service.face.ArtistBoardService;
import artist.service.impl.ArtistBoardServiceImpl;

@WebServlet("/artist/askdetail")
public class ArtistAskDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistBoardService artistBoardService = new ArtistBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/artist/askdetail - [GET]");
		
		int askno = Integer.parseInt(req.getParameter("askno"));
		
		Map<String, Object> askdetail = artistBoardService.selectAskByAskNo(askno);
		
		req.setAttribute("askdetail", askdetail);
		
		System.out.println(askdetail);
		
		req.getRequestDispatcher("/WEB-INF/views/artist/board/askdetail.jsp").forward(req, resp);
		
	}
}
