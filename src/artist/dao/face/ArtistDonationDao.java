package artist.dao.face;

import java.util.List;
import java.util.Map;

import util.Paging;

public interface ArtistDonationDao {

	int selectCntDonationByArtNo(int artno, String month);

	List<Map<String, Object>> selectDonationByArtNo(Paging paging, int artno);

}
