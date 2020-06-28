package artist.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.service.face.ArtistBoardService;
import artist.service.impl.ArtistBoardServiceImpl;
import dto.AskBoardComm;

@WebServlet("/artist/reviewdetail")
public class ArtistReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistBoardService artistBoardService = new ArtistBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int reviewno = Integer.parseInt(req.getParameter("askno"));
		
		Map<String, Object> reviewdetail = artistBoardService.selectReviewByReviewNo(reviewno);
		
		req.setAttribute("reviewdetail", reviewdetail);
		
		req.getRequestDispatcher("/WEB-INF/views/artist/board/askdetail.jsp").forward(req, resp);
	
	}

}
