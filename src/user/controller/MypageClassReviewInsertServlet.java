package user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.face.UserMyPageClassService;
import user.service.impl.UserMyPageClassServiceImpl;

/**
 * 202006527 이인주
 * 마이페이지 - 수강클래스 - 후기작성하기
 */
@WebServlet("/mypage/class/review/insert")
public class MypageClassReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserMyPageClassService usermypageclassService = new UserMyPageClassServiceImpl();
	
	//후기작성 form
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//쿼리스트링의 bookingno 받아오기
		int bookingno = usermypageclassService.bookingno(req);
		
		//후기를 작성했는지 판단
		int reviewcount = usermypageclassService.reviewcount(bookingno);
		
		//bookingno로 된 후기를 작성했다면 alert 아니면 후기작성 form
		String msg = "";
		String url = "";
		if(reviewcount >= 1) {
			msg = "이미 작성한 후기입니다. 클래스 수강후기에서 확인가능합니다.";
			url = "/mypage/class/signup";
		
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			
			req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/alert.jsp").forward(req,resp);
			
		}
		
		//사용자로 로그인한 아이디값 가져오기
		HttpSession session = req.getSession();
		
		// 세션으로 사용자 아이디값 불러서 변수에 저장하기
		String  userid = (String)session.getAttribute("userid");
		
		//userno 구하기
		int userno = usermypageclassService.userno(userid);
		
		//세션에 userno 저장하기
		session.setAttribute("userno", userno);
		
		//사용자  아이디  jsp로 넘기기
		req.setAttribute("userid", userid);
		
		//쿼리스트링의 classno 받아오기
		int classno = usermypageclassService.classno(req);
		
		//세션에 classno 저장
		session.setAttribute("classno", classno);
		
		//세션에 bookingno 저장
		session.setAttribute("bookingno", bookingno);
		
		req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/classreview.jsp").forward(req,resp);
				
				
	}
	
	
	//작성 후기  내용 insert
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사용자로 로그인한 아이디값 가져오기
		HttpSession session = req.getSession();
				
		//세션으로 사용자 번호 받아오기
		int  userno = (int)session.getAttribute("userno");
		
		//세션에서 classno 가져오기
		int classno = (int)session.getAttribute("classno");
		
		//세션에 bookingno 저장
		int bookingno = (int)session.getAttribute("bookingno");
		
		//생성될 reviewboardno
		int reviewboardno = usermypageclassService.reviewboardno();
		
		//후기 작성하기 (insert) - revewboard
		usermypageclassService.insertreview(req,resp,userno,classno,bookingno,reviewboardno);
		
		//완료후 페이지 이동
		resp.sendRedirect("/mypage/class/signup");
		
		
	}

}
