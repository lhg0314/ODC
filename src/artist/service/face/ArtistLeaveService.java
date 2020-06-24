package artist.service.face;


import dto.ArtistInfo;


public interface ArtistLeaveService {

	/**
	 * 아이디비번 맞는지 체크
	 * @param ainfo
	 * @return
	 */
	Boolean pwcheck(ArtistInfo ainfo);

	void leave(ArtistInfo ainfo);

}
