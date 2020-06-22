// 이인주 20200621 관리자 사업자 수익 확인 

package admin.dao.face;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import util.Paging;

public interface AdminSalesDao {
	
	/**
	 * 총 게시글 수 조회
	 * @return
	 */
	public int selectCntAll();
	
	/**
	 * adminsales
	 * 총 게시글 수 조회
	 * @return
	 */
	public int nowselectCntAll(Date[] nowyearday);
	
	/**
	 * admincho
	 * 총 게시글 수 조회
	 * @return
	 */
	public int choselectCntAll(Date[] chooseyearday);
	
	/**
	 * artidnow
	 * 총 게시글 수 조회
	 * @return
	 */
	public int artidnowselectCntAll(String artid, Date[] nowyearday);
	
	/**
	 * artsearchcho
	 * 총 게시글 수 조회
	 * @return
	 */
	public int artsearchchoselectCntAll(String artid, Date[] chooseyearday);
	
	/**
	 * 현재 페이징 대상 관리자 게시글 목록 조회
	 * @param paging 페이징 정보 객체
	 * @return List<Board> 조회된 게시글 목록  
	 */
	public ArrayList<Map<String, Object>> nowselectadminsaleslistAll(Paging paging,Date[] nowyearday);
	
	/**
	 *선택한  페이징 대상 관리자  게시글 목록 조회
	 * @param paging 페이징 정보 객체
	 * @return List<Board> 조회된 게시글 목록  
	 */
	public ArrayList<Map<String, Object>> choselectadminsaleslistAll(Paging paging,Date[] chooseyearday);

	
	/**
	 * 현재 페이징 처리된 사업자 전체 매출 리스트 조회
	 * @param paging
	 * @return
	 */
	public ArrayList<Map<String, Object>> nowselectartsaleslistAll(Paging paging,Date[] nowyearday);

	/**
	 * 달선택하고 페이징 처리된 사업자 전체 매출 리스트 조회
	 * @param paging
	 * @param chooseyearday
	 * @return
	 */
	public ArrayList<Map<String, Object>> choselectartsaleslistAll(Paging paging, Date[] chooseyearday);


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
	public ArrayList<Map<String, Object>> chooseyearday(Paging paging,String artid,Date[] chooseyearday);

	/**
	 *  사업자 관리자
	 * 현재달 총 수익금
	 * @param nowyearday
	 * @return
	 */
	public int nowtotalsales(Date[] nowyearday);

	/**
	 *  사업자 관리자
	 * 선택 달 총 수익금 
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
	 * @param chooseyearday
	 * @return
	 */
	public int chosearchtotalsales(String artid,Date[] chooseyearday);

	

	

	

	
}
