package artist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.service.face.ArtistBoardService;
import artist.service.impl.ArtistBoardServiceImpl;
import dto.AskBoardComm;
/**
 * 
 * 작가페이지 - 문의게시판 댓글 작성
 * @author 박주이
 *
 */
@WebServlet("/askcomm/insert")
public class AskCommInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistBoardService artistBoardService = new ArtistBoardServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AskBoardComm comm = artistBoardService.getComment(req);
		
		artistBoardService.insertComment(comm);
		
//		System.out.println(comm);
		
		resp.sendRedirect("/artist/askdetail?askno="+comm.getAskBoardno());
	}
}
