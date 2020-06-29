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
import dto.ClassFile;

@WebServlet("/artist/class/update")
public class ArtistClassUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArtistClassService artistClassService = new ArtistClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int classno = 0;
		
		String cn = req.getParameter("classno");
		if( cn != null && !"".equals(cn)) {
			classno = Integer.parseInt(cn);
		}
		
		// 선택한 클래스 상세 정보
		Map<String, Object> map = artistClassService.selectClassByClassNo(classno);
		List<ClassFile> detailFile = artistClassService.selectDetailFileByClassno(classno);
		
		req.setAttribute("info", map);
		req.setAttribute("detailFile", detailFile);
	
		// 포워드
		req.getRequestDispatcher("/WEB-INF/views/artist/class/artistClassView.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 세션값으로 로그인 아이디 가져오기
		HttpSession session = req.getSession();
		
		String artId = (String) session.getAttribute("artid");
		
		// 해당 아이디 작가 정보 가져오기
		ArtistInfo artInfo = artistClassService.getArtInfoByArtId(artId);
		
		// 클래스 신청 정보 저장하기
		artistClassService.updateClassInfo(req, resp);
		
		// 리다이렉트
		resp.sendRedirect("/artist/class/manage");
	
	
	
	
	}

}
