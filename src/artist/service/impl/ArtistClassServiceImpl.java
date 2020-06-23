package artist.service.impl;

import artist.dao.face.ArtistClassDao;
import artist.dao.impl.ArtistClassDaoImpl;
import artist.service.face.ArtistClassService;
import dto.ArtistInfo;

public class ArtistClassServiceImpl implements ArtistClassService {
	
	private ArtistClassDao artistClassDao = new ArtistClassDaoImpl();

	@Override
	public ArtistInfo getArtInfoByArtId(String artId) {
		
		ArtistInfo artInfo = artistClassDao.getArtInfoByArtId(artId);
		return artInfo;
	}

}
