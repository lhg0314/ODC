package main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.service.face.MainService;
import main.service.impl.MainServiceImpl;
import util.Paging;
/**
 * 메인 헤더 검색 기능
 * @author 200627 박주이
 * 완성
 */
@WebServlet("/main/search")
public class MainSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainService mainService = new MainServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cate = Integer.parseInt(req.getParameter("cate"));
		Paging paging = null;
		List<Map<String, Object>> list = null;
		
		if(cate == 0) {
			paging = mainService.getSearchPaging(req);
			list = mainService.getClassListBySearch(paging);
		} else {
			paging = mainService.getSearchPaging(req, cate);
			list = mainService.getClassListBySearch(paging, cate);
		}
		
		req.setAttribute("paging", paging);
		req.setAttribute("list", list);
		
		System.out.println(list);
		
		req.getRequestDispatcher("/WEB-INF/views/main/mainsearch.jsp").forward(req, resp);
		
	}
}
