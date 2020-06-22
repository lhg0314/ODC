package artist.dao.face;

import dto.ArtistInfo;

public interface ArtistDao {

	int userLogin(String id, String pw);

	int idCheck(String checkId);

	void insertArtist(ArtistInfo artist);

}
