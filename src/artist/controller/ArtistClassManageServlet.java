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
import util.Paging;

@WebServlet("/artist/class/manage")
public class ArtistClassManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArtistClassService artistClassService = new ArtistClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String artId = (String) session.getAttribute("artid");
		
		// 해당 아이디 작가 정보 가져오기
		ArtistInfo artInfo = artistClassService.getArtInfoByArtId(artId);
		
		// 요청 파라미터를 전달하여 Paging 객체 생성하기
		Paging paging = artistClassService.getPagingClassManage(req, artInfo.getArtno());
//		System.out.println("BoardListController =" + paging);
		
		// DB에서 클래스 정보 꺼내오기
//		map = adminService.selectAllClass();
		List<Map<String, Object>> list = artistClassService.selectAllClass(paging, artInfo.getArtno() );
		
//		System.out.println(map);
		// list data VIEW 로 넘겨주기
		req.setAttribute("list", list);
		// Paging 처리 결과 Model 값 전달
		req.setAttribute("paging", paging);
		
		req.getRequestDispatcher("/WEB-INF/views/artist/class/classManage.jsp").forward(req, resp);
		
	}
	
}
