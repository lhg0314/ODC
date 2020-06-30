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
import dto.AskBoardComm;
/**
 * 
 * 관리자 페이지 - 리뷰 상세보기
 * @author 박주이
 *
 */
@WebServlet("/admin/reviewdetail")
public class AdminReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminBoardService adminBoardService = new AdminBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int reviewno = Integer.parseInt(req.getParameter("reviewno"));
		
		Map<String, Object> reviewdetail = adminBoardService.selectReviewByReviewNo(reviewno);
		
		req.setAttribute("reviewdetail", reviewdetail);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/board/reviewdetail.jsp").forward(req, resp);
		
		
	}

}
