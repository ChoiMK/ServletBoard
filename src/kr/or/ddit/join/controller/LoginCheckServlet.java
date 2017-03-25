package kr.or.ddit.join.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.vo.MemberVO;
/**
 * @Class Name : LoginCheckServlet.java
 * @Description : 회원 검증
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
public class LoginCheckServlet extends HttpServlet {
	//전송방식 GET : 유저가 직접 서버 요청 주소를 브라우저의 주소창에 입력후 요청.
	//              location.href="주소"
	//              location.replace("주소")
	//              <a href="주소">클릭하면 요청가요</a>
	//				<form method="GET"/> : default로 get방식 설정됨
	//				$.ajax(type:"GET")
	//				 *해당 요청을 처리하는 서블릿 클래스의 콜백 메서드 : doGet();
	//       post : <form method="post"/>
	//				$.ajax(type:"POST")
	//				 *해당 요청을 처리하는 서블릿 클래스의 콜백 메서드 : doPost();
	
	// UI 렌더링 엔진 : 트라인트,웹킷,게코,프로스토
	//          IE - 트라이언트
	//			Chrome, Safari - 웹킷. 현재 Chrome은 자체 개발한 블링크 엔진 활용. 
	//			Firefox - 게코
	//			Opera   - 프레스토
	// 자바 스크립트 실행 엔진 : IE - Chakra
	//                      Firefox - spiderMonkey
	//						Safari - Javascript Core
	//						Chrome - V8
	//						Opera - Karakan
	
	/**
	 * 회원 검증 처리
	 * @param request, response
	 * @return 
	 * @throws ServletException, IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		params.put("mem_pass", mem_pass);
		
		MemberVO.getInstance().setMem_id(mem_id);
		
		
		// Servlet                         <----->   service layer            <----->        dao layer
		// 클라이언트로부터 전송되는 파라미터 취득          서버내 저수준 자원 접근활용                          커넥션 관리            
		// html, javascript 작성 후 응답 전송           원격지 서버 접근 및 활용                             쿼리질의
		// 재요청 응답 전송                                 기타 비지니스 로직
		//										  DAO 발생 익셉션 처리 로직
		BoardService service = BoardServiceImpl.getInstacne();
		MemberVO  memberInfo = service.getMemberInfo(params);
		
		//1. 클라이언트가 ------------http://localhost/ServletToddler/loginCheck ------> 서버
		//										mem_id=값&mem_pass=값                     회원아님
		if(memberInfo == null){
			// response에 저장 : [http://localhost/ServletToddler/loginForm]
			// 클라이언트(브라우저)에 전달하고, 브라우저의 주소창에 해당 주소를 입력 후 요청 전송
			String message = URLEncoder.encode("회원이아닙니다.", "UTF-8");
			response.sendRedirect("/ServletBoard/loginForm?message=회원이아닙니다."+message);
		}else{
			response.sendRedirect("/ServletBoard/boardList");
		}
		
		
		
		
		
		
		
		
	}
	
}
