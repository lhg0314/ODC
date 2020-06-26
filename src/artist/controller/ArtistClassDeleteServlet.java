package artist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.service.face.ArtistClassService;
import artist.service.impl.ArtistClassServiceImpl;

@WebServlet("/ArtistClassDeleteServlet")
public class ArtistClassDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArtistClassService artistClassService = new ArtistClassServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String param = request.getParameter("classno");
		int classno = 0;
        
        if( param != null && !"".equals(param)) {
           classno = Integer.parseInt(param);
        }
        
        // classno로 앞으로 부킹되어 있는 사용자가 있는지 확인하기
        int cnt = artistClassService.BookingCntCheck(classno);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
