package user.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.ClassInfo;

public interface LocationCategoryService {

	/**
	 * 지역별 클래스 페이지
	 * @param location
	 * @return
	 */
	public List<Map<String, Object>> selectClassByLocation(int location);

	/**
	 * 지역별 처리
	 * @return
	 */
	public String getLocation(HttpServletRequest req, int location);

	/**
	 * 카테고리별 처리
	 * @param req
	 * @param category
	 * @return
	 */
	public String getCategory(HttpServletRequest req, int category);

	/**
	 * 카테고리별 클래스 페이지
	 * @param category
	 * @return
	 */
	public List<Map<String, Object>> selectClassByCategory(int category);

}
