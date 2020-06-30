package user.controller;

import java.io.IOException;
import java.util.ArrayList;
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
			//System.out.println(id);
			
			if(id !=null) {//userno불러오기
				int userno=us.getUsernoBy(id);
				//System.out.println(userno);
				req.setAttribute("userno", userno);
			}
			
			
			int classno=Integer.parseInt(req.getParameter("classno"));//classno불러오기
			
			ArrayList<Map<String, Object>> reviewList=us.getReviewbyClassno(classno);//클래스에 대한 리뷰 불러오기
			
			//System.out.println("reviewList"+reviewList);
			
			Map<String, Object> classinfo= ac.selectClassByClassNo(classno);//classinfo객체 불러오기
			
			int artno=(int) classinfo.get("artno");
			
			List<ClassFile> classDetail=ac.selectDetailFileByClassno(classno);//클래스파일 불러오기
			
			ArtistInfo artistinfo=as.getArtInfobyartNo(artno);//클래스의 작가정보 호출
			
			List<Map<String, Object>> askboard=us.getAskAndComm(classno);//문의 사항 호출
			//System.out.println("askboard"+askboard);
			
			//System.out.println(classinfo);
			//System.out.println(artistinfo);
			String addr=artistinfo.getArtAddr().split(";")[1];//지도에 사용할 주소 세팅
			
			//작가가 만든 다른 클래스 불러오기
			List<Map<String, Object>> cinfoList=us.getClassList(artno);
			//System.out.println("cinfoList  "+cinfoList);
			
			
			artistinfo.setArtAddr(artistinfo.getArtAddr().split(";")[0]+" "+artistinfo.getArtAddr().split(";")[1]+" "+artistinfo.getArtAddr().split(";")[2]);
			req.setAttribute("reviewList", reviewList);
			req.setAttribute("clist", cinfoList);
			req.setAttribute("askboard", askboard);
			req.setAttribute("classaddr", addr);
			req.setAttribute("artistinfo", artistinfo);
			req.setAttribute("classinfo", classinfo);
			req.setAttribute("classDetail", classDetail);
			
			req.getRequestDispatcher("/WEB-INF/views/user/class/classDetil.jsp").forward(req, resp);
		}

}
