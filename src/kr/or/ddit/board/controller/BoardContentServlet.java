package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.MemberVO;

public class BoardContentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String board_id = request.getParameter("board_id");
		String mem_id = MemberVO.getInstance().getMem_id();
		Map<String, String> params = new HashMap<String, String>();
	    params.put("board_id",board_id);
		
	    BoardService service = BoardServiceImpl.getInstacne();
		BoardVO boardInfo = service.getBoardInfo(params);
		
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		
	    PrintWriter out = response.getWriter();
	    
	   out.println(" <!DOCTYPE html>                                                                                                                         ");
	   out.println(" <html>                                                                                                                                  ");
	   out.println(" <head>                                                                                                                                  ");
	   out.println(" <meta charset='UTF-8'>                                                                                                                  ");
	   out.println(" <title>Insert title here</title>                                                                                                        ");
	   out.println(" <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'                                     ");
	   out.println(" integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>                            ");
	   out.println("                                                                                                                                         ");
	   out.println(" <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css'                               ");
	   out.println(" integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'>                            ");
	   out.println("                                                                                                                                         ");
	   out.println(" <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'                                                       ");
	   out.println(" integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>                   ");
	   out.println("<style>");
	   out.println("table th{width:10%;}");
	   out.println("</style>");
	   out.println(" </head>                                                                                                                                 ");
	   out.println(" <body>                                                                                                                                  ");
	   out.println(" <div class='container'>                                                                                                                 ");
	   out.println(" <table class='table table-bordered'>                                                                                                    ");
	   out.println("     <tbody>                                                                                                                             ");
	   out.println("<input type='hidden' name='board_id' value='"+boardInfo.getBoard_id()+"'/>");
	   out.println("<tr>");
	   out.println("<th>작성자</th>");
	   out.println("<td><div>"+boardInfo.getBoard_writer()+"</div></td>   ");
	   out.println(" </tr>                                                                                                                       ");
	   out.println("             <tr>                                                                                                                        ");
	   out.println("                 <th>제목 </th>                                                                                                         ");
	   out.println("                 <td><div name='board_title' >"+boardInfo.getBoard_title()+"</div></td>                     ");
	   out.println("             </tr>                                                                                                                       ");
	   out.println("             <tr>                                                                                                                        ");
	   out.println("                 <th>내용 </th>                                                                                                         ");
	   out.println("                 <td><div name='board_content' >"+boardInfo.getBoard_content()+"</div></td>");
	   out.println("             </tr>                                                                                                                       ");
	   out.println("                                                                                                                                         ");
	   out.println("             <tr>                                                                                                                        ");
	   out.println("                 <td colspan='2'>                                                                                                        ");
	   if(mem_id.equals(boardInfo.getBoard_writer())){
	   out.println("                     <input type='button' value='수정' class='pull-right btn btn-default' onclick=\"javascript:location.href='/ServletBoard/boardView?board_id="+boardInfo.getBoard_id()+"'\"/>                                         ");
	   }
	   out.println("                     <input type='button' value='목록'  onclick=\"javascript:location.href='/ServletBoard/boardList'\" class='btn btn-default'/>                ");
	   out.println("                 </td>                                                                                                                   ");
	   out.println("             </tr>                                                                                                                       ");
	   out.println("     </tbody>                                                                                                                            ");
	   out.println(" </table>                                                                                                                                ");
	   out.println(" </div>                                                                                                                                  ");
	   out.println(" </body>                                                                                                                                 ");
       out.println("                                                                                                                                         ");
	   out.println(" </html>                                                                                                                                 ");

	}

}
