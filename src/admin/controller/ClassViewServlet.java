package admin.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminClassService;
import admin.service.impl.AdminClassServiceImpl;
import artist.service.face.ArtistClassService;
import artist.service.impl.ArtistClassServiceImpl;
import dto.ClassFile;

/**
 * Servlet implementation class ClassViewServlet
 */
@WebServlet("/admin/class/view")
public class ClassViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminClassService adminClassService = new AdminClassServiceImpl();
	private ArtistClassService artistClassService = new ArtistClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int classno = 0;
		
		String cn = req.getParameter("classno");
		if( cn != null && !"".equals(cn)) {
			classno = Integer.parseInt(cn);
		}
		
		// 선택한 클래스 상세 정보
		Map<String, Object> map = adminClassService.selectClassByClassNo(classno);
		ClassFile detailFile = artistClassService.selectDetailFileByClassno(classno);

		req.setAttribute("info", map);
		req.setAttribute("detailFile", detailFile);
//		System.out.println(map);
		
		// 요청받은 view
		String view = req.getParameter("view");
		
		// 포워드
		if( "post".equals(view)){	
			req.getRequestDispatcher("/WEB-INF/views/admin/classManage/classPostView.jsp").forward(req, resp);	
		}else if( "check".equals(view) ){
			req.getRequestDispatcher("/WEB-INF/views/admin/classManage/classCheckView.jsp").forward(req, resp);	
		}	
		
	}

}
