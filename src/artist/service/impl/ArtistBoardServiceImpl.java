package artist.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import artist.dao.impl.ArtistBoardDaoImpl;
import artist.dao.face.ArtistBoardDao;
import artist.service.face.ArtistBoardService;
import util.Paging;

public class ArtistBoardServiceImpl implements ArtistBoardService {
	private ArtistBoardDao artistBoardDao = new ArtistBoardDaoImpl();

	@Override
	public Paging getPagingReview(HttpServletRequest req, int artno) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		// 검색어
		String search = (String) req.getParameter("search");

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = artistBoardDao.selectCntReviewByArtNo(search, artno);

		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	@Override
	public List<Map<String, Object>> selectReviewByArtNo(Paging paging, int artno) {
		return artistBoardDao.selectReviewByArtNo(paging, artno);
	}

	@Override
	public int getArtNoById(String artid) {
		return artistBoardDao.selectArtNoByArtId(artid);
	}

}
