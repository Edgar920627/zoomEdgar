package com.dohwaji.app.member;

import java.io.File;

import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.config.ProjectConfig;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MypageUpdateOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		
		MemberDAO m_dao = new MemberDAO();
		boolean result = false;
		
		boolean check_name = false;
		
		
//		String user_id = (String) request.getSession().getAttribute("session_id");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		
		
		
		
		
		boolean name_check = Pattern.matches("^[가-힣]*$", user_name);
		
		MemberBean memberBean = m_dao.getMemberDetail(user_id);
		
		
		// 기존 정보
		memberBean.setUser_num(memberBean.getUser_num());
		memberBean.setUser_id(user_id);

		memberBean.setUser_email(memberBean.getUser_email());
		memberBean.setUser_date(memberBean.getUser_date());

		
		
		
		// 리턴 기존 닉네임  
		String pastName = m_dao.nameBring(user_id);
		
		
		
		// 복호화
		user_pw = m_dao.encrypt(user_pw);
		
		
		// 수정 할 정보
		
		memberBean.setUser_pw(user_pw);
		memberBean.setUser_name(user_name);
		
		
		System.out.println(user_id);
		System.out.println(user_pw);
		System.out.println(user_name);
		System.out.println(memberBean.getUser_date());
		System.out.println(memberBean.getUser_email());
		System.out.println(memberBean.getUser_num());

	
		
		//빈칸 채워주세요.
		if(memberBean.getUser_pw() == "" || memberBean.getUser_name() == "") {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('빈칸 채워주세요.  잠시 후 다시 시도해주세요.');history.back();");
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
		
		System.out.println(" pastName = " + pastName);
		

		
		
		
		// 닉네임  2~12 글자 수
		if (user_name.length() < 2  || user_name.length() > 11 ) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('닉네임  2~12 글자 수 입니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		// 닉네임 중복 체크
		check_name = m_dao.checkName(user_name);
		
		if(pastName.equals(user_name)) {
		
			System.out.println("진입 pastName " +pastName);
			
		}else if(check_name) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('닉네임 중복입니다. 잠시 후 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
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
		
		
		
		
		
		result = m_dao.updateuser(memberBean);
		
		if (!result) {
			System.out.println("result 진입");
			
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('회원 정보 수정 실패. 다시 시도해주세요');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		out.println("<script>");
		out.println("alert('회원 정보 수정 완료');");
		out.println("</script>");
		forward.setRedirect(true);
		
		forward.setPath(request.getContextPath() + "/member/MemberInformation.me?user_id=" + (String) session.getAttribute("session_id"));

		return forward;

	}
}
