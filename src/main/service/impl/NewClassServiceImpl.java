package main.service.impl;

import java.util.List;
import java.util.Map;

import dto.ClassInfo;
import main.dao.face.NewClassDao;
import main.dao.impl.NewClassDaoImpl;
import main.service.face.NewClassService;

public class NewClassServiceImpl implements NewClassService{

	
	NewClassDao nClassDao = new NewClassDaoImpl();
	
	
	public List<Map<String, Object>> changeString(List<Map<String, Object>> list){
		
		
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
			
			// 지역 처리
			int loc = (int)map.get("location");
			
			if( loc == 1) {
				map.put("location", "서울");
			}else if( loc == 2) {
				map.put("location", "경기");
			}else if( loc == 3) {
				map.put("location", "강원");
			}else if( loc == 4) {
				map.put("location", "충청");
			}else if( loc == 5) {
				map.put("location", "경상");
			}else if( loc == 6) {
				map.put("location", "전라");
			}else if( loc == 7) {
				map.put("location", "제주");
			}
			
		}
		
		return list;
	}
	
	@Override
	public List<Map<String, Object>> newclass() {
		
		
		return nClassDao.newclass();
	}


	@Override
	public List<Map<String, Object>> hotclass() {
		
		return nClassDao.hotclass();
	}

}
