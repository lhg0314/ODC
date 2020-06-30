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
import user.service.face.UserLeaveService;
import user.service.impl.UserInfoUpdateServiceImpl;
import user.service.impl.UserLeaveServiceImpl;

@WebServlet("/user/leave")
public class UserLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	UserInfoUpdateService userUpdateService = new UserInfoUpdateServiceImpl();
	UserLeaveService uLeaveService = new UserLeaveServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/leave [GET]");
		
		
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

		 
		req.getRequestDispatcher("/WEB-INF/views/user/mypage/userLeave.jsp").forward(req, resp);
		
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		//세션 객체 생성 - id 가져오기
		HttpSession session =  req.getSession();
		
		//UserInfo 객체 만들어서 id 넣어주기
		UserInfo uinfo = new UserInfo();
		uinfo.setUserid((String)session.getAttribute("userid"));
		uinfo.setUserpw(req.getParameter("pwcheck"));
		
		
		//System.out.println((String)session.getAttribute("userid"));
		//System.out.println(req.getParameter("pwcheck"));
		
		
		
		
		if(uLeaveService.pwcheck(uinfo)) {
			
			
			UserInfo u = userUpdateService.userInfoLoad(uinfo);
			System.out.println(u);

			//탈퇴 진행
			uLeaveService.leave(u);
			
			
			String msg = "탈퇴가 완료되었습니다.";
			String url = "/user/logout";
			
			
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			
			req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/alert.jsp").forward(req,resp);
			
			
			
		} else { 
			
			
			String msg = "입력하신 비밀번호가 틀립니다.";
			String url = "/user/leave";
			
			
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			
			req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/alert.jsp").forward(req,resp);
			
			resp.sendRedirect("");
		}
		
	
	
	
	}

}
