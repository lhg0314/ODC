package admin.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.ArtistDetail;
import dto.ArtistInfo;
import dto.AskBoard;
import dto.ClassBooking;
import dto.ClassInfo;
import dto.ReviewBoard;
import dto.UserInfo;
import util.Paging;

/* 
 * 200621 이서연
 */

public interface AdminManageService {
	
	/**
	 * 페이징 객체 생성
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPagingUser(HttpServletRequest req);
	

	/**
	 * 페이징 객체 생성
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPagingArt(HttpServletRequest req);
	
	
	/**
	 * 페이징 처리하여 보여질 사용자 목록만 조회
	 * @param paging
	 * @return List<UserInfo> - userInfo 조회 결과 리스트
	 */
	public List<UserInfo> selectAllUser(Paging paging);
	
	
	/**
	 * 페이징 처리하여 보여질 작가 목록만 조회
	 * @param paging
	 * @return List<ArtistInfo> - artistInfo 조회 결과 리스트
	 */
	public List<ArtistInfo> selectAllArt(Paging paging);
	
	
	/**
	 * 
	 * @param req - 전달파라미터
	 * @return UserInfo - userno 담긴 UserInfo
	 */
	public UserInfo selectUserno(HttpServletRequest req);
	
	
	/**
	 * userno로 예약한 클래스 조회
	 * @param book - userno 담긴 classbooking
	 * @return 클래스 정보
	 */
	public List<Map<String, Object>> bookingList(ClassBooking book);
	
	
	/**
	 * userno로 작성한 리뷰 조회
	 * @param review - userno 담긴 reviewboard
	 * @return 리뷰 정보
	 */
	public List<Map<String, Object>> reviewList(ReviewBoard review);
	
	
	/**
	 * userno로 작성한 문의 조회
	 * @param ask - userno 담긴 askboard
	 * @return 문의글 정보
	 */
	public List<Map<String, Object>> askList(AskBoard ask);
	
	
	/**
	 * 사업자 정보 가져오기
	 * @param req - 전달파라미터
	 * @return ArtistInfo - artno 담긴 ArtistInfo
	 */
	public ArtistInfo selectArtistno(HttpServletRequest req);
	
	
	/**
	 * 사업자 개설 클래스 가져오기
	 * @param classInfo
	 * @return
	 */
	public List<ClassInfo> classList(ClassInfo classInfo);

	
	
	/**
	 * 문의 댓글 조인해서 가져오기
	 * @param req
	 * @return
	 */
	public List<Map<String, Object>> askCommList(HttpServletRequest req);
	
}
