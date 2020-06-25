package admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminDonationService;
import admin.service.impl.AdminDonationServiceImpl;
import util.Paging;

/**
 * 관리자 - 재능기부 클래스 관리 서블릿
 * 완성 
 * 200623
 * 박주이
 */
@WebServlet("/admin/talent")
public class TalentDonationSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminDonationService adminDonationService = new AdminDonationServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/telent - [GET]");
		
		Paging paging = adminDonationService.getPagingTalent(req);
		
		List<Map<String, Object>> list = adminDonationService.selectAllTalentDonationClass(paging);
		
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/donation/talent.jsp").forward(req, resp);
		
	}
}