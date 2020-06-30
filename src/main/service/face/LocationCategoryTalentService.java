package main.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.ClassInfo;
import util.Paging;

public interface LocationCategoryTalentService {

	/**
	 * 지역별 클래스 페이지
	 * @param paging 
	 * @param location
	 * @return
	 */
	public List<Map<String, Object>> selectClassByLocation(Paging paging, int location);

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
	 * @param paging 
	 * @param category
	 * @return
	 */
	public List<Map<String, Object>> selectClassByCategory(Paging paging, int category);

	/**
	 * 재능기부 클래스 페이지
	 * @param category 
	 * @return
	 */
	public List<Map<String, Object>> selectClassByTalentDonation(int category);

	/**
	 * 지역별 페이지 페이징
	 * @param req
	 * @param location 
	 * @return
	 */
	public Paging getPagingLocation(HttpServletRequest req, int location);

	/**
	 * 카테고리 페이지 페이징
	 * @param req
	 * @param category
	 * @return
	 */
	public Paging getPagingCategory(HttpServletRequest req, int category);

	/**
	 * 재능기부 페이지 페이징
	 * @param req
	 * @param i 
	 * @return
	 */
	public Paging getPagingTalent(HttpServletRequest req, int i);

}
