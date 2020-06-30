package artist.controller;
/**
 * 
 * 작가페이지 - 작가 후원내역 관리 서블릿
 * 완성
 * 200625
 * 박주이
 */
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
/**
 * 관리자 - 작가 후원내역 관리 서블릿
 * 작성중
 * 200625
 * 박주이
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import artist.service.face.ArtistBoardService;
import artist.service.face.ArtistDonationService;
import artist.service.impl.ArtistBoardServiceImpl;
import artist.service.impl.ArtistDonationServiceImpl;
import util.Paging;
@WebServlet("/artist/donation")
public class ArtistDonationSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistDonationService artistDonationService = new ArtistDonationServiceImpl();
	private ArtistBoardService artistBoardService = new ArtistBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/artist/donation - [GET]");
	
		HttpSession session = req.getSession();
		
		if(session.getAttribute("artid") == null) {
			resp.sendRedirect("/");
			return;
		}
		
		int selectedmonth = 0;
		
		if(req.getParameter("month") != null)
			selectedmonth = Integer.parseInt(req.getParameter("month"));
		
		String artid = (String) session.getAttribute("artid");
		
		int artno = artistBoardService.getArtNoById(artid);
		
		Paging paging = artistDonationService.getPagingDonationByArtNo(req, artno);
		
		List<Map<String, Object>> list = artistDonationService.selectDonationByArtNo(paging, artno);
				
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		req.setAttribute("selectedmonth", selectedmonth);
		
		req.getRequestDispatcher("/WEB-INF/views/artist/donation/donation.jsp").forward(req, resp);
	}

}
