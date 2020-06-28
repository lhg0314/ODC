package admin.dao.face;

import java.util.List;
import java.util.Map;

import dto.ArtistDetail;
import dto.ArtistInfo;
import dto.AskBoard;
import dto.ClassInfo;
import util.Paging;

/* 
 * 200621 이서연
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

	
	/**
	 * artno로 사업자 조회
	 * @param artistInfo - artno 담겨잇음
	 * @return ArtistInfo - 조회된 artist 정보
	 */
	public ArtistInfo selectByArtno(ArtistInfo artistInfo);

	
	/**
	 * 사업자 개설 클래스 가져오기
	 * @param classInfo
	 * @return
	 */
	public List<ClassInfo> classList(ClassInfo classInfo);

	
	
	/**
	 * 조인해서 map으로 askBoardComm 가져오기
	 * @param ab
	 * @return
	 */
	public List<Map<String, Object>> askCommList(AskBoard ab);
}
