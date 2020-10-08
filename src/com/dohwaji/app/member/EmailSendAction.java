package com.dohwaji.app.member;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.LoginBean;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.util.Gmail;
import com.dohwaji.app.util.SHA256;

public class EmailSendAction implements Action {
	

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Send start _________________________________________");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		

		MemberBean m_bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();
		LoginBean loginBean = new LoginBean();

		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		
		String user_id = request.getParameter("user_id");
		String user_email = request.getParameter("user_email");
		
		
		
		System.out.println("email [ user_id ] = " + user_id);
		System.out.println("email [ uesr_email ] = " + user_email);
		
		if(session.getAttribute("user_id") != null) {
			user_id = (String) session.getAttribute("user_id");
		}
		if(user_id == null) {
			PrintWriter script = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			script.println("<script>");
			script.println("alert('로그인을 해주세요.');");
			script.println("location.href = '/app/member/login.jsp'");
			script.println("</script>");
			script.close();
			return null;
		}
		
		boolean emailChecked = m_dao.getUserEmailChecked(user_id);
		if(emailChecked == true) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 인증 된 회원입니다.');");
			script.println("location.href = 'index.jsp'");
			script.println("</script>");
			script.close();		
			return null;
		}

		
		// 사용자에게 보낼 메시지를 기입합니다.
		String host = "http://localhost:8084/njnj/";

		String from = "7dnjs711@gmail.com";
		String to = m_dao.getUserEmail(user_id);
		
		// 이메일 제목
		String subject = ".zoom.이메일 인증 해주세요. ";
		
		// 이메일 내용
		String content = "다음 링크에 접속하여 이메일 확인을 진행하세요. " +
		"<a href='" + host + "member/EmailCheck.me?user_id=" + user_id +"&code=" + new SHA256().getSHA256(to) + "'>이메일 인증하기</a>";

		
		// SMTP에 접속하기 위한 정보를 기입합니다.
		Properties p = new Properties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.googlemail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		 
		
		System.out.println(" [ to ] = " + to);
		
		try{
		    Authenticator auth = new Gmail();
		    Session ses = Session.getInstance(p, auth);
		    ses.setDebug(true);
		    MimeMessage msg = new MimeMessage(ses); 
		    msg.setSubject(subject);
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr);
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr);
		    msg.setContent(content, "text/html;charset=UTF-8");
		    Transport.send(msg);
		    
		    
		    
		    
		    
		} catch(Exception e){
		    e.printStackTrace();
			PrintWriter script = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			script.println("<script>");
			script.println("alert('오류가 발생했습니다..');");
			script.println("history.back();");
			script.println("</script>");
			script.close();		
		    return null;
		}
		
		
		forward.setRedirect(false);
		forward.setPath("/app/member/check_emailOk.jsp");
		
//		forward.setRedirect(true);
//		forward.setPath(request.getContextPath() + "member/emailCheckAction.jsp");
		return forward;
	}

}
