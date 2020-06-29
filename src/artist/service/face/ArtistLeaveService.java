package artist.service.face;


import dto.ArtistInfo;


public interface ArtistLeaveService {

	/**
	 * 아이디비번 맞는지 체크
	 * @param ainfo
	 * @return
	 */
	Boolean pwcheck(ArtistInfo ainfo);

	
	/**
	 * artno에 연결된 데이터들 삭제하기
	 * @param ainfo
	 */
	void leave(ArtistInfo ainfo);


	/**
	 * 게시중인 클래스 있는지 체크
	 * @param ainfo
	 * @return
	 */
	boolean classcheck(ArtistInfo ainfo);

}
