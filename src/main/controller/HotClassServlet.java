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

@WebServlet("/hotclass")
public class HotClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	NewClassService nClassService = new NewClassServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//인기클래스 불러오기
		List<Map<String, Object>> cinfo = nClassService.hotclass();
		
//		System.out.println(cinfo);
		
		
		req.setAttribute("cinfo", cinfo);
		
		req.getRequestDispatcher("/WEB-INF/views/main/navMenu/hotClass.jsp").forward(req, resp);
	
	}
	
}
