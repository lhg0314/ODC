package admin.dao.face;

import java.util.List;
import java.util.Map;

import dto.ClassInfo;
import util.Paging;

/*
 * 클래스 검토 & 게시/삭제 DAO
 */
public interface ClassCheckPostDao {

	// 페이징 처리를 위한 메소드
	/**
	 * 전체 클래스 totolcount
	 * @param search
	 * @return
	 */
	public int selectCntAll(String search);
	
	/**
	 * 검토 클래스 totalCount
	 * @param search
	 * @return
	 */
	public int selectCntclassCheck(String search);
	
	/**
	 * 클래스별 예약 현황 totalCount
	 * @param search
	 * @return
	 */
	public int selectCntBookingClass(int classno);

	/**
	 * 클래스 리스트 불러오기
	 * @return - classinfo list
	 */
	public List<Map<String, Object>> selectAllClass(Paging paging);

	/**
	 * 검토 클래스만 불러오기
	 * @param paging
	 * @return
	 */
	public List<Map<String, Object>> selectAllClassCheck(Paging paging);
	
	/**
	 * 클래스 상세정보 
	 * @param classno
	 * @return 클래스 정보 map
	 */
	public Map<String, Object> selectClassByClassNo(int classno);
	
	/**
	 * 클래스 게시 상태 변경 
	 * @param classInfo
	 */
	public void updatePostStatus(ClassInfo classInfo);
	
	/**
	 * 클래스 검토 상태 변경
	 * @param classInfo
	 */
	public void updateClassCheck(ClassInfo classInfo);

	/**
	 * 클래스별 예약 현황 조회하기
	 * @param paging
	 * @param classno
	 * @return - 예약 리스트
	 */
	public List<Map<String, Object>> selectClassBookingByClassNo(Paging paging, int classno);

	/**
	 * 클래스 리뷰 페이징 처리
	 * @param classno
	 * @return
	 */
	public int selectCntClassReview(int classno);

	/**
	 * 클래스별 리뷰 가져오기
	 * @param paging
	 * @param classno
	 * @return
	 */
	public List<Map<String, Object>> selectClassReviewByClassNo(Paging paging, int classno);



}
