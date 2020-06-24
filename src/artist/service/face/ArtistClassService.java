package artist.service.face;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ArtistInfo;

public interface ArtistClassService {

	/**
	 * artId로 작가 정보 가져오기
	 * @param artId
	 * @return - ArtistInfo 객체
	 */
	public ArtistInfo getArtInfoByArtId(String artId);

	/**
	 * 클래스 신청 정보 DB에 저장
	 * @param req
	 * @param resp
	 * @param artNo 
	 */
	public void insertClassInfo(HttpServletRequest req, HttpServletResponse resp, int artNo);
 
}
