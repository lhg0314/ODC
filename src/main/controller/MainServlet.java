package main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.service.LocationCategoryTalentService;
import main.service.LocationCategoryTalentServiceImpl;
import main.service.NewClassService;
import main.service.NewClassServiceImpl;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private NewClassService nClassService = new NewClassServiceImpl();
	private LocationCategoryTalentService talentDonationService = new LocationCategoryTalentServiceImpl();
       
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인기 클래스
		List<Map<String, Object>> hotList = nClassService.hotclass();
		
		//신규 클래스
		List<Map<String, Object>> newList = nClassService.newclass();
		
		//재능기부 클래스
		List<Map<String, Object>> talentList = talentDonationService.selectClassByTalentDonation(0);
		
		req.setAttribute("hotList", hotList);
		req.setAttribute("newList", newList);
		req.setAttribute("talentList", talentList);
		
		
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}

}
