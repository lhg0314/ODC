package artist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import artist.service.face.ArtistInfoUpdateService;
import artist.service.face.ArtistLeaveService;
import artist.service.impl.ArtistInfoUpdateServiceImpl;
import artist.service.impl.ArtistLeaveServiceImpl;
import dto.ArtistInfo;

@WebServlet("/artist/leave")
public class ArtistLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	ArtistLeaveService aLeaveService = new ArtistLeaveServiceImpl();
	ArtistInfoUpdateService artUpdateService = new ArtistInfoUpdateServiceImpl();

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/artist/leave [GET]");
		
		
		req.getRequestDispatcher("/WEB-INF/views/artist/artistpage/artistLeave.jsp").forward(req, resp);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/artist/leave [POST]");
		
	
		//세션 객체 생성 - id 가져오기
		HttpSession session =  req.getSession();
		
		//ArtistInfo 객체 만들어서 id 넣어주기
		ArtistInfo ainfo = new ArtistInfo();
		
		ainfo.setArtid((String)session.getAttribute("artid"));
		ainfo.setArtpw(req.getParameter("pwcheck"));
		
		
		System.out.println((String)session.getAttribute("artid"));
		System.out.println(req.getParameter("pwcheck")); //입력된 비밀번호 잘 들어왔음
		
		
		
		
		if(aLeaveService.pwcheck(ainfo)) { //return true;
			//비번 맞을때 통과
			
			ArtistInfo a = artUpdateService.artInfoLoad(ainfo);
			
			
			if(aLeaveService.classcheck(a)) { //return true;
				
				//비번 맞고 게시중인 클래스 없을 때 탈퇴 진행
				aLeaveService.leave(a);
				
				
				String msg = "탈퇴가 완료되었습니다.";
				String url = "/user/logout";
				
				
				req.setAttribute("msg", msg);
				req.setAttribute("url", url);
				
				req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/alert.jsp").forward(req,resp);
				
				
			} else if (!aLeaveService.classcheck(a)) { //return false;
				
				//비번은 맞는데 게시중인 클래스가 있을 때
				
				String msg = "게시중인 클래스가 있어 탈퇴가 불가능합니다.";
				String url = "/artist/leave";
				
				
				req.setAttribute("msg", msg);
				req.setAttribute("url", url);
				
				req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/alert.jsp").forward(req,resp);
				
			}
			
			
		} else { 
			
			//비번 틀렸을 때
			
			String msg = "입력하신 비밀번호가 틀립니다.";
			String url = "/artist/leave";
			
			
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			
			req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/alert.jsp").forward(req,resp);
			
		}
		
	
	}
	
}
