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
 * 200625
 * 박주이
 */
@WebServlet("/admin/donation")
public class UserDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDonationService adminDonationService = new AdminDonationServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/donation - [GET]");
	
		String searchedartist = null;
		
		int selectedmonth = 0;
		
		if(req.getParameter("month") != null)
			selectedmonth = Integer.parseInt(req.getParameter("month"));
		
		if(req.getParameter("search") != null && !"".equals(req.getParameter("search")))
			searchedartist = adminDonationService.getSearchedArtist((String)req.getParameter("search"));
		
		Paging paging = adminDonationService.getPagingDonation(req);
		List<Map<String, Object>> list = adminDonationService.selectAllDonation(paging);
			
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		req.setAttribute("searchedartist", searchedartist);
		req.setAttribute("selectedmonth", selectedmonth);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/donation/donation.jsp").forward(req, resp);
	}
	
}