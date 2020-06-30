package main.dao.face;

import java.util.List;
import java.util.Map;


public interface NewClassDao {

	/**
	 * 신규 클래스 불러오기
	 * @return
	 */
	List<Map<String, Object>> newclass();

	/**
	 * 인기 클래스 불러오기
	 * @return
	 */
	List<Map<String, Object>> hotclass();

	
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

}
