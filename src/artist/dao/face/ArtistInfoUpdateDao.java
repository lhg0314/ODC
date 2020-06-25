package artist.dao.face;

import dto.ArtistInfo;

public interface ArtistInfoUpdateDao {

	/**
	 * 작가정보 수정페이지에 기존정보 가져오기
	 * @param a
	 * @return
	 */
	ArtistInfo artInfoLoad(ArtistInfo a);

	
	/**
	 * 작가 정보 수정
	 * @param ainfo
	 */
	void artInfoUpdate(ArtistInfo ainfo);

	
}
