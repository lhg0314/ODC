package artist.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import artist.service.face.ArtistBoardService;
import artist.service.impl.ArtistBoardServiceImpl;
import util.Paging;
/**
 * 
 * 작가페이지 - 문의게시판 리스트 출력
 * @author 200625 박주이
 * 완성
 *
 */
@WebServlet("/artist/asklist")
public class ArtistAskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistBoardService artistBoardService = new ArtistBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/artist/asklist - [GET]");
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("artid") == null) {
			resp.sendRedirect("/member/login");
			return;
		}
		
		String artid = (String) session.getAttribute("artid");
		
		int artno = artistBoardService.getArtNoById(artid);
		
		Paging paging = artistBoardService.getPagingAskByArtNo(req, artno);
		
		List<Map<String, Object>> list = artistBoardService.selectAskByArtNo(paging, artno);
		
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/artist/board/asklist.jsp").forward(req, resp);
		
	}
}
