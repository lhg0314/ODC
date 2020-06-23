package artist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import artist.service.face.ArtistClassSalesService;
import artist.service.impl.ArtistClassSalesServiceImpl;
import util.Paging;

//이인주 20200623
// 사업자 클래스 매출 확인
// 클래스 제목 검색으로 결과 보이기
@WebServlet("/artist/classsales/search")
public class ArtistClassSalesSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistClassSalesService artistclasssalesService = new ArtistClassSalesServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사업자로 로그인한 아이디값 가져오기
		HttpSession session = req.getSession();
		
		//세션으로 사업자 아이디값 불러서 변수에 저장하기
		String  artid = (String)session.getAttribute("artid");
		
		//사업자  아이디  jsp로 넘기기
		req.setAttribute("artid", artid);
		
		// 검색한 클래스 이름 파라미터 값 빼오기
		String classname = artistclasssalesService.classnameparam(req);
				
		//검색한 클래스 이름 파라미터 값 넘기기
		req.setAttribute("classname", classname);
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Paging paging = artistclasssalesService.searchgetPaging(req,artid,classname);	
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
						
		//로그인한 사업자  클래스 리스트  전체 조회
		ArrayList<Map<String, Object>> choartsalessearch  = artistclasssalesService.choartsalessearch(artid,classname);
		
		//로그인한 사업자  클래스 리스트  전체 조회 넘기기
		req.setAttribute("choartsalessearch", choartsalessearch);
		
		//사업자  클래스 이름별  수익금
		int searchclassnametotal = artistclasssalesService.searchclassnametotal(artid,classname);
		
		//사업자  클래스 이름별  수익금 넘기기
		req.setAttribute("searchclassnametotal", searchclassnametotal);
		
		req.getRequestDispatcher("/WEB-INF/views/artist/artistpage/class/artclasssearch.jsp").forward(req, resp);
		
	}
}
