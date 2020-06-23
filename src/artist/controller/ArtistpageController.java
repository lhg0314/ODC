package artist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//20200623 이인주
// 작가페이지 
@WebServlet("/artist/artistpage")
public class ArtistpageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/artist/artistpage [GET]");
	
		//이인주 20200623 
		
		//사업자로 로그인한 아이디값 가져오기
		HttpSession session = req.getSession();
		
		// 세션으로 사업자 아이디값 불러서 변수에 저장하기
		String  artid = (String)session.getAttribute("artid");
		
		//사업자  아이디  jsp로 넘기기
		req.setAttribute("artid", artid);
	
		req.getRequestDispatcher("/WEB-INF/views/artist/artistpage/artistpage.jsp").forward(req, resp);
	
	}

}
