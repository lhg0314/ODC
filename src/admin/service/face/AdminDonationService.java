package admin.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Paging;

public interface AdminDonationService {

	//-------- 후원내역 -----------------------------------------------------
	Paging getPagingDonation(HttpServletRequest req);

	List<Map<String, Object>> selectAllDonation(Paging paging);

	
	//-------- 기부클래스 ----------------------------------------------------
	Paging getPagingTalent(HttpServletRequest req);

	List<Map<String, Object>> selectAllTalentDonationClass(Paging paging);

	
	//-------- 검색한 작가 조회 ----------------------------------------------
	String getSearchedArtist(String search);

}
