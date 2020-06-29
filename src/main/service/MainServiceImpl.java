package main.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import main.dao.MainDao;
import main.dao.MainDaoImpl;
import util.Paging;

public class MainServiceImpl implements MainService {
	private MainDao mainDao = new MainDaoImpl();

	@Override
	public Paging getSearchPaging(HttpServletRequest req) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		// 검색어
		String search = (String) req.getParameter("search");

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = mainDao.selectCntClassBySearch(search);

		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	@Override
	public List<Map<String, Object>> getClassListBySearch(Paging paging) {
		return mainDao.selectClassBySearch(paging);
	}

	@Override
	public Paging getSearchPaging(HttpServletRequest req, int cate) {
		// 요청파라미터 curPage를 파싱한다
				String param = req.getParameter("curPage");
				int curPage = 0;
				if (param != null && !"".equals(param)) {
					curPage = Integer.parseInt(param);
				}
				// 검색어
				String search = (String) req.getParameter("search");

				// 클래스 전체 Paging 객체를 생성하고 반환
				int totalCount = mainDao.selectCntClassBySearch(search, cate);

				// Paging 객체 생성
				Paging paging = new Paging(totalCount, curPage);

				// 검색어
				paging.setSearch(search);

				return paging;
	}

	@Override
	public List<Map<String, Object>> getClassListBySearch(Paging paging, int cate) {
		return mainDao.selectClassBySearch(paging, cate);
	}

}
