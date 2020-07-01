package main.dao.face;

import java.util.List;
import java.util.Map;

import util.Pagingphoto;

public interface LocationCategoryDao {

	/**
	 * 지역별 클래스 모아보기
	 * @param paging 
	 * @param location
	 * @return
	 */
	public List<Map<String, Object>> selectClassByLocation(Pagingphoto paging, int location);

	/**
	 * 카테고리별 클래스 모아보기
	 * @param paging 
	 * @param category
	 * @return
	 */
	public List<Map<String, Object>> selectClassByCategory(Pagingphoto paging, int category);

	/**
	 * 재능기부 클래스 모아보기
	 * @param category 
	 * @return
	 */
	public List<Map<String, Object>> selectClassByTalentDonation(int category);

	/**
	 * 지역별 페이지 페이징
	 * @param location 
	 * @return
	 */
	public int selectCntAllLocation(int location);

	/**
	 * 카테고리 페이지 페이징
	 * @param category
	 * @return
	 */
	public int selectCntAllCategory(int category);

	/**
	 * 재능기부 페이징
	 * @param i
	 * @return
	 */
	public int selectCntAllTalent(int i);

}
