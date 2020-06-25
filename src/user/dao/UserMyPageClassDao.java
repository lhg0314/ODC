package user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public interface UserMyPageClassDao {

	/**
	 * 사용자 예약 리스트  전체 조회
	 * @param userid
	 * @param nowday
	 * @return
	 */
	public ArrayList<Map<String, Object>> userbooking(String userid, Date nowday);

	/**
	 * 사용자 예약 리스트  선택 삭제
	 * @param userid
	 * @param bookingno
	 * @return
	 */
	public int bookingcancel(int bookingno);

	/**
	 * 사용자 아이디별 장바구니 전체 조회
	 * @param userid
	 * @return
	 */
	public ArrayList<Map<String, Object>> userwish(String userid);

	/**
	 * wishno 삭제
	 * @param userid
	 * @param wishno
	 */
	public void wishcancel(int wishno);

	/**
	 * 결제 정보 불러오기
	 * @param userid
	 * @param wishno
	 * @return
	 */
	public Map<String, Object> classpayment(String userid, int wishno);

}
