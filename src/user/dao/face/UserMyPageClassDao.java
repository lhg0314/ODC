package user.dao.face;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import dto.ReviewBoard;
import dto.ReviewFile;
import util.Paging;

public interface UserMyPageClassDao {

	/**
	 * 사용자 예약 리스트  전체 조회
	 * @param paging 
	 * @param userid
	 * @param nowday
	 * @return
	 */
	public ArrayList<Map<String, Object>> userbooking(Paging paging, String userid, Date nowday);

	/**
	 * 사용자 예약 리스트  선택 삭제
	 * @param userid
	 * @param bookingno
	 * @return
	 */
	public int bookingcancel(int bookingno);

	/**
	 * 사용자 아이디별 장바구니 전체 조회
	 * @param paging 
	 * @param userid
	 * @return
	 */
	public ArrayList<Map<String, Object>> userwish(Paging paging, String userid);

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

	/**
	 * userno 가져오기
	 * @param userid
	 * @return
	 */
	public int userno(String userid);

	/**
	 * classbookingno 가져오기
	 * @return
	 */
	public int classbookingno();

	/**
	 * classbooking 결제 완료후 insert
	 * @param classbookingno
	 * @param userno
	 * @param paymentparam
	 */
	public void insertclassbooking(int classbookingno, int userno, Map<String, Object> paymentparam);

	/**
	 * 사용자 예약 리스트  전체 조회
	 * @param paging 
	 * @param userid
	 * @param nowday
	 * @return
	 */
	public ArrayList<Map<String, Object>> usersignup(Paging paging, String userid, Date nowday);

	/**
	 * reviewboardno 
	 * @return
	 */
	public int reviewboardno();
	
	/**
	 * 후기작성여부 판단
	 * @param bookingno
	 * @return
	 */
	public int reviewcount(int bookingno);

	/**
	 * insert reviewboard
	 * @param reviewboard
	 */
	public void insertreviewboard(ReviewBoard reviewboard);

	/**
	 * insert reviewfile
	 * @param reviewfile
	 */
	public void insertreviewfile(ReviewFile reviewfile);

	/**
	 * 마이페이지 - 클래스 예약 페이징
	 * @param userid
	 * @param nowday
	 * @return
	 */
	public int bookingselectCntAll(String userid, Date nowday);

	/**
	 * 마이페이지 위시리스트 페이징
	 * @param userid
	 * @return
	 */
	public int wishselectCntAll(String userid);

	/**
	 * 마이페이지 수강한 클래스 페이징
	 * @param userid
	 * @param nowday
	 * @return
	 */
	public int signupselectCntAll(String userid, Date nowday);

	

}
