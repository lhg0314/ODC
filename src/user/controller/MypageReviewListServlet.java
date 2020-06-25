package user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.face.UserBoardService;
import user.service.impl.UserBoardServiceImpl;
import util.Paging;

/**
 * 
 * 마이페이지 - 후기게시판 리스트 출력
 * @author 200625 박주이
 * 작성중 - 후기 작성하기 버튼 추가하기
 *
 */
@WebServlet("/mypage/reviewlist")
public class MypageReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBoardService userBoardService = new UserBoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/reviewlist - [GET]");
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("userid") == null) {
			resp.sendRedirect("/");
			return;
		}
		
		String userid = (String) session.getAttribute("userid");
		
		int userno = userBoardService.getUserNoById(userid);
		
		Paging paging = userBoardService.getPagingReviewByUserNo(req, userno);
		
		List<Map<String, Object>> list = userBoardService.selectReviewByUserNo(paging, userno);
		
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		System.out.println(list);
		
		req.getRequestDispatcher("/WEB-INF/views/user/mypage/board/reviewlist.jsp").forward(req, resp);
		
	}
}
