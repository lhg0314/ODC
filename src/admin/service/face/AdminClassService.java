package admin.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.ClassFile;
import dto.ClassInfo;
import util.Paging;

public interface AdminClassService {

	// 페이징 처리
	public Paging getPagingPostClass(HttpServletRequest req);
	public Paging getPagingCheckClass(HttpServletRequest req);
	public Paging getPagingBookingClass(HttpServletRequest req, int classno);

	/*
	 * 모든 클래스 리스트 보여주기
	 */
	public List<Map<String, Object>> selectAllClass(Paging paging);

	/*
	 * 검토 클래스 보여주기
	 */
	public List<Map<String, Object>> selectAllClassCheck(Paging paging);
	
	/**
	 * 클래스 상세 정보 불러오기
	 * @param classno
	 * @return map - 클래스 상세정보 맵
	 */
	public Map<String, Object> selectClassByClassNo(int classno);
	
	/*
	 * 클래스 게시 상태 변경하기
	 */
	public void updatePostStatus(ClassInfo classInfo);
	
	/**
	 * 클래스 검토 상태 변경
	 * @param classInfo
	 */
	public void updateClassCheck(ClassInfo classInfo);
	
	/**
	 * 클래스별 예약 현황 조회
	 * @param paging - 페이징 객체
	 * @return - 예약 현황 list
	 */
	public List<Map<String, Object>> selectClassBookingByClassNo(Paging paging, int classno);
	
	/**
	 * 클래스 상세보기 리뷰페이지 페이징
	 * @param req
	 * @param classno 
	 * @return
	 */
	public Paging getPagingClassReview(HttpServletRequest req, int classno);
	
	/**
	 * 클래스별 후기 리스트 가져오기
	 * @param paging
	 * @param classno
	 * @return
	 */
	public List<Map<String, Object>> selectClassReviewByClassNo(Paging paging, int classno);
	

}
