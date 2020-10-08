package com.dohwaji.app.member;

import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;

public class MemberJoinOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println(" ---  join  start _________________________________________");
		
		MemberBean m_bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		ActionForward forward = new ActionForward();
		boolean result = false;
		boolean check_id = false;
		boolean check_name = false;
		boolean check_email = false;

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		
		System.out.println("1 user_pw =" + user_pw); 
		
		user_pw = m_dao.encrypt(user_pw);
		
		System.out.println("2 user_pw =" + user_pw); 

		
		m_bean.setUser_id(user_id);
		m_bean.setUser_pw(user_pw);
		m_bean.setUser_name(user_name);
		m_bean.setUser_email(user_email);

		String id = user_id; // dao 넘기기위해 변형

		
		
	    String regex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
	    
        //유효성 검사
        boolean name_check = Pattern.matches("^[가-힣]*$", user_name);
        boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", user_email);
        boolean id_check = Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", user_id);

        //출력
        System.out.println("이름 : " + name_check);
        System.out.println("이메일 : " + email_check);
	    
	    
		
		System.out.println("join [  user_id ] = " +  user_id);
		System.out.println("join [  user_pw ] = " +  user_pw);
		System.out.println("join [  user_name ] = " +  user_name);
		System.out.println("join [  user_email ] = " +  user_email);
		
		
		
		
	
		
		
		
		
		//빈칸 채워주세요.
		if(m_bean.getUser_id() == "" || m_bean.getUser_pw() == "" || m_bean.getUser_email() == "" || m_bean.getUser_name() == "") {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('빈칸 채워주세요.  잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
			
		}
		
		
		
		// id  4 ~ 12 글자
		if (id.length() < 4  || id.length() > 11 ) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('ID 4~12 글자 수 입니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		// 대소문자만 이용 
		if(!id_check) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('ID 대소문자만 가능합니다. 잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
			
		}
		

	
		// 아이디 중복 체크
		System.out.println("check_id " + check_id);
		check_id = m_dao.checkId(id);
		if(check_id) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('아이디 중복입니다. 잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		// 한글만
		if(!name_check) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('닉네임  올바르지않습니다. 잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		// 닉네임 중복 체크
		check_name = m_dao.checkName(user_name);
		if(check_name) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('닉네임 중복입니다. 잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		// 닉네임  2~12 글자 수
		if (user_name.length() < 2  || user_name.length() > 11 ) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('닉네임  2~12 글자 수 입니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		
		
		
		
		// 이메일 중복 체크  
		check_email = m_dao.checkEmail(user_email);
		if(check_email) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('이메일 중복입니다. 잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		if(!email_check) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('이메일 올바르지않습니다. 잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		// 아이디 5글자 이상
		
//		3. 아이디 형식 체크

		

		
		// 비밀번호 난이도 조건 준비중
		// PW 4 ~ 12 글자
		if (user_pw.length() < 4  || user_pw.length() > 11 ) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('PW 4~12 글자 수 입니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		
		// join 결과 값 DB 넣기
		result = m_dao.join(m_bean);

		
		
		System.out.println(" [ user_pw ] = " +user_pw);
		if (!result) {

			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('회원가입 실패. 잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		} 
		
		System.out.println(" ---  join  end _________________________________________");

		forward.setRedirect(true);

		forward.setPath(request.getContextPath() + "/member/EmailSend.me?user_id="+user_id+"&user_email="+user_email);
//		forward.setPath(request.getContextPath() + "/index.jsp");
		return forward;
	}

}
