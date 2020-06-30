package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//로그인후 보여짐 로고누르면 보여지는 페이지 
//관리자 메인
//이인주 20200620
@WebServlet("/admin/main")
public class AdminmainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//이인주 20200623 
		
		//사업자로 로그인한 아이디값 가져오기

		HttpSession session=req.getSession();
		
		System.out.println(session.getAttribute("artid"));
		if(session.getAttribute("adminid")==null) {//작가가 로그인을 안했을때
			req.getRequestDispatcher("/member/login").forward(req, resp);
		}else {
			// 세션으로 사업자 아이디값 불러서 변수에 저장하기
			String  adminid = (String)session.getAttribute("adminid");
			
			//사업자  아이디  jsp로 넘기기
			req.setAttribute("adminid", adminid);
			
			req.getRequestDispatcher("/WEB-INF/layout/admin/adminmain.jsp").forward(req,resp);		}
		
		
	}
}
