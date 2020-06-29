package main.service.face;

import java.util.List;
import java.util.Map;

public interface HeaderService {

	/**
	 * 클래스 top5
	 * @return
	 */
	public List<Map<String, Object>> hotclassTopFive();

}
