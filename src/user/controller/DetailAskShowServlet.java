package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.AskBoard;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DetailAskShowServlet
 */
@WebServlet("/ask/show")
public class DetailAskShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 	resp.setCharacterEncoding("UTF-8");//printwriter를 위한 인코딩
	        PrintWriter out=resp.getWriter();//ajax로 응답을 하기위한 printwriter
			int classno=Integer.parseInt(req.getParameter("classno"));
			List<AskBoard> list=us.selectAskByClassno(classno);
			//System.out.println(list);
			 HashMap<String,Object> map=new HashMap<String,Object>();
			 map.put("asklist",list);
			 Gson gson=new Gson();

			 
			out.println(gson.toJson(map));
		}

}
