package user.dao.face;

import java.util.List;
import java.util.Map;

import dto.ClassInfo;

public interface LocationDao {

	/**
	 * 지역별 클래스 모아보기
	 * @param location
	 * @return
	 */
	public List<Map<String, Object>> selectClassByLocation(int location);

}
