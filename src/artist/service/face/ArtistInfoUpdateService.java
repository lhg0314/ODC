package artist.service.face;

import dto.ArtistDetail;
import dto.ArtistInfo;

public interface ArtistInfoUpdateService {
	
	/**
	 * 작가정보 수정페이지에 기존정보 가져오기
	 * @param a
	 * @return
	 */
	public ArtistInfo artInfoLoad(ArtistInfo a);

	/**
	 * 작가소개글 가져오기
	 * @param ad
	 * @return
	 */
	public ArtistDetail artDetailLoad(ArtistDetail ad);
	
	

}
