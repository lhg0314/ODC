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
//사업자 페이지 
//클래스 - 클래스 매출 현황
@WebServlet("/artistpage/class/sales")
public class ArtistPageClassSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistClassSalesService artistclasssalesService = new ArtistClassSalesServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/artistpage/class/sales [GET]");
	
		//사업자로 로그인한 아이디값 가져오기
		HttpSession session = req.getSession();
		
		//세션으로 사업자 아이디값 불러서 변수에 저장하기
		String  artid = (String)session.getAttribute("artid");
		
		//사업자  아이디  jsp로 넘기기
		req.setAttribute("artid", artid);
		
		//현재 달 
		Date[] artnowday = artistclasssalesService.nowyearday();
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Paging paging = artistclasssalesService.getPaging(req,artid,artnowday);	
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
						
		//로그인한 사업자  클래스 리스트  전체 조회
		ArrayList<Map<String, Object>> nowartsales  = artistclasssalesService.nowartsales(paging,artid,artnowday);
		
		//로그인한 사업자  클래스 리스트  전체 조회 넘기기
		req.setAttribute("nowartsales", nowartsales);
		
		//사업자 별 현재 달 총 수익금
		int nowartsalestot = artistclasssalesService.nowartsalestot(artid,artnowday);
		
		//사업자 별 현재 달 총 수익금 넘기기
		req.setAttribute("nowartsalestot", nowartsalestot);
				
		req.getRequestDispatcher("/WEB-INF/views/artist/artistpage/class/artsales.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사업자로 로그인한 아이디값 가져오기
		HttpSession session = req.getSession();
		
		//세션으로 사업자 아이디값 불러서 변수에 저장하기
		String  artid = (String)session.getAttribute("artid");
		
		//사업자  아이디  jsp로 넘기기
		req.setAttribute("artid", artid);
		
		//선택 월 기준
		int month = artistclasssalesService.getparmmonth(req);
		
		//달  넘기기
		req.setAttribute("month", month);	
		
		//선택 월 기준
		Date[] chooseyearday = artistclasssalesService.chooseyearday(month);
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Paging paging = artistclasssalesService.chogetPaging(req,artid,chooseyearday);	
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
						
		//로그인한 사업자  클래스 리스트  전체 조회
		ArrayList<Map<String, Object>> choartsales  = artistclasssalesService.choartsales(paging,artid,chooseyearday);
		
		//로그인한 사업자  클래스 리스트  전체 조회 넘기기
		req.setAttribute("choartsales", choartsales);
		
		//사업자 별 현재 달 총 수익금
		int choartsalestot = artistclasssalesService.choartsalestot(artid,chooseyearday);
		
		//사업자 별 현재 달 총 수익금 넘기기
		req.setAttribute("choartsalestot", choartsalestot);
		
		req.getRequestDispatcher("/WEB-INF/views/artist/artistpage/class/artclasscho.jsp").forward(req, resp);
	}

}
