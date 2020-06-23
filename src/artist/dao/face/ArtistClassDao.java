package artist.dao.face;

import dto.ArtistInfo;

public interface ArtistClassDao {

	/**
	 * artId로 작가정보 가져오기
	 * @param artId
	 * @return
	 */
	public ArtistInfo getArtInfoByArtId(String artId);

}
