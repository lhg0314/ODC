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
		
		ainfo = artUpdateService.artInfoLoad(ainfo);
		System.out.println(ainfo);
		
		
		if(aLeaveService.pwcheck(ainfo)) {
			
			System.out.println("아이디 비번 다 맞네요");
			
			//탈퇴 진행
//			aLeaveService.leave(ainfo);
			
			//로그아웃으로 리다이렉트
//			resp.sendRedirect("/user/logout");
			
			
		} else { 
			
			System.out.println("에바임"); 
			
			//탈퇴페이지로 리다이렉트
			resp.sendRedirect("/artist/leave");
		}
		
	
		
		
	}
	
}
