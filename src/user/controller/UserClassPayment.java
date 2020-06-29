package user.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ClassBooking;
import dto.ClassInfo;
import dto.UserInfo;
import user.service.face.UserClassPaymentService;
import user.service.face.UserInfoUpdateService;
import user.service.face.UserMyPageClassService;
import user.service.impl.UserClassPaymentServiceImpl;
import user.service.impl.UserInfoUpdateServiceImpl;
import user.service.impl.UserMyPageClassServiceImpl;

/**
 * 20200629 이인주
 * 디테일 클래스  - 예약하기 
 * 
 */
@WebServlet("/userclass/payment")
public class UserClassPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoUpdateService userUpdateService = new UserInfoUpdateServiceImpl();
	private UserClassPaymentService userclasspaymentService = new UserClassPaymentServiceImpl();
	private UserMyPageClassService usermypageclassService = new UserMyPageClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test inju");
		
		//사용자로 로그인한 아이디값 가져오기
		HttpSession session = req.getSession();
		
		// 세션으로 사용자 아이디값 불러서 변수에 저장하기
		String  userid = (String)session.getAttribute("userid");
		
		//사용자  아이디  jsp로 넘기기
		req.setAttribute("userid", userid);
		
	   //UserInfo 객체 만들어서 id 넣어주기
       UserInfo u = new UserInfo();
       u.setUserid((String)session.getAttribute("userid"));
       
       //UserInfo  가져오기
       UserInfo uinfo = userUpdateService.userInfoLoad(u);
       int grade = uinfo.getUsergrade();
      
       //결과 전달
       req.setAttribute("grade", grade);
		
       //사용자 정보 가지고오기
       UserInfo userinfo = userclasspaymentService.userinfo(userid);
       
       //쿼리스트링 파라미터 값 빼오기
       ClassBooking userclasspayment  = userclasspaymentService.userclasspayment(req);	
       
       //예약할 클래스 no
       int classno = userclasspayment.getClassno();
       
       //예약할 사람 no
       int userno = userclasspayment.getUserno();
       
       //예약할 class정보/ art정보 / classfile-main 가지고오기 + userinfo
       Map<String, Object> classpayment  = userclasspaymentService.classpayment(userclasspayment,userinfo);	
       
       
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
			
	 req.getRequestDispatcher("/WEB-INF/views/user/mypage/class/classpaymentgo.jsp").forward(req,resp);
		
	}
	
	//결제 완료 ajax
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//사용자로 로그인한 아이디값 가져오기
			HttpSession session = req.getSession();
			
			// 세션으로 사용자 아이디값 불러서 변수에 저장하기
			String  userid = (String)session.getAttribute("userid");
			
			//사용자  아이디  jsp로 넘기기
			req.setAttribute("userid", userid);
			
			  //UserInfo 객체 만들어서 id 넣어주기
		       UserInfo u = new UserInfo();
		       u.setUserid((String)session.getAttribute("userid"));
		       
		       //UserInfo  가져오기
		       UserInfo uinfo = userUpdateService.userInfoLoad(u);
		       int grade = uinfo.getUsergrade();
		      
		       //결과 전달
		       req.setAttribute("grade", grade);
			
			//사용자 userno 가져오기
			int userno = usermypageclassService.userno(userid);
			
			//classbookingno 알아오기
			int classbookingno = usermypageclassService.classbookingno();
			
			//ajax가 보낸 파라미터 값 받기
			Map<String,Object> paymentparam = usermypageclassService.paymentparam(req);
			
		
			//classbooking에 넣기
			usermypageclassService.insertclassbooking(classbookingno,userno,paymentparam);
			
		}

}
