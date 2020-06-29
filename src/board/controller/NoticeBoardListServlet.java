package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.service.face.AdminBoardService;
import admin.service.impl.AdminBoardServiceImpl;
import dto.NoticeBoard;
import util.Paging;

@WebServlet("/notice/list")
public class NoticeBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminBoardService adminBoardService = new AdminBoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/noticelist - [GET]");
		
		Paging paging = adminBoardService.getPagingNotice(req);
		
		List<NoticeBoard> list = adminBoardService.selectAllNotice(paging);
		
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/board/noticelist.jsp").forward(req, resp);
		
	}
}
