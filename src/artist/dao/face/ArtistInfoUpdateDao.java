package artist.dao.face;

import dto.ArtistDetail;
import dto.ArtistInfo;

public interface ArtistInfoUpdateDao {

	/**
	 * 작가정보 수정페이지에 기존정보 가져오기
	 * @param a
	 * @return
	 */
	ArtistInfo artInfoLoad(ArtistInfo a);

	
	/**
	 * 작가소개글 가져오기
	 * @param ad
	 * @return
	 */
	ArtistDetail artDetailLoad(ArtistDetail ad);

}
