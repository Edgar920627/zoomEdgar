package com.dohwaji.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.LoginBean;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;

public class MemberInformationAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberBean m_bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();
		LoginBean loginBean = new LoginBean();

		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		
		String user_id = request.getParameter("user_id");
		
//		String user_id = (String) request.getSession().getAttribute("session_id");
		
		
		System.out.println("Informat no.1 = " + user_id);
		
		m_bean = m_dao.getMemberDetail(user_id);
		
		m_bean.setUser_num(m_bean.getUser_num());
		m_bean.setUser_id(m_bean.getUser_id());
		m_bean.setUser_pw(m_bean.getUser_pw());
		m_bean.setUser_name(m_bean.getUser_name());
		m_bean.setUser_email(m_bean.getUser_email());
		m_bean.setUser_date(m_bean.getUser_date());
		
		System.out.println("Informat no.2");
		
		
		
		
		
		
		session.setAttribute("session_num", m_bean.getUser_num());
		session.setAttribute("session_id", m_bean.getUser_id());
		session.setAttribute("session_pw", m_bean.getUser_pw());
		session.setAttribute("session_name", m_bean.getUser_name());
		session.setAttribute("session_email", m_bean.getUser_email());
		session.setAttribute("session_date", m_bean.getUser_date());
		
		System.out.println("Informat no.3");
		
		
//		request.setAttribute("user_id", m_bean.getUser_id());
//		request.setAttribute("user_pw", m_bean.getUser_pw());
//		request.setAttribute("user_name", m_bean.getUser_name());
//		request.setAttribute("user_email", m_bean.getUser_email());
		
		
		request.setAttribute("memberBean", m_bean);
		
		System.out.println(m_bean.getUser_id());
		System.out.println(m_bean.getUser_pw());
		System.out.println(m_bean.getUser_name());
		System.out.println(m_bean.getUser_email());
		System.out.println(m_bean.getUser_date());
		
		
		
		// 로그인 기록 있는경우 
		if(m_dao.loginCnt(user_id) != 0) {
			
			System.out.println("로그인 기록 진입");
			// 임시 페이지
			String temp = request.getParameter("page");
			
			int page = temp == null ? 1 : Integer.parseInt(temp);
			int pageSize = 10;
			
			// 게시물 수
			int totalCnt = m_dao.loginCnt(user_id);
			
			
			
			// 한페이지 게시물 갯수 끝
			int endRow = page * 10;
			// 한페이지 게시물 갯수 시작
			int startRow = endRow - 10;
			int startPage = ((page - 1) / pageSize) * pageSize + 1;
			int endPage = startPage + 9;
			int totalPage = (totalCnt - 1) / pageSize + 1;
			
			endPage = endPage > totalPage ? totalPage : endPage;
			
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("nowPage", page);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			m_dao.loginHistory(startRow, endRow, user_id);
			request.setAttribute("loginList", m_dao.loginHistory(startRow, endRow, user_id));
			request.setAttribute("loginBean", loginBean);
			
			
			System.out.println("m_dao.LoginHistory(startRow, endRow, user_id) = " + m_dao.loginHistory(startRow, endRow, user_id));
			
			
			
			
		}
		

		forward.setRedirect(false);
		forward.setPath("/app/member/mypage.jsp");
		
//		forward.setRedirect(true);
//		forward.setPath(request.getContextPath() + "/app/member/mypage.jsp");
		return forward;
		
	}

}
