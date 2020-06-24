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
		
////		artistDetail - art_no
//		aLeaveDao.deleteArtistDetail(ainfo);
//		
////		ArtistFile - art_no
//		aLeaveDao.deleteArtistFile(ainfo);
//
////		askboardcomm - ask_board_no
//		aLeaveDao.deleteAskBoardComm();
//		
////		AskBoard - art_no
//		aLeaveDao.deleteAskBoard(art_no);
//		
////		artistInfo - art_no
//		aLeaveDao.deleteArtistInfo(ainfo);

		
	}

	
}
