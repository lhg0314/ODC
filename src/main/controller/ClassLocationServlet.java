package main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.service.face.LocationCategoryTalentService;
import main.service.impl.LocationCategoryTalentServiceImpl;

@WebServlet("/location")
public class ClassLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocationCategoryTalentService locationService = new LocationCategoryTalentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String param = req.getParameter("location");
		
		int location = 0;
		
		if( param != null && !"".equals(param)) {
			location = Integer.parseInt(param);
		}

		List<Map<String, Object>> list = locationService.selectClassByLocation(location);
		
		// 지역별 처리
		String msg = locationService.getLocation(req, location);
		
		req.setAttribute("list", list);
		req.setAttribute("message", msg);
		
		req.getRequestDispatcher("/WEB-INF/views/main/navMenu/location.jsp").forward(req, resp);
	
	
	}
	
}
