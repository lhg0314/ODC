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
	@Override
	public int selectUserIdByEN(String email, String name) {
		int res=artistDao.idCheckByEN(email,name);
		return res;
	}
	@Override
	public String getIdByEN(String email, String name) {
		String id=artistDao.getIdByEN(email,name);
		return id;
	}
	@Override
	public int selectUserPwByEN(String email, String name, String id) {
		int res=artistDao.userPwChkByEN(email,name,id);
		return res;
	}
	@Override
	public String getPwByEN(String email, String name, String id) {
		String pw=artistDao.selectUserPwByEN(email,name,id);
		return pw;
	}

}
