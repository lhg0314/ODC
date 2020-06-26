package artist.service.impl;

import javax.servlet.http.HttpServletRequest;

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
		
		
//		Donation - art_no
		aLeaveDao.deleteDonation(ainfo);

//		askboardcomm - ask_board_no - 조인해서 삭제해야함
		aLeaveDao.deleteAskBoardComm();
		
//		AskBoard - art_no
		aLeaveDao.deleteAskBoard(ainfo);
		
//		artistInfo - art_no
		aLeaveDao.deleteArtistInfo(ainfo);

		
	}

	
}
