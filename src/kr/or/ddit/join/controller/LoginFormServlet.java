package kr.or.ddit.join.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Class Name : LoginFormServlet.java
 * @Description : 회원 로그인 폼 작성 및 전송
 * @Modification Information
 * @author 최민규
 * @since  2017.03.21.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2017.03.21.  최민규      최초작성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public class LoginFormServlet extends HttpServlet {
	/**
	 * 로그인 폼 작성 및 반환
	 * @param request, response
	 * @return 
	 * @throws ServletException, IOException
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 최초 /ServletToddler/loginForm
		// 로그인체크 /ServletToddler/loginForm?message=회원이아닙니다.
		// message : null or 회원이아닙니다.
		String message = request.getParameter("message");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>                                                           ");
		out.println("<!DOCTYPE html>                                                  ");
		out.println("<head>                                                           ");
		out.println("<meta charset=\"UTF-8\">                                         ");
		out.println("<title>Insert title here</title>                                 ");
		out.println("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-latest.js\"></script>   ");
		out.println("<script type=\"text/javascript\">                                                     ");
		out.println("$(function(){                                                                       ");
		// javascript 변수/객체 : underfined, null, 실제값
		out.println("   if('" + message + "'  !='null'){");
		out.println("   alert('" + message + "');");
		out.println("  }");
		out.println("	$('form').submit(function(){                                                       ");
		out.println("		if(!$('input[name=mem_id]').val()){                                     ");
		out.println("			alert('아이디를 입력해주세요');                                          ");
		out.println("			return false;                                                            ");
		out.println("		}                                                                            ");
		out.println("		if(!$('input[name=mem_pass]').val()){                                   ");
		out.println("			alert('패스워드를 입력해주세요');                                        ");
		out.println("			return false;                                                            ");
		out.println("		}                                                                            ");
		out.println("		return;                                                                      ");
		out.println("	});                                                                              ");
		out.println("});                                                                                 ");
		out.println("</script> 																			 ");
		out.println("</head>                                                          ");
		out.println("<body>                                                           ");
		out.println("<form action=\"/ServletBoard/loginCheck\" method=\"post\">                               ");
		out.println("	<table>                                                       ");
		out.println("		<tr>                                                      ");
		out.println("			<td>아이디</td>                                        ");
		out.println("			<td><input type=\"text\" name=\"mem_id\"/></td>       ");
		out.println("		</tr>                                                     ");
		out.println("		<tr>                                                      ");
		out.println("			<td>패스워드</td>                                       ");
		out.println("			<td><input type=\"password\" name=\"mem_pass\"/></td>     ");
		out.println("		</tr>                                                     ");
		out.println("		<tr>                                                      ");
		out.println("			<td colspan=\"2\">                                    ");
		out.println("				<input type=\"submit\" value=\"로그인\">           ");
		out.println("			</td>                                                 ");
		out.println("		</tr>                                                     ");
		out.println("	</table>                                                      ");
		out.println("</form>                                                          ");
		out.println("</body>                                                          ");
		out.println("</html> 														  ");
	}
	
}
