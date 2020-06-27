package artist.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import artist.service.face.ArtistClassService;
import artist.service.impl.ArtistClassServiceImpl;
import dto.ArtistInfo;

/**
 * Servlet implementation class ArtistClassApplicationServlet
 */
@WebServlet("/artist/class/app")
public class AritistClassPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArtistClassService artistClassService = new ArtistClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션값으로 로그인 아이디 가져오기
		HttpSession session = req.getSession();
		
		String artId = (String) session.getAttribute("artid");
		
		// 해당 아이디 작가 정보 가져오기
		ArtistInfo artInfo = artistClassService.getArtInfoByArtId(artId);
		
		// 오늘 날짜 전달하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		
		// VIEW 로 전달
		req.setAttribute("artInfo", artInfo);
		req.setAttribute("today", today);
	
		// 포워드
		req.getRequestDispatcher("/WEB-INF/views/artist/class/classApplication.jsp").forward(req, resp);
	 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/artist/class/app post");
		
		// 세션값으로 로그인 아이디 가져오기
		HttpSession session = req.getSession();
		
		String artId = (String) session.getAttribute("artid");
		
		// 해당 아이디 작가 정보 가져오기
		ArtistInfo artInfo = artistClassService.getArtInfoByArtId(artId);
		
		// 클래스 신청 정보 저장하기
		artistClassService.insertClassInfo(req, resp, artInfo);
		
		// 포워드
		req.getRequestDispatcher("/WEB-INF/views/artist/class/appSuccess.jsp").forward(req, resp);
		
		
		
	}

}
