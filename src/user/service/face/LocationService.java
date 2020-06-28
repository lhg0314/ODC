package user.service.face;

import java.util.List;
import java.util.Map;

import dto.ClassInfo;

public interface LocationService {

	/**
	 * 지역별 클래스 페이지
	 * @param location
	 * @return
	 */
	public List<Map<String, Object>> selectClassByLocation(int location);

}
