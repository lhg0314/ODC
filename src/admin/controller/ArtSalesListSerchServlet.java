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

//사업자 검색 총수익
//이인주 20200621
@WebServlet("/admin/artsales/search")
public class ArtSalesListSerchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminSalesServlce adminSalesService = new AdminSalesServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/admin/artsales/search [get]");
		
		//요청
		req.setCharacterEncoding("utf-8");
		
		//응답
		resp.setContentType("text/html;charset=utf-8");
		
		//검색한 사용자 아이디 파라미터값 꺼내기
		String artid =  adminSalesService.searchidparam(req);
		
		//사용자 아이디 파라미터값 넘기기
		req.setAttribute("artid", artid);
		
		//현재 달
		Date[] nowyearday = adminSalesService.nowyearday();
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Paging paging = adminSalesService.artidnowgetPaging(req,artid,nowyearday);
		
		//사용자 아이디 검색 클래스 리스트  전체 조회
		ArrayList<Map<String, Object>> nowartsearchlist  = adminSalesService.nowartsearchlist(paging,artid,nowyearday);
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
		
		//사업자 별 현재 달 총 수익금
		int nowsearchtotal = adminSalesService.nowsearchtotalsales(artid,nowyearday);
		
		//사업자 별 현재 달 총 수익금 넘기기
		req.setAttribute("nowsearchtotal", nowsearchtotal);
		
		//사업자 수익 리스트 넘기기
		req.setAttribute("nowartsearchlist", nowartsearchlist);
			
		req.getRequestDispatcher("/WEB-INF/views/admin/sales/artsaleslistsearch.jsp").forward(req,resp);
					
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/admin/artsales/search [post]");
		
		//요청
		req.setCharacterEncoding("utf-8");
		
		//응답
		resp.setContentType("text/html;charset=utf-8");
		
		//검색한 사용자 아이디 파라미터값 꺼내기
		String artid =  adminSalesService.searchidparam(req);
		
		//사용자 아이디 파라미터값 넘기기
		req.setAttribute("artid", artid);
		
		HttpSession searchartid = req.getSession();
		searchartid.setAttribute("artid", artid);
		
		//현재 달
		Date[] nowyearday = adminSalesService.nowyearday();
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Paging paging = adminSalesService.artidnowgetPaging(req,artid,nowyearday);
		
		//사용자 아이디 검색 클래스 리스트  전체 조회
		ArrayList<Map<String, Object>> nowartsearchlist  = adminSalesService.nowartsearchlist(paging,artid,nowyearday);
		
		//사업자 수익 리스트 넘기기
		req.setAttribute("nowartsearchlist", nowartsearchlist);
		
		//사업자 별 현재 달 총 수익금
		int nowsearchtotal = adminSalesService.nowsearchtotalsales(artid,nowyearday);
		
		//사업자 별 현재 달 총 수익금 넘기기
		req.setAttribute("nowsearchtotal", nowsearchtotal);
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
			
		req.getRequestDispatcher("/WEB-INF/views/admin/sales/artsaleslistsearch.jsp").forward(req,resp);

	}
}
