package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.face.BoardService;
import board.service.impl.BoardServiceImpl;
import dto.NoticeBoard;

@WebServlet("/notice/write")
public class NoticeBoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println("/notice/write");
		
		req.getRequestDispatcher("/WEB-INF/views/admin/board/noticeWrite.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		// 저장 객체
		NoticeBoard noticeBoard = new NoticeBoard();
		
		String noticeTitle = req.getParameter("noticeTitle");
		String noticeContent = req.getParameter("content");
	
		noticeBoard.setNoticeTitle(noticeTitle);
		noticeBoard.setNoticeContent(noticeContent);
		
		// 공지사항 저장
		boardService.insertNotice(noticeBoard);
		
		//리스트 페이지로 리다이렉트
		resp.sendRedirect("/admin/noticelist");
	
	}

}
