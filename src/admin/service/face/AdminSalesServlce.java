
// 이인주 20200621 관리자 사업자 수익 확인 
package admin.service.face;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Paging;

public interface AdminSalesServlce {
	
	/**기본
	 * 페이징
	 * @param req
	 * @return
	 */
	public Paging getPaging(HttpServletRequest req);
	
	/**
	 * now 페이징
	 * @param req
	 * @return
	 */
	public Paging nowgetPaging(HttpServletRequest req,Date[] nowyearday);
	
	
	/**
	 * cho 페이징
	 * @param req
	 * @return
	 */
	public Paging chogetPaging(HttpServletRequest req, Date[] chooseyearday);
	
	/**
	 * artidnow 페이징
	 * @param req
	 * @return
	 */
	public Paging artidnowgetPaging(HttpServletRequest req, String artid, Date[] nowyearday);
	
	/**
	 * artsearchcho 페이징
	 * @param req
	 * @return
	 */
	public Paging artsearchchoPaging(HttpServletRequest req, String artid, Date[] chooseyearday);
	
	/**
	 * 현재 페이징 처리된 리스트
	 * @param paging
	 * @return
	 */
	public ArrayList<Map<String, Object>> nowselectadminsaleslistAll(Paging paging, Date[] nowyearday);
	
	/**
	 * 선택한 페이징 처리된 리스트
	 * @param paging
	 * @return
	 */
	public ArrayList<Map<String, Object>> choselectadminsaleslistAll(Paging paging, Date[] chooseyearday);

	/**
	 * month 값 param
	 * @param req
	 * @return
	 */
	public int getparmmonth(HttpServletRequest req);
	
	/**
	 * 현재 년월 
	 * @param req
	 * @return
	 */
	public Date[] nowyearday();
	
	/**
	 * 선택한 년월
	 * @param month
	 * @return
	 */
	public Date[] chooseyearday(int month);

	
	/**
	 * 현재 페이징처리한 사업자 전체 매출 리스트 조회
	 * @return
	 */
	public ArrayList<Map<String, Object>> nowselectartsaleslistAll(Paging paging,Date[] nowyearday);
	
	/**
	 * 달 선택하고  페이징처리한 사업자 전체 매출 리스트 조회
	 * @param paging
	 * @param nowyearday
	 * @return
	 */
	public ArrayList<Map<String, Object>> choselectartsaleslistAll(Paging paging,Date[] chooseyearday);

	/**
	 * 검색한 사용자 아이디 파라미터값 꺼내기
	 * @param req
	 * @return
	 */
	public String searchidparam(HttpServletRequest req);
	
	
	/**
	 * 현재
	 * 페이징 처리한 사용자 아이디 검색 클래스 리스트  전체 조회
	 * @param paging
	 * @param artid
	 * @return
	 */
	public ArrayList<Map<String, Object>> nowartsearchlist(Paging paging,String artid,Date[] nowyearday);
	
	
	/**
	 * 선택 달
	 * 페이징 처리한 사용자 아이디 검색 클래스 리스트  전체 조회
	 * @param paging
	 * @param artid
	 * @return
	 */
	public ArrayList<Map<String, Object>> choartsearchlist(Paging paging,String artid,Date[] chooseyearday);

	/**
	 *  사업자 관리자
	 *  현재 달 총 수익금
	 * @param nowyearday
	 * @return
	 */
	public int nowtotalsales(Date[] nowyearday);
	
	/**
	 *  사업자 관리자
	 *  선택 달 총 수익금
	 * @param chooseyearday
	 * @return
	 */
	public int chototalsales(Date[] chooseyearday);

	/**
	 * 각 사업자 
	 * 현재 달 총 수익금
	 * @param nowyearday
	 * @return
	 */
	public int nowsearchtotalsales(String artid,Date[] nowyearday);

	/**
	 * 각 사업자 
	 * 선택 달 총 수익금
	 * @param artid
	 * @param chooseyearday
	 * @return
	 */
	public int chosearchtotalsales(String artid, Date[] chooseyearday);

	

	

	

	

	
		
}
