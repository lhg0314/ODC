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
 * 20200625 이인주
 * 마이페이지 - 클래스 - 장바구니
 */
@WebServlet("/mypage/class/wish")
public class MyPageClassWishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserMyPageClassService usermypageclassService = new UserMyPageClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//사용자로 로그인한 아이디값 가져오기
		HttpSession session = req.getSession();
		
		// 세션으로 사용자 아이디값 불러서 변수에 저장하기
		String  userid = (String)session.getAttribute("userid");
		
		//사용자  아이디  jsp로 넘기기
		req.setAttribute("userid", userid);
		
		//장바구니 리스트 전체 조회
		ArrayList<Map<String, Object>> userwish  = usermypageclassService.userwish(userid);
		
		//장바구니 리스트 전체 조회 jsp로 넘기기
		req.setAttribute("userwish", userwish);
				
		req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/classwish.jsp").forward(req,resp);
	
	
	}

}
