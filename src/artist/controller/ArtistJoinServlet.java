package artist.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.service.face.ArtistService;
import artist.service.impl.ArtistServiceImpl;
import dto.ArtistInfo;
import dto.UserInfo;


@WebServlet("/artist/join")
public class ArtistJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArtistService artistService=new ArtistServiceImpl();
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/artist/join/artistjoin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ArtistInfo artist=new ArtistInfo();
		
		artist.setArtEmailAuth(1);
		
		String birth=req.getParameter("artbirth");
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date todate = null;
		try {
			todate = transFormat.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    java.sql.Date sqlDate = new java.sql.Date(todate.getTime());
		artist.setArtBirth(sqlDate);
		
		//
		artist.setArtEmail(req.getParameter("useremail"));
		artist.setArtid(req.getParameter("userid"));
		artist.setArtName(req.getParameter("artname"));
		
		Long artistphone=Long.parseLong(req.getParameter("artphone"));
		artist.setArtPhone(artistphone);
		
		artist.setArtpw(req.getParameter("artpw"));
		artist.setArtCode(Integer.parseInt(req.getParameter("businessnumber")));
		
		String addr=req.getParameter("addr1") +";"+req.getParameter("addr2")+ ";"+req.getParameter("addr3");
		artist.setArtAddr(addr);
		
		artist.setArtNick(req.getParameter("artnick"));
		
		artist.setArtTel(Long.parseLong(req.getParameter("arttelephone")));
		artist.setArtContent(req.getParameter("artintro"));
		
		System.out.println(artist);
		
		artistService.insertartist(artist);//회원정보를 디비에 저장함
		
		req.getRequestDispatcher("/WEB-INF/layout/common/login/join/joinemail.jsp").forward(req, resp);//회원가입을 완료했을시 보이는 페이지
		
	}

}
