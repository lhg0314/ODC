package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import artist.service.face.ArtistService;
import artist.service.impl.ArtistServiceImpl;
import user.service.UserService;
import user.service.UserServiceImpl;


@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private UserService userService=new UserServiceImpl();
	private ArtistService artistService=new ArtistServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/layout/common/login/login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String opt=(String)req.getParameter("opt");
		
		System.out.println("id: "+id+", pw: "+pw+", loginActor: "+opt);
		
		boolean ismember=false;
		
		if("user".equals(opt)) {//사용자에 체크했을때
			
			ismember=userService.userLogin(id,pw);//입력한 정보가 데이터베이스에있는지 찾아옴
			System.out.println(ismember);
			if(ismember==true) {//존재하는 회원일때
				
				session.setAttribute("userid", id);//세션값에 저장
				out.println("1");
			}else {
				out.println("0");
			}
			
		}else if("artist".equals(opt)) {//작가에 체크했을때
			ismember=artistService.artistLogin(id,pw);
			if(ismember==true) {
				session.setAttribute("artid", id);
				out.println("1");
			}else {
				out.println("0");
			}
			
		}else if("admin".equals(opt)) {//관리자에 체크했을때
			if("adminId".equals(id) && "adminPw".equals(pw)) ismember=true;
			if(ismember==true) {
				session.setAttribute("adminid", id);
				out.println("1");
			}else {
				out.println("0");
			}
		}
	}

}
