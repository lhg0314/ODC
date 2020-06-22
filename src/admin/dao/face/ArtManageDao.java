package admin.dao.face;

import java.util.List;

import dto.ArtistInfo;
import util.Paging;

/* 
 * 200620 이서연
 */

public interface ArtManageDao {

	
	/**
	 * 총 작가 수 조회
	 * @return - 전체 작가 수
	 */
	public int selectCntAllArt(String search);
	
	
	/**
	 * 페이징 대상 게시글 목록 조회
	 * @param paging - 페이징 정보 객체
	 * @return List<ArtistInfo> - artistinfo 조회결과 리스트
	 */
	public List<ArtistInfo> selectAllArt(Paging paging);
}