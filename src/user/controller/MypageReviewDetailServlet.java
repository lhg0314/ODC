package user.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.face.UserBoardService;
import user.service.impl.UserBoardServiceImpl;

@WebServlet("/mypage/reviewdetail")
public class MypageReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBoardService userBoardService = new UserBoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int reviewno = Integer.parseInt(req.getParameter("reviewno"));
		
		Map<String, Object> reviewdetail = userBoardService.selectReviewByReviewNo(reviewno);
		
		req.setAttribute("reviewdetail", reviewdetail);
		
		req.getRequestDispatcher("/WEB-INF/views/user/mypage/board/reviewdetail.jsp").forward(req, resp);
	}
}
