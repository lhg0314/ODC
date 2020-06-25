package artist.service.face;

import javax.servlet.http.HttpServletRequest;

import dto.ArtistInfo;

public interface ArtistInfoUpdateService {
	
	/**
	 * 작가정보 수정페이지에 기존정보 가져오기
	 * @param a
	 * @return
	 */
	public ArtistInfo artInfoLoad(ArtistInfo a);

	
	/**
	 * 작가 정보 수정
	 * @param req
	 */
	public void artInfoUpdate(HttpServletRequest req);
	
	
	
	
	
}
