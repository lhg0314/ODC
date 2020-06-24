package artist.dao.face;

import dto.ArtistInfo;

public interface ArtistLeaveDao {

	/*
	 * 아이디비번 맞는지 체크
	 */
	int pwcheck(ArtistInfo ainfo);
	
	

}
