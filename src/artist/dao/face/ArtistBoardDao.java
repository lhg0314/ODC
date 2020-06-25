package artist.dao.face;

import java.util.List;
import java.util.Map;

import util.Paging;

public interface ArtistBoardDao {

	//작가번호 조회
	int selectArtNoByArtId(String artid);

	//ReviewBoard 값 추출
	int selectCntReviewByArtNo(String search, int artno);

	List<Map<String, Object>> selectReviewByArtNo(Paging paging, int artNo);

	//AskBoard 값 추출
	int selectCntAskByArtNo(String search, int artno);

	List<Map<String, Object>> selectAskByArtNo(Paging paging, int artno);

}
