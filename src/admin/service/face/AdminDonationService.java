package admin.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Paging;

public interface AdminDonationService {

	Paging getPagingDonation(HttpServletRequest req);

	List<Map<String, Object>> selectAllDonation(Paging paging);

	Paging getPagingTalent(HttpServletRequest req);

	List<Map<String, Object>> selectAllTalentDonationClass(Paging paging);

	Paging getPagingDonationByMonth(HttpServletRequest req);

	List<Map<String, Object>> selectAllDonationByMonth(String month, Paging paging);

}
