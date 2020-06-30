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

import dto.UserInfo;
import user.service.face.UserInfoUpdateService;
import user.service.face.UserMyPageClassService;
import user.service.impl.UserInfoUpdateServiceImpl;
import user.service.impl.UserMyPageClassServiceImpl;
import util.Paging;

// 20200624 이인주
// 마이페이지 - class - Booking 
// 클래스 예약 확인 
@WebServlet("/mypage/class/booking")
public class MypageClassBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserMyPageClassService usermypageclassService = new UserMyPageClassServiceImpl();
	private UserInfoUpdateService userUpdateService = new UserInfoUpdateServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사용자로 로그인한 아이디값 가져오기
		HttpSession session = req.getSession();
		
		// 세션으로 사용자 아이디값 불러서 변수에 저장하기
		String  userid = (String)session.getAttribute("userid");
		
		//사용자  아이디  jsp로 넘기기
		req.setAttribute("userid", userid);
		
		 //UserInfo 객체 만들어서 id 넣어주기
	      UserInfo u = new UserInfo();
	      u.setUserid((String)session.getAttribute("userid"));
	       
	      //UserInfo 싹 가져오기
	      UserInfo uinfo = userUpdateService.userInfoLoad(u);
	      int grade = uinfo.getUsergrade();
	      
	      //결과 전달
	      req.setAttribute("grade", grade);
		
		//현재 날짜 받아오기
		Date nowday = usermypageclassService.nowday();
		
		//요청 파라미터를 전달하여 paging 객체 생성하기
		Paging paging = usermypageclassService.bookingPaging(req,userid,nowday);
		
		//사용자 예약 리스트  전체 조회
		ArrayList<Map<String, Object>> userbooking  = usermypageclassService.userbooking(paging,userid,nowday);
		
		//페이징 결과 전달
		req.setAttribute("paging",paging); 
		
		//사용자 예약 리스트  전체 조회 jsp로 넘기기
		req.setAttribute("userbooking", userbooking);
				
		req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/classbooking.jsp").forward(req,resp);
				
				
	}

}
