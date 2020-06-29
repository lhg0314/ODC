package main.dao.face;

import java.util.List;
import java.util.Map;

import util.Paging;

public interface MainDao {

	int selectCntClassBySearch(String search);

	List<Map<String, Object>> selectClassBySearch(Paging paging);

	int selectCntClassBySearch(String search, int cate);

	List<Map<String, Object>> selectClassBySearch(Paging paging, int cate);

}
