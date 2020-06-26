package artist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.service.face.ArtistClassService;
import artist.service.impl.ArtistClassServiceImpl;

@WebServlet("/artist/class/delete")
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
        String msg = "";
        String url = "";
        
        if( cnt > 0) {
        	msg = "클래스를 예약한 사용자가 있습니다.";
        }
        else {
        	int res = artistClassService.removeClass(classno);
        	
        	if( res > 0) {
        		msg = "클래스를 삭제하였습니다.";
        	}else {
        		msg = "클래스 삭제 실패";
        	}
        	
        }
        
		url = "/artist/class/manage";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		request.getRequestDispatcher("/WEB-INF/views/artist/class/alert.jsp").forward(request,response);
		
		
	}

}
