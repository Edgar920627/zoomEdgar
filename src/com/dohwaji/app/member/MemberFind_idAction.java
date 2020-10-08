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
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.util.Gmail;
import com.dohwaji.app.util.SHA256;

public class MemberFind_idAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		
		MemberDAO m_dao = new MemberDAO();
		MemberBean m_bean = new MemberBean();
		
		boolean result = false;
		boolean check_email = false;
		
		
		
		String user_email = request.getParameter("user_email");
	
		
		
		// 이메일 있는지 확인 
		check_email = m_dao.checkEmail(user_email);
		System.out.println("check_email = " + check_email);
		
		
		
		
		//빈칸 채워주세요.
		if(user_email == "" ) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('빈칸 채워주세요.  잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
			
		}
		
		
		// 인증된 이메일 없을경우
		if(check_email == false) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('인증 된 이메일 없습니다.');history.back();");
			out.println("</script>");
			out.close();		
			return null;
		}
		

		
		// 사용자에게 보낼 메시지를 기입합니다.
		String host = "http://localhost:8084/njnj/";

		String from = "7dnjs711@gmail.com";
		String to = user_email;
		
		// 이메일 제목
		String subject = ".zoom. 아이디 찾기  이메일 인증 해주세요. ";
		
		// 이메일 내용
		String content = "다음 링크에 접속하여 이메일 확인을 진행하세요. " +
				"<a href='" + host + "member/Find_IDEmailCheck.me?user_email=" + user_email +"&code=" + new SHA256().getSHA256(to) + "'>이메일 인증하기</a>";

		
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
		return forward;
	}

}
