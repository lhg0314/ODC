package admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminService;
import admin.service.impl.AdminServiceImpl;
import util.Paging;
/**
 * 관리자 - 작가 후원내역 관리 서블릿
 * 200621
 * 박주이
 */
@WebServlet("/admin/donation")
public class UserDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/donation - [GET]");
	
		Paging paging = adminService.getPagingDonation(req);
		
		List<Map<String, Object>> list = adminService.selectAllDonation(paging);
				
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/donation/donation.jsp").forward(req, resp);
	}
}
