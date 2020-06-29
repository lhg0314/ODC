package main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import main.service.face.HeaderService;
import main.service.impl.HeaderServiceImpl;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HeaderService headerService = new HeaderServiceImpl();
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/header get");

		// json의 형식
		resp.setContentType("application/json; charset=utf-8");

		// 응답출력 스트림을 이용해 직접 보내기
		PrintWriter out = resp.getWriter();
		
		//인기클래스 불러오기
		List<Map<String, Object>> list = headerService.hotclassTopFive();
		
		// Gson 라이브러리 객체
		Gson gson = new Gson();
		
		String jsonList = gson.toJson(list);
		
		out.println(jsonList);
		
	
	}


}
