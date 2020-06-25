package artist.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.service.face.ArtistClassService;
import artist.service.impl.ArtistClassServiceImpl;

@WebServlet("/artist/class/update")
public class ClassUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArtistClassService artistClassService = new ArtistClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int classno = 0;
		
		String cn = req.getParameter("classno");
		if( cn != null && !"".equals(cn)) {
			classno = Integer.parseInt(cn);
		}
		
		// 선택한 클래스 상세 정보
		Map<String, Object> map = artistClassService.selectClassByClassNo(classno);

		System.out.println(	map );
		
		req.setAttribute("info", map);
	
		// 포워드
		req.getRequestDispatcher("/WEB-INF/views/artist/class/artistClassView.jsp").forward(req, resp);
	
	
	
	}

}
