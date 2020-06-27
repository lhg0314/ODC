package artist.dao.face;

import dto.ArtistInfo;

public interface ArtistLeaveDao {

	/*
	 * 아이디비번 맞는지 체크
	 */
	int pwcheck(ArtistInfo ainfo);

	
	/**
	 * 회원상태 0으로 바꾸기
	 * @param ainfo
	 */
	void leave(ArtistInfo ainfo);

	/**
	 * 게시중인 클래스 있는지 체크
	 * @param ainfo
	 * @return
	 */
	int classcheck(ArtistInfo ainfo);
	
	

}
