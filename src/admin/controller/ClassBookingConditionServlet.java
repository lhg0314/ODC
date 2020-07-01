package admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminClassService;
import admin.service.impl.AdminClassServiceImpl;
import util.Paging;

@WebServlet("/admin/class/book")
public class ClassBookingConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminClassService adminClassService = new AdminClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		System.out.println("doget /book");
		
		String param = req.getParameter("classno");

		int classno = 0;
		if( param!=null && !"".equals(param) ) {
			classno = Integer.parseInt(param);
		}
		
		// 요청 파라미터를 전달하여 Paging 객체 생성하기
		Paging paging = adminClassService.getPagingBookingClass(req, classno);
//		System.out.println("BoardListController =" + paging);
		
				
		// DB에서 클래스 정보 꺼내오기
//		map = adminService.selectAllClass();
		List<Map<String, Object>> list = adminClassService.selectClassBookingByClassNo(paging, classno);
		
//		System.out.println(list);

//		System.out.println(map);
		// list data VIEW 로 넘겨주기
		req.setAttribute("list", list);
		// Paging 처리 결과 Model 값 전달
		req.setAttribute("paging", paging);
		req.setAttribute("classno", classno);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/classManage/classBookingView.jsp").forward(req, resp);
	
	
	
	
	}

}
