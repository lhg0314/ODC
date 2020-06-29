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


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocationCategoryTalentService talentDonationService = new LocationCategoryTalentServiceImpl();
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Map<String, Object>> talentList = talentDonationService.selectClassByTalentDonation(0);
		
		req.setAttribute("talentList", talentList);
		
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}

}
