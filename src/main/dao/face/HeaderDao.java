package main.dao.face;

import java.util.List;
import java.util.Map;

public interface HeaderDao {

	/**
	 * 클래스 인기 순위 탑 5
	 * @return
	 */
	public List<Map<String, Object>> hotclassTopFive();

}
