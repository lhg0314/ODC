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
import dto.UserInfo;

/* 
 * 200620 이서연
 * 관리자페이지의 사용자 정보에서 사용자 상세정보 불러오는 servlet
 */

@WebServlet("/admin/userview")
public class UserViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	AdminManageService adminManageService = new AdminManageServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/userview [GET]");
		
		
		//유저정보 전체조회
		UserInfo userInfo = adminManageService.selectUserno(req);
		
		
		
		//예약 클래스 조회
		ClassBooking book = new ClassBooking();
		
		book.setUserno(Integer.parseInt(req.getParameter("userno")));
		
		List<Map<String, Object>> booking = adminManageService.bookingList(book);
		
		
		
		
		//작성 후기 조회
		ReviewBoard reviewBoard = new ReviewBoard();
		
		reviewBoard.setUserno(Integer.parseInt(req.getParameter("userno")));
		
		List<Map<String, Object>> review = adminManageService.reviewList(reviewBoard);
		
		
		
		
		//작성 문의 조회
		AskBoard askBoard = new AskBoard();
		
		askBoard.setUserno(Integer.parseInt(req.getParameter("userno")));
		
		List<AskBoard> ask = adminManageService.askList(askBoard);
		
		
		
		//조회결과 model값 전달
		req.setAttribute("userInfo", userInfo);
		
		//조회결과 model값 전달
		req.setAttribute("booking", booking);
		
		//조회결과 model값 전달
		req.setAttribute("review", review);
		
		//조회결과 model값 전달
		req.setAttribute("ask", ask);
		
		
		
		//view 지정
		req.getRequestDispatcher("/WEB-INF/views/admin/user/UserView.jsp").forward(req, resp);
	
	
	}
	
}
