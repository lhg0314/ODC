package user.controller;

import java.io.IOException;

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
 * 사용자 - 문의 내역 선택 삭제 
 * 완성
 * 200626 박주이
 */
@WebServlet("/user/alistdelete")
public class MypageAskListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBoardService userBoardService = new UserBoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("/user/alistdelete - [GET]");
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("userid") == null) {
			resp.sendRedirect("/");
			return;
		}
		
		String userid = (String) session.getAttribute("userid");
		String names = req.getParameter("names");

		int userno = userBoardService.getUserNoById(userid);

		if (!"".equals(names) && names != null) {
			userBoardService.askListDeleteByUserNo(names, userno);
		}

		resp.sendRedirect("/mypage/asklist");
	}
}
