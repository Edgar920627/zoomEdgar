package com.dohwaji.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;

public class MemberNewPwOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberBean m_bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();


		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		ActionForward forward = new ActionForward();
		
		
		
		String user_email = request.getParameter("user_email");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		
		System.out.println("1 user_pw =" + user_pw); 
		
		user_pw = m_dao.encrypt(user_pw);
		
		System.out.println("2 user_pw =" + user_pw); 

		
		m_bean.setUser_id(user_id);
		m_bean.setUser_pw(user_pw);
		m_bean.setUser_email(user_email);
		
		
		
		
		if(m_bean.getUser_id() == "" || m_bean.getUser_pw() == "" || m_bean.getUser_email() == "" ) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('빈칸 채워주세요.  잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
			
		}
		
		
		
		// PW 4 ~ 12 글자
		if (user_pw.length() < 4  || user_pw.length() > 11 ) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('비밀번호  4~12 글자 수 입니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		
		// 비밀번호 변경
		m_dao.newPw(m_bean);
		
		
		
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/member/MemberLogOut.me");
		return forward;
	}

}
