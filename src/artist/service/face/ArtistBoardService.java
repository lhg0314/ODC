package artist.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Paging;

public interface ArtistBoardService {

	int getArtNoById(String artid);

	Paging getPagingReview(HttpServletRequest req, int artno);

	List<Map<String, Object>> selectReviewByArtNo(Paging paging, int artno);

}
