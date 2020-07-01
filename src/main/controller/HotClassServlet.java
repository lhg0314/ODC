package main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.service.face.NewClassService;
import main.service.impl.NewClassServiceImpl;
import util.Paging;

@WebServlet("/hotclass")
public class HotClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	NewClassService nClassService = new NewClassServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int category = 0;
		String param = req.getParameter("category");
		
//		System.out.println(param);
		
		if( param != null && !"".equals(param)) {
			category = Integer.parseInt(param);
		}
		
		Paging paging = nClassService.getPagingHot(req, category);
		
		//인기클래스 불러오기
		List<Map<String, Object>> cinfo = nClassService.hotClassBySelectedCate(category);
		
		//지역, 카테고리 형변환
		List<Map<String, Object>> c = nClassService.changeString(cinfo);
		
		
		req.setAttribute("paging", paging);
		req.setAttribute("cinfo", c);
		req.setAttribute("category", category);
		
		req.getRequestDispatcher("/WEB-INF/views/main/navMenu/hotClass.jsp").forward(req, resp);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int category = 0;
		String param = req.getParameter("category");
		
//		System.out.println(param);
		
		if( param != null && !"".equals(param)) {
			category = Integer.parseInt(param);
		}
	
		
		Paging paging = nClassService.getPagingHot(req, category);
		
		List<Map<String, Object>> list = nClassService.hotClassBySelectedCate(category);
		
		List<Map<String, Object>> l = nClassService.changeString(list);
	
		
		req.setAttribute("paging", paging);
		req.setAttribute("cinfo", l);
		req.setAttribute("category", category);
		
		req.getRequestDispatcher("/WEB-INF/views/main/navMenu/hotClass.jsp").forward(req, resp);
		
	}
	
}
