package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.vo.BoardVO;

public class BoardListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getParameter("UTF-8");
		BoardService service = BoardServiceImpl.getInstacne();
		
		
		String condition = request.getParameter("condition");
		String result = request.getParameter("result");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put(condition, result);
		
		List<BoardVO> boardList = service.getBoardList(params);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
	
		out.println("<!DOCTYPE html>                                                                                    ");
		out.println("<html>                                                                                             ");
		out.println("<head>                                                                                             ");
		out.println("<meta charset=\"UTF-8\">                                                                             ");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'                                        ");
		out.println("integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>                               ");
		out.println("                                                                                                                                           ");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css'                                  ");
		out.println("integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'>                               ");
		out.println("                                                                                                                                           ");
		out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'                                                          ");
		out.println("integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>                      ");
		
		out.println("<style type=\"text/css\">                                                                            ");
		out.println(".form-control{width: 25%; display:inline-block;}");
		out.println("tr th{text-align: center;}");
		out.println("tr td{text-align: center;}");
		out.println("#search{width:15%;}");
		out.println("</style>                                                                                           ");
		out.println("<script type=\"text/javascript\" src = \"http://code.jquery.com/jquery-latest.js\"></script>           ");
		out.println("<script type=\"text/javascript\">                                                                    ");
		out.println("$(function(){                                                                                      ");
		
		out.println("	$(\"input[name=search_btn]\").click(function(){                                                       ");
		out.println("		var condition = $(\"#search\").val();                                                             ");
		out.println("		var result = $(\"#searchText\").val();                                                            ");
		out.println(" $(location).attr('href',encodeURI('/ServletBoard/boardList?condition='+condition+'&result='+result));    ");
		out.println("	});                                                                                                 ");
		out.println("});                     																	 ");                                                                            
		out.println("</script>                                                                                          ");
		out.println("<title>Insert title here</title>                                                                   ");
		out.println("</head>                                                                                            ");
		out.println("<body>                                                                                             ");
		out.println("<input type=\"button\" value=\"로그아웃\" onclick=\"javascript:location.href='/ServletBoard/loginForm'\" class='btn btn-success btn-xs pull-right'/>                                                ");
		out.println("<div class='container'>");
		out.println("<table class='table table-hover'>                                                                                            ");
		out.println("<thead>");
		out.println("   <tr>                                                                                            ");
		out.println("      <th>글번호</th>                                                                              ");
		out.println("      <th>글제목</th>                                                                              ");
		out.println("      <th>작성자</th>                                                                              ");
		out.println("      <th>작성시간</th>                                                                            ");
		out.println("   </tr>                                                                                           ");
		out.println("</thead>");
		out.println("<tbody>");
		for(BoardVO boardInfo : boardList){
			out.println("   <tr id='list'>                                                                                            ");
			out.println("      <td>"+boardInfo.getBoard_id()+"</td>                                                                                    ");
			out.println("      <td><a href='/ServletBoard/boardContent?board_id="+boardInfo.getBoard_id()+"'>"+boardInfo.getBoard_title()+"</a></td>    ");
			out.println("      <td>"+boardInfo.getBoard_writer()+"</td>                                                                                    ");
			out.println("      <td>"+boardInfo.getBoard_date()+"</td>                                                                                    ");
			out.println("   </tr>                                                                                           ");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("<div class=\"container\"  style=\"display: inline-block; text-align: center;\">");



		out.println("      <select id=\"search\" class=\"form-control\">                                                                                     ");
		out.println("        <option value=\"board_writer\">작성자</option>                                                       ");
		out.println("     	 <option value=\"board_title\">글제목</option>                                                       ");
		out.println("     	 <option value=\"board_id\">글번호</option>                                                       ");
		out.println("     	 <option value=\"board_content\">글내용</option>                                                       ");
		out.println("      </select>                                                                                    ");
		out.println("      <input type=\"text\"  id=\"searchText\" name=\"search\" class='form-control'/>                                                                 ");
		out.println("      <input type=\"button\" name=\"search_btn\" value=\"검색\"  class='btn btn-default'/>                  ");
		out.println("      <input type=\"button\" value=\"글쓰기\" onclick=\"javascript:location.href='/ServletBoard/writeForm'\" class='btn btn-default'/>                                                ");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>                                                                                            ");
		out.println("</html>                                                                                            ");
	
	
	}
}
