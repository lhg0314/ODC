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

import admin.service.face.AdminSalesServlce;
import admin.service.impl.AdminSalesServiceImpl;
import util.Paging;

//사업자 총수익
//이인주 20200621
@WebServlet("/admin/artsales/list")
public class ArtSalesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminSalesServlce adminSalesService = new AdminSalesServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/artsales/list [get]");
		
		//현재 달
		Date[] nowyearday = adminSalesService.nowyearday();
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Paging paging = adminSalesService.nowgetPaging(req,nowyearday);
		
		//사업자 수익 리스트  전체 조회
		ArrayList<Map<String, Object>> nowartsaleslist  = adminSalesService.nowselectartsaleslistAll(paging,nowyearday);
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
		
		//사업자 수익 리스트 넘기기
		req.setAttribute("nowartsaleslist", nowartsaleslist);
		
		//사업자 현재 달 총 수익금
		int nowtotalsales = adminSalesService.nowtotalsales(nowyearday);
		//사업자 현재 달 총 수익금 넘기기
		req.setAttribute("nowtotalsales", nowtotalsales);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/sales/artistlistnow.jsp").forward(req,resp);
		
	}
	
	//사업자 달 선택 결과
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/artsales/list [post]");
		
		//선택 월 기준
		int month = adminSalesService.getparmmonth(req);
		System.out.println("month"+month); //달 확인
		
		//달  넘기기
		req.setAttribute("month", month);
		
		//현재 달
		Date[] chooseyearday = adminSalesService.chooseyearday(month);
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Paging paging = adminSalesService.chogetPaging(req,chooseyearday);
		
		//관리자 수익 리스트  전체 조회
		ArrayList<Map<String, Object>> choartsaleslist  = adminSalesService.choselectartsaleslistAll(paging,chooseyearday);
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
		
		//사업자 수익 리스트 넘기기
		req.setAttribute("choartsaleslist", choartsaleslist);
		
		//사업자 선택 달 총 수익금
		int chototalsales = adminSalesService.chototalsales(chooseyearday);
		
		//사업자 선택 달 총 수익금 넘기기
		req.setAttribute("chototalsales", chototalsales);
				
		req.getRequestDispatcher("/WEB-INF/views/admin/sales/artistlistcho.jsp").forward(req,resp);
	}

}
