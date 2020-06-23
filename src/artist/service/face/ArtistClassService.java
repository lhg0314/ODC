package artist.service.face;

import dto.ArtistInfo;

public interface ArtistClassService {

	/**
	 * artId로 작가 정보 가져오기
	 * @param artId
	 * @return - ArtistInfo 객체
	 */
	public ArtistInfo getArtInfoByArtId(String artId);

}
