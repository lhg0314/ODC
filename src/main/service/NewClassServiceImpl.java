package main.service;

import java.util.List;
import java.util.Map;

import dto.ClassInfo;
import main.dao.NewClassDao;
import main.dao.NewClassDaoImpl;

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
