package artist.dao.face;

import java.util.List;
import java.util.Map;

import dto.ArtistInfo;
import dto.ClassFile;
import dto.ClassInfo;
import util.Paging;

public interface ArtistClassDao {

	/**
	 * artId로 작가정보 가져오기
	 * @param artId
	 * @return
	 */
	public ArtistInfo getArtInfoByArtId(String artId);

	/**
	 * 클래스번호 시퀀스값으로 얻어오기
	 * @return
	 */
	public int getClassNo();

	/**
	 * 클래스 정보 DB 입력하기
	 * @param classInfo
	 */
	public void insertClassInfo(ClassInfo classInfo);
 
	/*
	 * 클래스 첨부파일 DB 입력하기
	 */
	public void insertClassFile(ClassFile classFile);

	/**
	 * 검토 클래스 정보 불러오기
	 * @param artno
	 * @return
	 */
	public List<Map<String, Object>> selectAllClassCheck(int artno);

	/**
	 * 페이징 객체
	 * @param search
	 * @return
	 */
	public int selectCntAll(String search, int artno);

	/**
	 * 클래스 개설 정보 불러오기
	 * @param paging
	 * @param artno
	 * @return
	 */
	public List<Map<String, Object>> selectAllClass(Paging paging, int artno);

	/**
	 * 클래스 정보 수정위해 클래스 기존 정보 불러오기
	 * @param classno
	 * @return
	 */
	public Map<String, Object> selectClassByClassNo(int classno);

	/**
	 * 기존 메인 파일 삭제
	 * @param classFile
	 */
	public void deleteMainFile(ClassFile classFile);

	/**
	 * 기존 상세 파일 삭제
	 * @param classFile
	 */
	public void deleteDetailFile(int classno);

	/**
	 * 클래스 정보 수정하기
	 * @param classInfo
	 */
	public void updateClassInfo(ClassInfo classInfo);

	/**
	 * 클래스 상세 파일 가져오기
	 * @param classno
	 * @return
	 */
	public List<ClassFile> selectDetailFileByClassno(int classno);

	/**
	 * 부킹된 클래스가 있는지 확인
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
