package com.dohwaji.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;

public class MemberFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;

		// 회원 정보 가져오기
		if (command.equals("/member/MemberInformation.me")) {
			action = new MemberInformationAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 회원가입 페이지 이동
		} else if (command.equals("/member/MemberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/joinFrom.jsp");

			// 회원가입 확인
		} else if (command.equals("/member/MemberJoinOk.me")) {
			action = new MemberJoinOkAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 아이디 중복확인
		} else if (command.equals("/member/MemberCheckIdOk.me")) {
			action = new MemberCheckIdOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 로그인 페이지 이동
		} else if (command.equals("/member/MemberLogin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/login.jsp");

			// 로그인 확인
		} else if (command.equals("/member/MemberLoginOk.me")) {
			action = new MemberLoginOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 로그아웃
		} else if (command.equals("/member/MemberLogOut.me")) {
			action = new MemberLogOutAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 마이페이지 비밀번호 체크
		} else if (command.equals("/member/memberEnterPW.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/check_pw.jsp");

			// 마이페이지 비밀번호 중복확인
		} else if (command.equals("/member/memberCheckOk.me")) {
			action = new MypageCheckPWAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 회원 정보 수정
		} else if (command.equals("/member/MypageUpdateOk.me")) {
			action = new MypageUpdateOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			

			// 회원 탈퇴
		} else if (command.equals("/member/MemberDeleteOk.me")) {
			action = new MemberDeleteOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			
			// 이메일 인증 보내다
		} else if (command.equals("/member/EmailSend.me")) {
			action = new EmailSendAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			// 이메일 인증 체크
		} else if (command.equals("/member/EmailCheck.me")) {
			action = new EmailCheckAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
		
			// 인증된 이메일 입력   .. 비밀번호 찾기			1
		} else if (command.equals("/member/find_pw.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/find_pw.jsp");
			
	
			// 인증된 이메일 입력   ... 아이디 찾기
		} else if (command.equals("/member/find_id.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/find_id.jsp");
			
			
			
			// 비밀번호 찾기
			// 인증된 이메일로 인증서 보내기				2
		} else if (command.equals("/member/MemberFind_pw.me")) {
			action = new MemberFind_pwAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			// 아이디  찾기
			// 인증된 이메일로 인증서 보내기
		} else if (command.equals("/member/MemberFind_id.me")) {
			action = new MemberFind_idAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			// 아이디  찾기
			// 인증된 이메일로 인증서 보내기
		} else if (command.equals("/member/Find_IDEmailCheck.me")) {
			action = new Find_IDEmailCheckAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
		} else if (command.equals("/member/Find_PWEmailCheck.me")) {
			action = new Find_PWEmailCheckAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
		} else if (command.equals("/member/MemberNewPwOk.me")) {
			action = new MemberNewPwOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			
			
			
			// 오류 404 페이지
		} else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}

		// 일괄처리
		if (forward != null) {
			if (forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispather = req.getRequestDispatcher(forward.getPath());
				dispather.forward(req, resp);
			}
		}
	}
}