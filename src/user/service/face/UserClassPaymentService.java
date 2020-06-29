package user.service.face;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.ClassBooking;
import dto.ClassInfo;
import dto.UserInfo;

public interface UserClassPaymentService{

	/**
	 * 사용자 정보 가지고오기
	 * 
	 * @param userid
	 * @return
	 */
	public UserInfo userinfo(String userid);

	/**
	 * 클래스에서 바로 예약하기 정보 파람
	 * @param req
	 * @return
	 */
	public ClassBooking userclasspayment(HttpServletRequest req);

	

	/**
	 * 예약할 클래스 정보 가지고오기 (모든거 세팅)
	 * @param userid 
	 * @param classno
	 * @return
	 */
	public Map<String, Object> classpayment(ClassBooking userclasspayment, UserInfo userinfo);
	
	
}
