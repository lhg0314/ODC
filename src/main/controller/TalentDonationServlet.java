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
import util.Paging;

@WebServlet("/talentDonation")
public class TalentDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocationCategoryTalentService talentDonationService = new LocationCategoryTalentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int category = 0;
		String param = req.getParameter("category");
		
		if( param != null && !"".equals(param)) {
			category = Integer.parseInt(param);
		}
		
		Paging paging = talentDonationService.getPagingTalent(req, category);
		
		List<Map<String, Object>> list = talentDonationService.selectClassByTalentDonation(category);
	
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		req.setAttribute("category", category);
		
		req.getRequestDispatcher("/WEB-INF/views/main/navMenu/talentDonation.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int category = 0;
		String param = req.getParameter("category");
		
		if( param != null && !"".equals(param)) {
			category = Integer.parseInt(param);
		}
		
		Paging paging = talentDonationService.getPagingTalent(req, category);
		
		List<Map<String, Object>> list = talentDonationService.selectClassByTalentDonation(category);
		
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		req.setAttribute("category", category);
		
		req.getRequestDispatcher("/WEB-INF/views/main/navMenu/talentDonation.jsp").forward(req, resp);
		
	}

}
