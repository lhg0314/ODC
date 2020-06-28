package user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.face.LocationCategoryService;
import user.service.impl.LocationCategoryServiceImpl;

@WebServlet("/category")
public class ClassCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocationCategoryService categoryService = new LocationCategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String param = req.getParameter("category");
		
		int category = 0;
		
		if( param != null && !"".equals(param)) {
			category = Integer.parseInt(param);
		}

		List<Map<String, Object>> list = categoryService.selectClassByCategory(category);
		
		// 카테고리별 처리
		String msg = categoryService.getCategory(req, category);
		
		req.setAttribute("list", list);
		req.setAttribute("message", msg);
		
		req.getRequestDispatcher("/WEB-INF/views/main/navMenu/category.jsp").forward(req, resp);
	
	
	
	}
	
	

}
