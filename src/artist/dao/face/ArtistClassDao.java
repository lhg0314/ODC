package artist.dao.face;

import dto.ArtistInfo;
import dto.ClassFile;
import dto.ClassInfo;

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

}
