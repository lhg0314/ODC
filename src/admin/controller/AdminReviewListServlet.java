package admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminBoardService;
import admin.service.impl.AdminBoardServiceImpl;
import util.Paging;

/**
 * 관리자 - 후기게시판 관리
 * 완성
 * 200624
 * 박주이
 */
@WebServlet("/admin/reviewlist")
public class AdminReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminBoardService adminBoardService = new AdminBoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/admin/reviewlist - [GET]");
		
		Paging paging = adminBoardService.getPagingReview(req);
		
		List<Map<String, Object>> list = adminBoardService.selectAllReview(paging);
		
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/board/reviewlist.jsp").forward(req, resp);
		
	}
}
