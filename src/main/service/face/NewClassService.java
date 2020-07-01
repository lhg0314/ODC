package main.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Paging;


public interface NewClassService {

	
	
	
	/**
	 * 신규클래스 불러오기
	 * @return
	 */
	List<Map<String, Object>> newclass();

	/**
	 * 인기클래스 불러오기
	 * @return
	 */
	List<Map<String, Object>> hotclass();

	
	/**
	 * 지역, 카테고리 변환
	 * @param cinfo
	 * @return
	 */
	List<Map<String, Object>> changeString(List<Map<String, Object>> cinfo);

	
	/**
	 * 인기클래스 - 선택한 카테고리만 보여주기
	 * @param category
	 * @return
	 */
	List<Map<String, Object>> hotClassBySelectedCate(int category);

	
	/**
	 * 신규클래스 - 선택한 카테고리만 보여주기
	 * @param category
	 * @return
	 */
	List<Map<String, Object>> newClassBySelectedCate(int category);

	
	/**
	 * 페이징
	 * @param req
	 * @param category
	 * @return
	 */
	Paging getPagingHot(HttpServletRequest req, int category);
	
	
	
	

}
