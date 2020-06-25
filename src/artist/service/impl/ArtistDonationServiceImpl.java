package artist.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import artist.dao.face.ArtistDonationDao;
import artist.dao.impl.ArtistDonationDaoImpl;
import artist.service.face.ArtistDonationService;
import util.Paging;

public class ArtistDonationServiceImpl implements ArtistDonationService {
	private ArtistDonationDao artistDonationDao = new ArtistDonationDaoImpl();
	
	@Override
	public Paging getPagingDonationByArtNo(HttpServletRequest req, int artno) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		// 검색어
		String month = (String) req.getParameter("month");

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = artistDonationDao.selectCntDonationByArtNo(artno, month);

		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);

		// 검색어
		paging.setMonth(month);

		return paging;
	}

	@Override
	public List<Map<String, Object>> selectDonationByArtNo(Paging paging, int artno) {
		return artistDonationDao.selectDonationByArtNo(paging, artno);
	}

}
