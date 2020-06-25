package artist.dao.face;

import java.util.List;
import java.util.Map;

import util.Paging;

public interface ArtistBoardDao {

	int selectCntReviewByArtNo(String search, int artno);

	List<Map<String, Object>> selectReviewByArtNo(Paging paging, int artNo);

	int selectArtNoByArtId(String artid);

}
