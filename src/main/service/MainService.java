package main.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Paging;

public interface MainService {

	Paging getSearchPaging(HttpServletRequest req);

	List<Map<String, Object>> getClassListBySearch(Paging paging);

	Paging getSearchPaging(HttpServletRequest req, int cate);

	List<Map<String, Object>> getClassListBySearch(Paging paging, int cate);

}
