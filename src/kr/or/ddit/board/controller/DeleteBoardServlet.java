package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;

public class DeleteBoardServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String board_id = request.getParameter("board_id");
	Map<String, String> params = new HashMap<String, String>();
	params.put("board_id", board_id);
	
	BoardService service = BoardServiceImpl.getInstacne();
	service.deleteBoardInfo(params);
	
	response.sendRedirect("/ServletBoard/boardList");
	
	}
 
}
