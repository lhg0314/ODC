package artist.service.face;

import dto.ArtistInfo;

public interface ArtistService {

	boolean artistLogin(String id, String pw);

	int idCheck(String checkId);

	void insertartist(ArtistInfo artist);

	int selectUserIdByEN(String email, String name);

	String getIdByEN(String email, String name);

	int selectUserPwByEN(String email, String name, String id);

	String getPwByEN(String email, String name, String id);

	void deleteClassFile(int classno, String filename);

}
