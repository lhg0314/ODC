package main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ClassInfo;
import main.service.NewClassService;
import main.service.NewClassServiceImpl;

/*
 * 0627 이서연 
 * 메인 > 네비게이션 메뉴 > 신규클래스
 */

@WebServlet("/newclass")
public class NewClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	NewClassService nClassService = new NewClassServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//최신클래스 불러오기
		List<Map<String, Object>> cinfo = nClassService.newclass();
		
		
		//지역, 카테고리 형변환
		List<Map<String, Object>> c = nClassService.changeString(cinfo);
		
		
		
		req.setAttribute("cinfo", c);
		
		req.getRequestDispatcher("/WEB-INF/views/main/navMenu/newClass.jsp").forward(req, resp);
	}
	
}
