//20200624 이인주
// 마이페이지 - 클래스 예약 취소하기

package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/mypage/classbooking/cancel")
public class MypageClassBookingCancelServlet extends HttpServlet {
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
		
		//쿼리스트링으로 받은 클래스번호 뽑아오기 
		int bookingno = usermypageclassService.bookingnoparam(req);
		
		//사용자 예약 리스트  선택 삭제
		int bookingcancel  = usermypageclassService.bookingcancel(bookingno);
		
		//성공 삭제하면 예약 클래스 리스트로 돌아가기
		
		String msg = "";
		String url = "";
		if(bookingcancel > 0) {
			msg = "클래스 예약 취소하였습니다";
		}else {
			msg = "클래스 예약 취소에 실패했습니다 다시 시도해주세요";
		}
		url = "/mypage/class/booking";
		
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		
		req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/alert.jsp").forward(req,resp);
	}

}
