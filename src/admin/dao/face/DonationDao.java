package admin.dao.face;

import java.util.List;
import java.util.Map;

import util.Paging;

public interface DonationDao {

	/**
	 * 검색어를 이용한 총 게시글 수 조회
	 * 
	 * @return int - 총 게시글 수
	 */
	public int selectCntAllTalent(String search);
	public int selectCntAllDonation(String search);
	
	/**
	 * 재능기부 클래스 목록 조회
	 * @param paging
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> selectAllTalentDonationClass(Paging paging); // 재능기부 클래스 전체 조회,금액0
	
	/**
	 * 작가 후원 내역 목록 조회
	 * @param paging
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> selectAllDonation(Paging paging); // 전체 후원 내역 조회
	
}
