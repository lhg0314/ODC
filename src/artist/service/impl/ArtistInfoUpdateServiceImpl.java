package artist.service.impl;

import artist.dao.face.ArtistInfoUpdateDao;
import artist.dao.impl.ArtistInfoUpdateDaoImpl;
import artist.service.face.ArtistInfoUpdateService;
import dto.ArtistDetail;
import dto.ArtistInfo;

public class ArtistInfoUpdateServiceImpl implements ArtistInfoUpdateService {

	
	ArtistInfoUpdateDao artUpdateDao = new ArtistInfoUpdateDaoImpl();
	
	
	@Override
	public ArtistInfo artInfoLoad(ArtistInfo a) {
		
		return artUpdateDao.artInfoLoad(a);
	}


	@Override
	public ArtistDetail artDetailLoad(ArtistDetail ad) {
		
		return artUpdateDao.artDetailLoad(ad);
	}

}
