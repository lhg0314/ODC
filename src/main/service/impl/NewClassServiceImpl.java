package main.service.impl;

import java.util.List;
import java.util.Map;

import dto.ClassInfo;
import main.dao.face.NewClassDao;
import main.dao.impl.NewClassDaoImpl;
import main.service.face.NewClassService;

public class NewClassServiceImpl implements NewClassService{

	
	NewClassDao nClassDao = new NewClassDaoImpl();
	
	
	@Override
	public List<Map<String, Object>> newclass() {
		
		return nClassDao.newclass();
	}


	@Override
	public List<Map<String, Object>> hotclass() {
		
		return nClassDao.hotclass();
	}

}
