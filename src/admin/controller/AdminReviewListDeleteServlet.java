package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminBoardService;
import admin.service.impl.AdminBoardServiceImpl;

/**
 * 관리자 - 후기게시판 선택 삭제
 * 완성
 * 200624
 * 박주이
 */
@WebServlet("/admin/rlistdelete")
public class AdminReviewListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminBoardService adminBoardService = new AdminBoardServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String names = req.getParameter("names");
		
		if( !"".equals(names) && names != null) {
			adminBoardService.reviewListDelete(names);
		}
		
		resp.sendRedirect("/admin/reviewlist");
	}
}
