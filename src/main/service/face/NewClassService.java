package main.service.face;

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
	
	

}
