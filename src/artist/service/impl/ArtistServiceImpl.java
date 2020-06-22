package artist.service.impl;

import artist.dao.face.ArtistDao;
import artist.dao.impl.ArtistDaoImpl;
import artist.service.face.ArtistService;
import dto.ArtistInfo;

public class ArtistServiceImpl implements ArtistService {

	private ArtistDao artistDao=new ArtistDaoImpl();
	@Override
	public boolean artistLogin(String id, String pw) {
		int res=artistDao.userLogin(id,pw);
		boolean ismember=false;
		if(res==0) {
			
			ismember=false;
		}else {
			ismember=true;
		}
		return ismember;
	}
	@Override
	public int idCheck(String checkId) {
		int res=artistDao.idCheck(checkId);
		return res;
	}
	@Override
	public void insertartist(ArtistInfo artist) {
		artistDao.insertArtist(artist);
		
	}

}
