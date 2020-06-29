package main.service.impl;

import java.util.List;
import java.util.Map;

import main.dao.face.HeaderDao;
import main.dao.impl.HeaderDaoImpl;
import main.service.face.HeaderService;

public class HeaderServiceImpl implements HeaderService {
	
	private HeaderDao headerDao = new HeaderDaoImpl();

	@Override
	public List<Map<String, Object>> hotclassTopFive() {
		
		return headerDao.hotclassTopFive();
	}

}
