package artist.service.impl;


import artist.dao.face.ArtistLeaveDao;
import artist.dao.impl.ArtistLeaveDaoImpl;
import artist.service.face.ArtistLeaveService;
import dto.ArtistInfo;


public class ArtistLeaveServiceImpl implements ArtistLeaveService {

	
	ArtistLeaveDao aLeaveDao = new ArtistLeaveDaoImpl();
	
	@Override
	public Boolean pwcheck(ArtistInfo ainfo) {
		
		int res = aLeaveDao.pwcheck(ainfo);
		
		if(res>0) return true;
		
		return false;
	}


	@Override
	public void leave(ArtistInfo ainfo) {
		
		aLeaveDao.leave(ainfo);
		
	}


	@Override
	public boolean classcheck(ArtistInfo ainfo) {
		
		int res = aLeaveDao.classcheck(ainfo);
		
		//게시중인 클래스가 없을 때 true 반환해서 탈퇴하도록
		if(res==0) { return true; }
		
		return false;
	}

	
}
