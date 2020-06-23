package admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import admin.dao.face.DonationDao;
import admin.dao.impl.DonationDaoImpl;
import admin.service.face.AdminDonationService;
import util.Paging;

public class AdminDonationServiceImpl implements AdminDonationService {
	
	private DonationDao donationDao = new DonationDaoImpl();
	@Override
	public Paging getPagingDonation(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		// 검색어
		String search = (String) req.getParameter("search");

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = donationDao.selectCntAllDonation(search);

		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	@Override
	public Paging getPagingTalent(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		// 검색어
		String search = (String) req.getParameter("search");

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = donationDao.selectCntAllTalent(search);

		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	@Override
	public Paging getPagingDonationByMonth(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		// 검색어
		String month = (String) req.getParameter("month");

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = donationDao.selectCntAllDonationByMonth(month);

		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);

		return paging;
	}

	@Override
	public List<Map<String, Object>> selectAllDonation(Paging paging) {
		return donationDao.selectAllDonation(paging);
	}

	@Override
	public List<Map<String, Object>> selectAllTalentDonationClass(Paging paging) {
		return donationDao.selectAllTalentDonationClass(paging);
	}
	
	@Override
	public List<Map<String, Object>> selectAllDonationByMonth(String month, Paging paging) {
		return donationDao.selectAllDonationByMonth(month, paging);
	}

}
