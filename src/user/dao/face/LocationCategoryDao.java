package user.dao.face;

import java.util.List;
import java.util.Map;

import dto.ClassInfo;

public interface LocationCategoryDao {

	/**
	 * 지역별 클래스 모아보기
	 * @param location
	 * @return
	 */
	public List<Map<String, Object>> selectClassByLocation(int location);

	/**
	 * 카테고리별 클래스 모아보기
	 * @param category
	 * @return
	 */
	public List<Map<String, Object>> selectClassByCategory(int category);

	/**
	 * 재능기부 클래스 모아보기
	 * @param category 
	 * @return
	 */
	public List<Map<String, Object>> selectClassByTalentDonation(int category);

}
