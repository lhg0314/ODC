package artist.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.AskBoardComm;
import util.Paging;

public interface ArtistBoardService {

	//----- 작가번호 조회 -----
	int getArtNoById(String artid);

	//----- 작가페이지 리뷰리스트 -----
	Paging getPagingReviewByArtNo(HttpServletRequest req, int artno);

	List<Map<String, Object>> selectReviewByArtNo(Paging paging, int artno);

	//----- 작가페이지 문의리스트 -----
	Paging getPagingAskByArtNo(HttpServletRequest req, int artno);

	List<Map<String, Object>> selectAskByArtNo(Paging paging, int artno);

	Map<String, Object> selectAskByAskNo(int askno);

	List<AskBoardComm> selectCommByAskNo(int askno);

	//----- 문의내역 댓글 -----
	AskBoardComm getComment(HttpServletRequest req);

	void insertComment(AskBoardComm comm);

	Map<String, Object> selectReviewByReviewNo(int reviewno);

}
