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
import dto.NoticeBoard;
import util.Paging;

/**
 * 관리자 - 공지사항 관리 페이지
 * 완성
 * 200623
 * 박주이
 */
@WebServlet("/admin/noticelist")
public class AdminNoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminBoardService adminBoardService = new AdminBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/noticelist - [GET]");
		
		Paging paging = adminBoardService.getPagingNotice(req);
		
		List<NoticeBoard> list = adminBoardService.selectAllNotice(paging);
		
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/board/noticelist.jsp").forward(req, resp);
		
	}
}
