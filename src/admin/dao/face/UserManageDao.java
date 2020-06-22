package admin.dao.face;

import java.util.List;
import java.util.Map;

import dto.AskBoard;
import dto.ClassBooking;
import dto.ReviewBoard;
import dto.UserInfo;
import util.Paging;

/* 
 * 200620 이서연
 */

public interface UserManageDao {
	
	
	/**
	 * 총 사용자 수 조회
	 * @return - 전체 사용자 수
	 */
	public int selectCntAllUser(String search);
	
	
	/**
	 * 페이징 대상 게시글 목록 조회
	 * @param paging - 페이징 정보 객체
	 * @return List<UserInfo> - userInfo 조회결과 리스트
	 */
	public List<UserInfo> selectAllUser(Paging paging);
	

	/**
	 * userno 를 통한 userInfo 조회
	 * @param userInfo
	 * @return UserInfo
	 */
	public UserInfo selectByUserno(UserInfo userInfo);
	
	
	
	/**
	 * userno로  에약된클래스 조회
	 * @param booking - userno 담긴 ClasBooking 객체
	 * @return - 예약정보 
	 */
	public List<Map<String, Object>> bookingList(ClassBooking book);
	
	
	/**
	 * userno로 작성한 후기 조회
	 * @param review
	 * @return - 작성한 리뷰
	 */
	public List<Map<String, Object>> reviewList(ReviewBoard review);
	
	
	/**
	 * userno로 작성한 문의 조회
	 * @param ask
	 * @return
	 */
	public List<AskBoard> askList(AskBoard ask);
	
	
}
