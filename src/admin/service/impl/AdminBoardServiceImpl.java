package admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import admin.dao.face.AdminBoardDao;
import admin.dao.impl.AdminBoardDaoImpl;
import admin.service.face.AdminBoardService;
import dto.NoticeBoard;
import dto.ReviewBoard;
import util.Paging;

public class AdminBoardServiceImpl implements AdminBoardService {
	private AdminBoardDao adminBoardDao = new AdminBoardDaoImpl();
	
	@Override
	public Paging getPagingNotice(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = adminBoardDao.selectCntAllNotice();

		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);

		return paging;
	}


	@Override
	public List<NoticeBoard> selectAllNotice(Paging paging) {
		return adminBoardDao.selectAllNotice(paging);
	}

	@Override
	public Paging getPagingReview(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		// 검색어
		String search = (String) req.getParameter("search");
		
		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = adminBoardDao.selectCntAllReview(search);
		
		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		// 검색어
		paging.setSearch(search);
		
		return paging;
	}
	
	@Override
	public List<Map<String, Object>> selectAllReview(Paging paging) {
		return adminBoardDao.selectAllReview(paging);
	}


	@Override
	public void noticeListDelete(String names) {
		adminBoardDao.deleteNoticeList(names);
	}


	@Override
	public void reviewListDelete(String names) {
		adminBoardDao.deleteReviewList(names);

	}


	@Override
	public Map<String, Object> selectReviewByReviewNo(int reviewno) {
		return adminBoardDao.selectReviewByReviewNo(reviewno);
	}

}
