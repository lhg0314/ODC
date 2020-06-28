package user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ClassInfo;
import user.service.face.LocationService;
import user.service.impl.LocationServiceImpl;

@WebServlet("/class/location")
public class ClassLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocationService locationService = new LocationServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/class/location GET");
		
		String param = req.getParameter("location");
		
		int location = 0;
		
		if( param != null && !"".equals(param)) {
			location = Integer.parseInt(param);
		}

		List<Map<String, Object>> list = locationService.selectClassByLocation(location);
		
		String msg = "";
		req.setAttribute("list", list);
		if( location == 0) {
			msg = "전체";
			req.setAttribute("message", msg);
		}else if(location == 1) {
			msg = "서울";
			req.setAttribute("message", msg);
		}else if(location == 2) {
			msg = "경기";
			req.setAttribute("message", msg);
		}else if(location == 3) {
			msg = "강원";
			req.setAttribute("message", msg);
		}else if(location == 4) {
			msg = "충청";
			req.setAttribute("message", msg);
		}else if(location == 5) {
			msg = "경상";
			req.setAttribute("message", msg);
		}else if(location == 6) {
			msg = "전라";
			req.setAttribute("message", msg);
		}else if(location ==7) {
			msg = "제주";
			req.setAttribute("message", msg);
		}
		
		req.getRequestDispatcher("/WEB-INF/views/user/class/location.jsp").forward(req, resp);
	
	
	}
	
}
