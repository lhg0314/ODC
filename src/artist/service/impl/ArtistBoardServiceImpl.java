package artist.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import artist.dao.impl.ArtistBoardDaoImpl;
import artist.dao.face.ArtistBoardDao;
import artist.service.face.ArtistBoardService;
import dto.AskBoardComm;
import util.Paging;

public class ArtistBoardServiceImpl implements ArtistBoardService {
	private ArtistBoardDao artistBoardDao = new ArtistBoardDaoImpl();

	@Override
	public Paging getPagingReviewByArtNo(HttpServletRequest req, int artno) {
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

	@Override
	public Paging getPagingAskByArtNo(HttpServletRequest req, int artno) {
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		// 검색어
		String search = (String) req.getParameter("search");

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = artistBoardDao.selectCntAskByArtNo(search, artno);

		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);

		// 검색어
		paging.setSearch(search);

		return paging;
	}

	@Override
	public List<Map<String, Object>> selectAskByArtNo(Paging paging, int artno) {
		return artistBoardDao.selectAskByArtNo(paging, artno);
	}

	@Override
	public Map<String, Object> selectAskByAskNo(int askno) {
		return artistBoardDao.selectAskByAskNo(askno);
	}

	@Override
	public List<AskBoardComm> selectCommByAskNo(int askno) {
		return artistBoardDao.selectCommByAskNo(askno);
	}

	@Override
	public AskBoardComm getComment(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String askNo = (String) req.getParameter("askno");
		String content = (String) req.getParameter("content");
		
		AskBoardComm comm = new AskBoardComm();
		comm.setAskBoardno(Integer.parseInt(askNo));
		comm.setCommContent(content);
		
		return comm;
	}

	@Override
	public void insertComment(AskBoardComm comm) {
		artistBoardDao.insertComment(comm);
	}

	@Override
	public Map<String, Object> selectReviewByReviewNo(int reviewno) {
		return artistBoardDao.selectReviewByReviewNo(reviewno);
	}

	@Override
	public boolean deleteComm(int commNo) {
		int res = artistBoardDao.deleteComm(commNo);
		
		if(res > 0) {
			return true;
		} else {
			return false;
		}
	}

}
