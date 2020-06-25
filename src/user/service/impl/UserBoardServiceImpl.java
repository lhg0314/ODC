package user.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import user.dao.face.UserBoardDao;
import user.dao.impl.UserBoardDaoImpl;
import user.service.face.UserBoardService;
import util.Paging;

public class UserBoardServiceImpl implements UserBoardService {
	private UserBoardDao userBoardDao = new UserBoardDaoImpl();

	@Override
	public int getUserNoById(String userid) {
		return userBoardDao.selectUserNoById(userid);
	}

	@Override
	public Paging getPagingReviewByUserNo(HttpServletRequest req, int userno) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		// 검색어
		String search = (String) req.getParameter("search");

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = userBoardDao.selectCntReviewByUserNo(search, userno);

		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;	}

	@Override
	public List<Map<String, Object>> selectReviewByUserNo(Paging paging, int userno) {
		return userBoardDao.selectReviewByUserNo(paging, userno);
	}

}
