package admin.controller;

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

import admin.service.face.AdminSalesServlce;
import admin.service.impl.AdminSalesServiceImpl;
import util.Paging;

//사업자 검색 후 월 선택 총수익
//이인주 20200621
@WebServlet("/admin/artsalessistserach/cho")
public class ArtSalesListSerachCho extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminSalesServlce adminSalesService = new AdminSalesServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession searchartid = req.getSession();
		String artid = (String)searchartid.getAttribute("artid");
		req.setAttribute("artid",artid); 
		
		//선택 월 기준
		int month = adminSalesService.getparmmonth(req);
		System.out.println("month"+month); //달 확인
		
		//달  넘기기
		req.setAttribute("month", month);
		
		//현재 달
		Date[] chooseyearday = adminSalesService.chooseyearday(month);
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Paging paging = adminSalesService.artsearchchoPaging(req,artid,chooseyearday);
		
		//사용자 아이디 검색 클래스 리스트  전체 조회
		ArrayList<Map<String, Object>> choartsearchlist  = adminSalesService.choartsearchlist(paging,artid,chooseyearday);
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
		
		//사업자 수익 리스트 넘기기
		req.setAttribute("choartsearchlist", choartsearchlist);
		
		//사업자 별 현재 달 총 수익금
		int chosearchtotal = adminSalesService.chosearchtotalsales(artid,chooseyearday);
		
		//사업자 별 현재 달 총 수익금 넘기기
		req.setAttribute("chosearchtotal", chosearchtotal);
		
		
		req.getRequestDispatcher("/WEB-INF/views/admin/sales/artsaleslistsearchcho.jsp").forward(req,resp);
	}

}
