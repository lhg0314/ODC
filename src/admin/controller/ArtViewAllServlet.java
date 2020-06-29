package admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminManageService;
import admin.service.impl.AdminManageServiceImpl;
import dto.ClassInfo;

/*
 * 200621 이서연 
 * 작가정보 상세보기 > 목록별 전체보기
 */


@WebServlet("/admin/artviewall")
public class ArtViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	AdminManageService adminManageService = new AdminManageServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String param = req.getParameter("cate");
		
//		System.out.println(param);
		
		
		
		if("class".equals(param)) {
			
			
			//개설 클래스 조회
			ClassInfo classInfo = new ClassInfo();
			
			classInfo.setArtno(Integer.parseInt(req.getParameter("artno")));
			
			List<ClassInfo> classList = adminManageService.classList(classInfo);
					
			
			
			//조회결과 model값 전달
			req.setAttribute("classList", classList);
			
			//view 지정
			req.getRequestDispatcher("/WEB-INF/views/admin/artist/artViewClassAll.jsp").forward(req, resp);
		
			
			
		} else if("comm".equals(param)) {
			
			
			//문의 답변 조회
			List<Map<String, Object>> askCommList = adminManageService.askCommList(req);
			
			
			//조회결과 model값 전달
			req.setAttribute("askCommList", askCommList);
			
			
			//view 지정
			req.getRequestDispatcher("/WEB-INF/views/admin/artist/artViewCommAll.jsp").forward(req, resp);
			
			
			
		} else System.out.println("error");
		
	
	}
	
}
