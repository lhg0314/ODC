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

}
