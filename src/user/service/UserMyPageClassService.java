package user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface UserMyPageClassService {

	/**
	 * 현재 날짜 가져오기
	 * @return
	 */
	public Date nowday();

	/**
	 * 사용자 예약 리스트  전체 조회
	 * @param userid
	 * @param nowday
	 * @return
	 */
	public ArrayList<Map<String, Object>> userbooking(String userid, Date nowday);

	/**
	 * 삭제할  bookingno 파람에서 뽑기
	 * @param req
	 * @return
	 */
	public int bookingnoparam(HttpServletRequest req);

	/**
	 * 사용자 예약 리스트  선택 삭제
	 * @param userid
	 * @param bookingno
	 * @return
	 */
	public int bookingcancel(int bookingno);

}
