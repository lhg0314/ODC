package admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminManageService;
import admin.service.impl.AdminManageServiceImpl;
import dto.AskBoard;
import dto.ClassBooking;
import dto.ReviewBoard;


/*
 * 200621 이서연 
 * 회원정보 상세보기 > 목록별 전체보기
 */

@WebServlet("/admin/userviewall")
public class UserViewAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	AdminManageService adminManageService = new AdminManageServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String param = req.getParameter("cate");
		
//		System.out.println(param);
		
		
		if("book".equals(param)) {
			
			
			//예약 클래스 조회
			ClassBooking book = new ClassBooking();
			
			book.setUserno(Integer.parseInt(req.getParameter("userno")));
			
			System.out.println(book.getUserno());
			
			List<Map<String, Object>> booking = adminManageService.bookingList(book);
			
			
			
			//조회결과 model값 전달
			req.setAttribute("booking", booking);
			
			//view 지정
			req.getRequestDispatcher("/WEB-INF/views/admin/user/userViewBookAll.jsp").forward(req, resp);
		
			
			
		} else if("review".equals(param)) {
			
			//작성 후기 조회
			ReviewBoard reviewBoard = new ReviewBoard();
			
			reviewBoard.setUserno(Integer.parseInt(req.getParameter("userno")));
			
			List<Map<String, Object>> review = adminManageService.reviewList(reviewBoard);
			
			
			
			//조회결과 model값 전달
			req.setAttribute("review", review);
			
			//view 지정
			req.getRequestDispatcher("/WEB-INF/views/admin/user/userViewReviewAll.jsp").forward(req, resp);
			
			
			
		} else if("ask".equals(param)) {
			
			
			//작성 문의 조회
			AskBoard askBoard = new AskBoard();
			
			askBoard.setUserno(Integer.parseInt(req.getParameter("userno")));
			
			List<AskBoard> ask = adminManageService.askList(askBoard);
			
			
			
			//조회결과 model값 전달
			req.setAttribute("ask", ask);
			
			//view 지정
			req.getRequestDispatcher("/WEB-INF/views/admin/user/userViewAskAll.jsp").forward(req, resp);
			
			
		} else System.out.println("fuck");
		
	}
	
}
