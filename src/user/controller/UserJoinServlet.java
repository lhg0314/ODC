package user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserInfo;
import user.service.UserService;
import user.service.UserServiceImpl;


@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private UserService userService=new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget[user/join]");
		req.getRequestDispatcher("/WEB-INF/views/user/join/userjoin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		UserInfo user=new UserInfo();//param값으로 받아온 사용자의 정보를 저장함
		
//		user.setUserAuth(1);
		
		String birth=req.getParameter("userbirth");
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date todate = null;
		try {
			todate = transFormat.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    java.sql.Date sqlDate = new java.sql.Date(todate.getTime());
		user.setUserbirth(sqlDate);
		//
		user.setUseremail(req.getParameter("useremail"));
		user.setUserid(req.getParameter("userid"));
		user.setUsername(req.getParameter("username"));
		
		Long userphone=Long.parseLong(req.getParameter("userphone"));
		user.setUserphone(userphone);
		
		user.setUserpw(req.getParameter("userpw"));
		
		System.out.println(user);
		
		userService.insertUser(user);//회원정보를 디비에 저장함
		
		req.getRequestDispatcher("/WEB-INF/layout/common/login/join/joinemail.jsp").forward(req, resp);//회원가입을 완료했을시 보이는 페이지
		
		
	}
  

}
