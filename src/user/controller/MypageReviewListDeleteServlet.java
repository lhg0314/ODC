package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.face.UserBoardService;
import user.service.impl.UserBoardServiceImpl;

/**
 * 사용자 - 후기 게시글 선택 삭제 
 * 완성
 * 200626 박주이
 */
@WebServlet("/user/rlistdelete")
public class MypageReviewListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBoardService userBoardService = new UserBoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession session = req.getSession();
		
		if(session.getAttribute("userid") == null) {
			resp.sendRedirect("/");
			return;
		}
		
		String userid = (String) session.getAttribute("userid");
		String names = req.getParameter("names");

		int userno = userBoardService.getUserNoById(userid);

		if (!"".equals(names) && names != null) {
			userBoardService.reviewListDeleteByUserNo(names, userno);
		}

		resp.sendRedirect("/mypage/reviewlist");
	}
}
