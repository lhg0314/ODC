package main.service;

import java.util.List;
import java.util.Map;


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
	
	

}
