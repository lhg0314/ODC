package artist.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ArtistInfo;
import dto.ClassFile;
import dto.ClassInfo;
import util.Paging;

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
	 * @param artInfo 
	 */
	public void insertClassInfo(HttpServletRequest req, HttpServletResponse resp, ArtistInfo artInfo);

	/**
	 * 검토클래스 정보 불러오기
	 * @param artno
	 * @return
	 */
	public List<Map<String, Object>> selectAllClassCheck(int artno);

	/**
	 * 개설한 클래스 페이징 객체
	 * @param req
	 * @return
	 */
	public Paging getPagingClassManage(HttpServletRequest req, int artno);

	/**
	 * 개설한 클래스 불러오기
	 * @param paging
	 * @param artno
	 * @return
	 */
	public List<Map<String, Object>> selectAllClass(Paging paging, int artno);

	/**
	 * 클래스 수정하기 위해 기존 클래스 정보 불러오기
	 * @param classno
	 * @return
	 */
	public Map<String, Object> selectClassByClassNo(int classno);

	/**
	 * 클래스 정보 수정하기
	 * @param req
	 * @param resp
	 * @param artInfo
	 */
	public void updateClassInfo(HttpServletRequest req, HttpServletResponse resp);

	/* 
	 * 클래스 상세 파일 가져오기
	 */
	public List<ClassFile> selectDetailFileByClassno(int classno);

	/**
	 *  클래스 삭제 전 부킹된 사용자가 있는지 확인
	 * @param classno 
	 * @return
	 */
	public int BookingCntCheck(int classno);

	/**
	 * 클래스 내리기
	 * @param classno
	 */
	public int removeClass(int classno);
 
}
