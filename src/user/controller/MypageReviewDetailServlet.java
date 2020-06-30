package user.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import user.service.face.UserBoardService;
import user.service.face.UserInfoUpdateService;
import user.service.impl.UserBoardServiceImpl;
import user.service.impl.UserInfoUpdateServiceImpl;
/**
 * 마이페이지 - 후기 상세
 * @author Administrator
 *
 */
@WebServlet("/mypage/reviewdetail")
public class MypageReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBoardService userBoardService = new UserBoardServiceImpl();
	private UserInfoUpdateService userUpdateService = new UserInfoUpdateServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();

		// UserInfo 객체 만들어서 id 넣어주기
		UserInfo u = new UserInfo();
		u.setUserid((String) session.getAttribute("userid"));

		// UserInfo 싹 가져오기
		UserInfo uinfo = userUpdateService.userInfoLoad(u);
		int grade = uinfo.getUsergrade();

		// 결과 전달
		req.setAttribute("grade", grade);
		
		int reviewno = Integer.parseInt(req.getParameter("reviewno"));
		
		Map<String, Object> reviewdetail = userBoardService.selectReviewByReviewNo(reviewno);
		
		req.setAttribute("reviewdetail", reviewdetail);
		
		req.getRequestDispatcher("/WEB-INF/views/user/mypage/board/reviewdetail.jsp").forward(req, resp);
	}
}
