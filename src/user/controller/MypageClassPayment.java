package user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.UserMyPageClassService;
import user.service.UserMyPageClassServiceImpl;

//20200625 이인주
//마이페이지 - 장바구니 - 결제내용 확인
@WebServlet("/mypage/class/payment")
public class MypageClassPayment extends HttpServlet {
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
		

		
		//결제할 리스트 전체 조회 (결제할 사람 정보, 결제할 클래스 사업자 정보, 결제할 내용)
		Map<String, Object> classpayment  = usermypageclassService.classpayment(userid,wishno);	
		
		//주소 잘라서 가져오기
		String addr = (String)classpayment.get("artaddr");
		
		String addr1 = (addr.split(";").length > 0)?addr.split(";")[0]:"";
	    String addr2 = (addr.split(";").length > 1)?addr.split(";")[1]:"";
	    String addr3 = (addr.split(";").length > 2)?addr.split(";")[2]:"";
	       
	    //결과 전달
       req.setAttribute("addr2", addr2);
       req.setAttribute("addr3", addr3);
		
		
		//결제할 리스트 전체 조회 (결제할 사람 정보, 결제할 클래스 사업자 정보, 결제할 내용) jsp로 넘기기
		req.setAttribute("classpayment", classpayment);
				
		req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/classpayment.jsp").forward(req,resp);
	
	}
	
}
