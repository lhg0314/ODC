package user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import artist.service.face.ArtistClassService;
import artist.service.face.ArtistService;
import artist.service.impl.ArtistClassServiceImpl;
import artist.service.impl.ArtistServiceImpl;
import dto.ArtistInfo;
import dto.ClassFile;
import dto.ClassInfo;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ClassDetailServlet
 */
@WebServlet("/userclass/detail")
public class ClassDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
	private ArtistClassService ac=new ArtistClassServiceImpl();
	private ArtistService as=new ArtistServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//클래스 상세내용 페이지
			HttpSession session=req.getSession();
			String id=(String) session.getAttribute("userid");
			System.out.println(id);
			
			if(id !=null) {
				int userno=us.getUsernoBy(id);
				System.out.println(userno);
				req.setAttribute("userno", userno);
			}
			int classno=Integer.parseInt(req.getParameter("classno"));
			Map<String, Object> classinfo= ac.selectClassByClassNo(classno);
			int artno=(int) classinfo.get("artno");
			List<ClassFile> classDetail=ac.selectDetailFileByClassno(classno);
			ArtistInfo artistinfo=as.getArtInfobyartNo(artno);
			
			List<Map<String, Object>> askboard=us.getAskAndComm(classno);
			System.out.println("askboard"+askboard);
			
			System.out.println(classinfo);
			System.out.println(artistinfo);
			String addr=artistinfo.getArtAddr().split(";")[1];
			
			
			artistinfo.setArtAddr(artistinfo.getArtAddr().split(";")[0]+" "+artistinfo.getArtAddr().split(";")[1]+" "+artistinfo.getArtAddr().split(";")[2]);
			
			req.setAttribute("askboard", askboard);
			req.setAttribute("classaddr", addr);
			req.setAttribute("artistinfo", artistinfo);
			req.setAttribute("classinfo", classinfo);
			req.setAttribute("classDetail", classDetail);
			
			req.getRequestDispatcher("/WEB-INF/views/user/class/classDetil.jsp").forward(req, resp);
		}

}
