package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.UserMyPageClassServiceImpl;
import user.service.face.UserMyPageClassService;

/**
 * 20200625 이인주
 * 마이페이지 - 장바구니 - 삭제 
 */
@WebServlet("/mypage/class/wish/cancel")
public class MypageClassWishCencelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserMyPageClassService usermypageclassService = new UserMyPageClassServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자로 로그인한 아이디값 가져오기
		HttpSession session = req.getSession();
		
		// 세션으로 사용자 아이디값 불러서 변수에 저장하기
		String  userid = (String)session.getAttribute("userid");
		
		//사용자  아이디  jsp로 넘기기
		req.setAttribute("userid", userid);
		
		//쿼리스트링으로 받은 wishno 뽑아오기 
		int wishno = usermypageclassService.wishnoparam(req);
		
		//사용자 예약 리스트  선택 삭제
		usermypageclassService.wishcancel(wishno);
		
		//성공 삭제하면 예약 클래스 리스트로 돌아가기
		resp.sendRedirect("/mypage/class/wish");
		
		
	}

}
