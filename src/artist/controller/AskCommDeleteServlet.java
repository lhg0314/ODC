package artist.controller;
/**
 * 
 * 문의게시판 댓글 삭제
 * 박주이 200629
 * 완성
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
/**
 * 
 * 문의게시판 댓글 삭제
 * @author 박주이 200629
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.service.face.ArtistBoardService;
import artist.service.impl.ArtistBoardServiceImpl;
import dto.AskBoardComm;
@WebServlet("/artist/cdelete")
public class AskCommDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistBoardService artistBoardService = new ArtistBoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int commNo = Integer.parseInt( (String)req.getParameter("commentNo") );
		
		boolean success = artistBoardService.deleteComm(commNo);
		
		resp.getWriter().append("{\"success\":"+success+"}");
		
	}
}
