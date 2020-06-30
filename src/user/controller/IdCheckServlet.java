package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.face.UserService;
import user.service.impl.UserServiceImpl;


@WebServlet("/id/check")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService=new UserServiceImpl();
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("dopost[id/check]");
		String checkId=req.getParameter("userid");
		//System.out.println(checkId);
		
		int result=userService.idCheck(checkId);
		
		//System.out.println(result);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		if(result==0) out.println("1");//사용가능한 아이디
		else out.println("0");//중복된 아이디
		
		out.close();
		
		
	}

}
