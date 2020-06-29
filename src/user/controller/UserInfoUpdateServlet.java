package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import user.service.face.UserInfoUpdateService;
import user.service.impl.UserInfoUpdateServiceImpl;

@WebServlet("/user/info")
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	UserInfoUpdateService userUpdateService = new UserInfoUpdateServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/info [GET]");
	 
		 
		 //세션 객체 생성 - id 가져오기
		 HttpSession session =  req.getSession();
		 
		 
		 //UserInfo 객체 만들어서 id 넣어주기
		 UserInfo u = new UserInfo();
		 u.setUserid((String)session.getAttribute("userid"));
		 
		 
		 //UserInfo 싹 가져오기
		 UserInfo uinfo = userUpdateService.userInfoLoad(u);
		 
		 int grade = uinfo.getUsergrade();
		
		 //결과 전달
		 req.setAttribute("grade", grade);
		 
		 
		 //결과 전달
		 req.setAttribute("uinfo", uinfo);
		 
		 //view 지정
		 req.getRequestDispatcher("/WEB-INF/views/user/mypage/userInfoUpdate.jsp").forward(req, resp);
	
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/info [POST]");
		
		
		 req.setCharacterEncoding("UTF-8");
			
		 
		 resp.setContentType("text/html; charset=utf-8");
		
		
		//정보 수정하기
		userUpdateService.userInfoUpdate(req);
		
		
		//마이페이지로 리다이렉트
		resp.sendRedirect("/user/mypage");
		
	}
	

}
