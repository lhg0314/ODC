package artist.dao.face;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import util.Paging;

public interface ArtistClassSalesDao {

	/**
	 * 로그인한 사업자  클래스 리스트  전체 조회
	 * @param artid
	 * @param artnowday 
	 * @return
	 */
	public ArrayList<Map<String, Object>> nowartsales(Paging paging,String artid, Date[] artnowday);

	/**
	 * 사업자별 페이징 개수 
	 * @param artnowday 
	 * @return
	 */
	public int selectCntAll( String artid, Date[] artnowday);

	/**
	 * 사업자별 현재달 총 금액
	 * @param artid
	 * @param artnowday
	 * @return
	 */
	public int nowtotalsales(String artid, Date[] artnowday);

	/**
	 * 사업자 달 선택 기준 리스트 
	 * @param artid
	 * @param chooseyearday
	 * @return
	 */
	public ArrayList<Map<String, Object>> choartsales(Paging paging,String artid, Date[] chooseyearday);

	/**
	 * 사용자 달 선택 마다 페이징 개수
	 * @param artid
	 * @param chooseyearday
	 * @return
	 */
	public int choselectCntAll(String artid, Date[] chooseyearday);

	/**
	 * 선택한 달 기간 따라 총 수익
	 * @param artid
	 * @param chooseyearday
	 * @return
	 */
	public int choartsalestot(String artid, Date[] chooseyearday);

	/**
	 * 각 사업자가 검색한 클래스 이름 리스트
	 * @param artid
	 * @param classname
	 * @return
	 */
	public ArrayList<Map<String, Object>> choartsalessearch(String artid, String classname);

}
