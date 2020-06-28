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

@WebServlet("/mypage/askdetail")
public class MypageAskDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBoardService userBoardService = new UserBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/askdetail - [GET]");
		
		int askno = Integer.parseInt(req.getParameter("askno"));
		
		Map<String, Object> askdetail = userBoardService.selectAskByAskNo(askno);
		
		req.setAttribute("askdetail", askdetail);
		
		req.getRequestDispatcher("/WEB-INF/views/user/mypage/board/askdetail.jsp").forward(req, resp);
		
	}
}