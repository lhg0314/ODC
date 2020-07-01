package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.face.UserService;
import user.service.impl.UserServiceImpl;


@WebServlet("/naver/login")
public class NaverLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService=new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String email=req.getParameter("email");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String birth=req.getParameter("birth");
		
		//session.setAttribute("userid", id);
		System.out.println(email);
		System.out.println(name);
		System.out.println(id);
	
		
		int result=userService.idCheck(id);
		System.out.println(result);
		
		if(result==1) {//네이버로 회원가입한 회원일때
			session.setAttribute("userid", id);//로그인처리
			resp.sendRedirect("/main");
		}else {//네이버로 회원가입한 회원이 아닐때
	
			req.getRequestDispatcher("/WEB-INF/layout/common/login/join/simplejoin.jsp").forward(req, resp);//간편 회원가입 페이지
		}
		
		
		//resp.sendRedirect("/main");
		
		
	}
}
