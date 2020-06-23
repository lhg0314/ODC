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
 * 관리자 - 작가 후원내역 관리 서블릿
 * 완성
 * 200623
 * 박주이
 */
@WebServlet("/admin/donation")
public class UserDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDonationService adminDonationService = new AdminDonationServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/donation - [GET]");
	
		Paging paging = adminDonationService.getPagingDonation(req);
		
		List<Map<String, Object>> list = adminDonationService.selectAllDonation(paging);
				
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/donation/donation.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/donation - [POST]");
		
		String month = (String) req.getParameter("month");
		Paging paging = adminDonationService.getPagingDonationByMonth(req);
		
		List<Map<String, Object>> list = adminDonationService.selectAllDonationByMonth(month, paging);

		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		req.setAttribute("selectedmonth", Integer.parseInt(month));
		
		req.getRequestDispatcher("/WEB-INF/views/admin/donation/donation.jsp").forward(req, resp);
	}
}