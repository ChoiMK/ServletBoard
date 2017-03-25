package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.vo.MemberVO;

public class WriteFormServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	response.setCharacterEncoding("UTF-8");						
	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out = response.getWriter();
	
	String mem_id = MemberVO.getInstance().getMem_id();
	
	
	
	
	
	out.println("<!DOCTYPE html>																															");			
	out.println("<html>                                                                                                                                     ");
	out.println("<head>                                                                                                                                     ");
	out.println("<meta charset='UTF-8'>                                                                                                                     ");
	out.println("<title>Insert title here</title>                                                                                                           ");
	out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'                                        ");
	out.println("integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>                               ");
	out.println("                                                                                                                                           ");
	out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css'                                  ");
	out.println("integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'>                               ");
	out.println("                                                                                                                                           ");
	out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'                                                          ");
	out.println("integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>                      ");
	out.println("</head>                                                                                                                                    ");
	out.println("<body>                                                                                                                                     ");
	out.println("<div class='container'>                                                                                                                    ");
	out.println("<table class='table table-bordered'>                                                                                                       ");
	out.println("    <tbody>                                                                                                                                ");
	out.println("        <form action='/ServletBoard/insertBoardInfo' method='post'>                                                          ");
	out.println("<input type='hidden' name='board_writer' value='"+mem_id+"'/>");
	out.println("<tr>");
	out.println("<th>작성자:</th>");
	out.println("<td><input type='text' ' name='board_writer'  readonly='readonly' class='form-control' value='"+mem_id+"'/></td>   ");
	out.println(" </tr>                                                                                                                       ");
	out.println("            <tr>                                                                                                                           ");
	out.println("                <th>제목: </th>                                                                                                            ");
	out.println("                <td><input type='text' placeholder='제목을 입력하세요. ' name='board_title' class='form-control'/></td>                        ");
	out.println("            </tr>                                                                                                                          ");
	out.println("            <tr>                                                                                                                           ");
	out.println("                <th>내용: </th>                                                                                                            ");
	out.println("                <td><textarea cols='30' rows='20' placeholder='내용을 입력하세요. ' name='board_content' class='form-control'></textarea></td>   ");
	out.println("            </tr>                                                                                                                          ");
	out.println("                                                                                                                                           ");
	out.println("            <tr>                                                                                                                           ");
	out.println("                <td colspan='2'>                                                                                                           ");
	out.println("                    <input type='submit' value='등록' onclick='sendData()' class='pull-right btn btn-default'/>                                            ");
	out.println("                    <input type='button' value='목록'  onclick=\"javascript:location.href='/ServletBoard/boardList'\" class='btn btn-default'/>                 ");
	out.println("                </td>                                                                                                                      ");
	out.println("            </tr>                                                                                                                          ");
	out.println("        </form>                                                                                                                            ");
	out.println("    </tbody>																															");
	out.println("</table>																					");
	out.println("</div>																								");
	out.println("</body>																									");
	out.println("</html>																					");
	
	
	
	
	
	
	}

}
