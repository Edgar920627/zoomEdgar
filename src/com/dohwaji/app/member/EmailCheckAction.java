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
import com.dohwaji.app.util.SHA256;

public class EmailCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Email Check start _________________________________________");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberBean m_bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();


		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		ActionForward forward = new ActionForward();

		
		String code = request.getParameter("code");

		String user_email_hash = code;
		
		String user_id = request.getParameter("user_id");


		String user_email = m_dao.getUserEmail(user_id);
		
		
		m_bean.setUser_id(user_id);
		m_bean.setUser_email_hash(user_email_hash);
		
		
		boolean rightCode = (new SHA256().getSHA256(user_email).equals(code)) ? true : false;


		if (rightCode == true) {
			
			m_dao.setUserEmailChecked(m_bean);
			
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('인증에 성공했습니다.');");
			out.println("location.href = '/njnj/app/member/login.jsp'");
			out.println("</script>");
			out.close();
			
			
			
			return null;
			
			

		} else {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('유효하지 않은 코드입니다.');");
			out.println("location.href = '/njnj/app/member/join.jsp'");
			out.println("</script>");
			out.close();
			return null;

		}
		
		
		

	}
	
	

}
