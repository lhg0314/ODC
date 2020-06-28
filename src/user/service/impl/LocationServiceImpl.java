package user.service.impl;

import java.util.List;
import java.util.Map;

import user.dao.face.LocationDao;
import user.dao.impl.LocationDaoImpl;
import user.service.face.LocationService;

public class LocationServiceImpl implements LocationService {
	
	private LocationDao locationDao = new LocationDaoImpl();

	@Override
	public List<Map<String, Object>> selectClassByLocation(int location) {
		
		List<Map<String, Object>> list = locationDao.selectClassByLocation(location);
		
		for( Map<String, Object> map : list ){
			
			// 카테고리 처리
			int category = (int)map.get("category");
			
			if( category == 1) {
				map.put("category", "플라워");
			}else if( category == 2) {
				map.put("category", "음악");
			}else if( category == 3) {
				map.put("category", "수공예");
			}else if( category == 4) {
				map.put("category", "요리");
			}else if( category == 5) {
				map.put("category", "뷰티");
			}else if( category == 6) {
				map.put("category", "미술");
			}else if( category == 7) {
				map.put("category", "기타");
			}
			
		}
		
		return list;
	}

}
