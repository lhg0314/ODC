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
 * 20200628 이인주
 * 후기 게시판 - 클래스 이름 검색 - 사진 후기 결과
 */
@WebServlet("/review/board/search/pho")
public class ReviewBoardSearchphoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewBoardService reviewboardService = new ReviewBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//검색 단어 가져오기 param 
		String classname = reviewboardService.getclassnameparam(req);
//		System.out.println("classname"+classname);
		
		//검색 결과 jsp로 넘기기
		req.setAttribute("classname",classname); 
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Pagingphoto paging = reviewboardService.getPagingreviewsearchpho(req,classname);
		
		//찾기(포토)
		ArrayList<Map<String, Object>> searchreviewboardpho  = reviewboardService.searchreviewboardpho(paging,classname);
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
		
		//후기게시판 넘기기
		req.setAttribute("searchreviewboardpho", searchreviewboardpho);
		
		//페이지 
		req.getRequestDispatcher("/WEB-INF/views/user/reviewboard/reviewboardsearchpho.jsp").forward(req,resp);
	}
	
	//클래스 이름 검색 결과 -사진
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//검색 단어 가져오기 param 
			String classname = reviewboardService.getclassnameparam(req);
//			System.out.println("classname"+classname);
			
			//검색 결과 jsp로 넘기기
			req.setAttribute("classname",classname); 
			
			//요청 파라미터를 전달하여 paging 객체 생성하기
			Pagingphoto paging = reviewboardService.getPagingreviewsearchpho(req,classname);
			
			//찾기(포토)
			ArrayList<Map<String, Object>> searchreviewboardpho  = reviewboardService.searchreviewboardpho(paging,classname);
			
			//페이징 결과 전달
			req.setAttribute("paging",paging); 
			
			//후기게시판 넘기기
			req.setAttribute("searchreviewboardpho", searchreviewboardpho);
			
			//페이지 
			req.getRequestDispatcher("/WEB-INF/views/user/reviewboard/reviewboardsearchpho.jsp").forward(req,resp);
		}
}
