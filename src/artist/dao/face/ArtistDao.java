package artist.dao.face;

import dto.ArtistInfo;

public interface ArtistDao {

	int userLogin(String id, String pw);

	int idCheck(String checkId);

	void insertArtist(ArtistInfo artist);

	int idCheckByEN(String email, String name);

	String getIdByEN(String email, String name);

	int userPwChkByEN(String email, String name, String id);

	String selectUserPwByEN(String email, String name, String id);

}
