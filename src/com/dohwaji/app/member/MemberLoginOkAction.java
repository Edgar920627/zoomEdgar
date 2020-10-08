package com.dohwaji.app.member;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.LoginBean;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;


public class MemberLoginOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		MemberDAO m_dao = new MemberDAO();
		MemberBean m_bean = new MemberBean();
		LoginBean l_bean = new LoginBean();
		
		boolean check = false;
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		check = m_dao.checkId(id);
		
		

		
		pw = m_dao.encrypt(pw);
		
		Map<String, String>resultMap = m_dao.login(id, pw);
		
		
		// ip 가져오기  test_1
		InetAddress inet = InetAddress.getLocalHost();
		String svrIP = inet.getHostAddress();
		
		// ip 가져오기  test_2
		String REMOTE_ADDR = request.getRemoteAddr();
		
		// ip 가져오기  test_3
		InetAddress local;
		local = InetAddress.getLocalHost();
		String ip = local.getHostAddress();
		
		// ip 확인
		System.out.println("local ip : " + ip);
		System.out.println("REMOTE_ADDR = " + REMOTE_ADDR);
		System.out.println("inet = "+ inet);
		System.out.println("svrIP = "+ svrIP);
		
		String user_id = id;
		String login_ip = svrIP;
		
		l_bean.setUser_id(user_id);
		l_bean.setLogin_ip(login_ip);
		
		if(resultMap != null) {
			m_bean = m_dao.getMemberDetail(user_id);
			
			// 로그인 성공 
			m_dao.loginTrue(l_bean);
			
			
			
			session.setAttribute("session_num", m_bean.getUser_num());
			session.setAttribute("session_id", m_bean.getUser_id());
			session.setAttribute("session_name", m_bean.getUser_name());
			session.setAttribute("session_email", m_bean.getUser_email());
			session.setAttribute("session_date", m_bean.getUser_date());

//			session.setAttribute("session_id", resultMap.get("USER_ID"));
			session.setAttribute("session_ip", login_ip);
			
			forward.setPath(request.getContextPath() + "/index.jsp");
			
			
		}else {
			
			
			if(!check) {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('회원가입을 진행해주세요.');history.back();");
				out.println("</script>");
				out.close();
				return null;
			}else {
				m_dao.loginFalse(l_bean);
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('로그인 실패. 다시 시도해주세요.');history.back();");
				out.println("</script>");
				out.close();
				return null;
			}
		}
		forward.setRedirect(true);
		
		return forward;
	}
}














