package user.dao.face;
import java.util.Map;

import dto.ClassBooking;
import dto.UserInfo;

public interface UserClassPaymentDao {

	/**
	 * 사용자 정보 가지고 오기 
	 * @param userid
	 * @return
	 */
	public UserInfo userinfo(String userid);

	/**
	 * 예약할 클래스 정보가지고오기
	 * @param classno
	 * @return
	 */
	public Map<String, Object> classpayment(ClassBooking userclasspayment, UserInfo userinfo);


}
