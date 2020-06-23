package artist.service.face;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Paging;

public interface ArtistClassSalesService {

	/**
	 * 로그인한 사업자  클래스 리스트  전체 조회 
	 * @param artid
	 * @param artnowday 
	 * @return
	 */
	public ArrayList<Map<String, Object>> nowartsales(Paging paging ,String artid, Date[] artnowday);

	/**
	 * 사업자별 페이징 now
	 * @param req
	 * @param artid
	 * @param artnowday 
	 * @return
	 */
	public Paging getPaging(HttpServletRequest req, String artid, Date[] artnowday);

	/**
	 * 현재 년월 
	 * @param req
	 * @return
	 */
	public Date[] nowyearday();

	/**
	 * 현재 달 기준 총 금액
	 * @param artid
	 * @param artnowday 
	 * @return
	 */
	public int nowartsalestot(String artid, Date[] artnowday);

	/**
	 * 선택한 달 파라미터 값 빼오기
	 * @param req
	 * @return
	 */
	public int getparmmonth(HttpServletRequest req);

	/**
	 * 선택한 달 
	 * @param month
	 * @return
	 */
	public Date[] chooseyearday(int month);

	/**
	 * 선택한 달 기준 리스트 
	 * @param artid
	 * @param chooseyearday
	 * @return
	 */
	public ArrayList<Map<String, Object>> choartsales(Paging paging,String artid, Date[] chooseyearday);

	/**
	 * 사업자 달 선택 페이징
	 * @param req
	 * @param artid
	 * @param chooseyearday
	 * @return
	 */
	public Paging chogetPaging(HttpServletRequest req, String artid, Date[] chooseyearday);

	/**
	 * 선택한 달 기준 총 금액
	 * @param artid
	 * @param chooseyearday
	 * @return
	 */
	public int choartsalestot(String artid, Date[] chooseyearday);

	/**
	 * 검색한 클래스 이름 파라미터 값 빼오기
	 * @param req
	 * @return
	 */
	public String classnameparam(HttpServletRequest req);

	/**
	 * 각 사업자가 검색한 클래스 이름 리스트
	 * @param artid
	 * @param classname
	 * @return
	 */
	public ArrayList<Map<String, Object>> choartsalessearch(String artid, String classname);

	/**
	 * 사업자에서 클래스 이름으로 검색한 페이징
	 * @param req
	 * @param artid
	 * @param classname
	 * @return
	 */
	public Paging searchgetPaging(HttpServletRequest req, String artid, String classname);

	/**
	 * 사업자에서 클래스 이름으로 검색한 각 클래스당 총 매출
	 * @param artid
	 * @param classname
	 * @return
	 */
	public int searchclassnametotal(String artid, String classname);

}
