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
import main.service.face.NewClassService;
import main.service.impl.LocationCategoryTalentServiceImpl;
import main.service.impl.NewClassServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NewClassService nClassService = new NewClassServiceImpl();
	private LocationCategoryTalentService talentDonationService = new LocationCategoryTalentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인기 클래스
		List<Map<String, Object>> hotList = nClassService.hotclass();
		List<Map<String, Object>> h = nClassService.changeString(hotList); //지역,카테고리 형변환
		
		//신규 클래스
		List<Map<String, Object>> newList = nClassService.newclass();
		List<Map<String, Object>> n = nClassService.changeString(newList); //지역,카테고리 형변환
		
		//재능기부 클래스

		List<Map<String, Object>> talentList = talentDonationService.selectClassByTalentDonation(0);
		
		
		req.setAttribute("hotList", h);
		req.setAttribute("newList", n);
		req.setAttribute("talentList", talentList);
		
		
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}

}
