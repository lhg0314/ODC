package user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.face.ReviewBoardService;
import user.service.impl.ReviewBoardServiceImpl;
import util.Pagingphoto;

/**
 * 20200627 이인주
 * 메인 - 메뉴바 - 후기게시판(포토)
 */
@WebServlet("/review/board")
public class ReviewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewBoardService reviewboardService = new ReviewBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Pagingphoto paging = reviewboardService.getPagingreview(req);
		
		//후기게시판  전체 조회
		ArrayList<Map<String, Object>> reviewboard  = reviewboardService.reviewboard(paging);
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
		
		//후기게시판 넘기기
		req.setAttribute("reviewboard", reviewboard);
		
		req.getRequestDispatcher("/WEB-INF/views/user/reviewboard/reviewboard.jsp").forward(req,resp);
		
	}
	

}
