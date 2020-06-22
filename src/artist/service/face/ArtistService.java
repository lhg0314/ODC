package artist.service.face;

import dto.ArtistInfo;

public interface ArtistService {

	boolean artistLogin(String id, String pw);

	int idCheck(String checkId);

	void insertartist(ArtistInfo artist);

}
