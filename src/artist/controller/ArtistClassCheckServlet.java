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

import artist.service.face.ArtistClassService;
import artist.service.impl.ArtistClassServiceImpl;
import dto.ArtistInfo;
import dto.ClassInfo;

@WebServlet("/artist/class/check")
public class ArtistClassCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArtistClassService artistClassService = new ArtistClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String artId = (String) session.getAttribute("artid");
		
		// 해당 아이디 작가 정보 가져오기
		ArtistInfo artInfo = artistClassService.getArtInfoByArtId(artId);
		
		// artno로 검토 클래스 정보 가져오기
		List<Map<String, Object>> list = artistClassService.selectAllClassCheck(artInfo.getArtno());
	
		// list data VIEW 로 넘겨주기
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/artist/class/classCheck.jsp").forward(req, resp);
	
	}

}
