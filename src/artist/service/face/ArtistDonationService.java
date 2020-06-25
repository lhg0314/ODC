package artist.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Paging;

public interface ArtistDonationService {

	Paging getPagingDonationByArtNo(HttpServletRequest req, int artno);

	List<Map<String, Object>> selectDonationByArtNo(Paging paging, int artno);

}
