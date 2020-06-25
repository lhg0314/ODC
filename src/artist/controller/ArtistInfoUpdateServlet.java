package artist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import artist.service.face.ArtistInfoUpdateService;
import artist.service.impl.ArtistInfoUpdateServiceImpl;
import dto.ArtistDetail;
import dto.ArtistFile;
import dto.ArtistInfo;

@WebServlet("/artist/info")
public class ArtistInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	ArtistInfoUpdateService artUpdateService = new ArtistInfoUpdateServiceImpl();
	
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("/artist/info [GET]");
	 
		 
		 //작가 정보 가져오기
		 //----------------------------------------
		 
		 
		 //세션 객체 생성 - id 가져오기
		 HttpSession session =  req.getSession();
		 
		 
		 //ArtistInfo 객체 만들어서 id 넣어주기
		 ArtistInfo a = new ArtistInfo();
		 a.setArtid((String)session.getAttribute("artid"));
		 
		 //ArtistInfo 싹 가져오기
		 ArtistInfo ainfo = artUpdateService.artInfoLoad(a);
		 
		 
		 
		 //ArtistInfo에서 가져온 artno 넣어주기
		 ArtistDetail ad = new ArtistDetail();
		 ad.setArtno(ainfo.getArtno());
		 
		 
		 String addr = ainfo.getArtAddr();
		 String addr1 = (addr.split(";").length > 0)?addr.split(";")[0]:"";
		 String addr2 = (addr.split(";").length > 1)?addr.split(";")[1]:"";
		 String addr3 = (addr.split(";").length > 2)?addr.split(";")[2]:"";
		 
		 
		 
		 //결과 전달
		 req.setAttribute("ainfo", ainfo);
		 
		 req.setAttribute("addr1", addr1);
		 req.setAttribute("addr2", addr2);
		 req.setAttribute("addr3", addr3);
		 
		 
		 
		 //view 지정
		 req.getRequestDispatcher("/WEB-INF/views/artist/artistpage/artInfoUpdate.jsp").forward(req, resp);
		 	
	 }
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("/artist/info [POST]");
		 
		 req.setCharacterEncoding("UTF-8");
			
	 
		 resp.setContentType("text/html; charset=utf-8");
		 
		 
		 //정보 수정하기
		 artUpdateService.artInfoUpdate(req);
		 
		 
		//작가페이지로 리다이렉트
		resp.sendRedirect("/artist/artistpage");
		 
	 }

}
