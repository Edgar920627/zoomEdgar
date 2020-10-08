package com.dohwaji.app.member;

import java.util.Map;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;


public class MypageCheckPWAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		MemberBean m_bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();
		boolean check = false;

		String id = (String) session.getAttribute("session_id");
		String pw = request.getParameter("pw");
		
		// 복호화
		pw = m_dao.encrypt(pw);

		Map<String, String>resultMap = m_dao.login(id, pw);
		
		check = m_dao.checkId(id);

		forward.setRedirect(false);

		if(resultMap != null) {
			session.setAttribute("session_pw", resultMap.get("USER_PW"));
			forward.setPath("/app/member/mypage_update.jsp");
		} else {

			forward.setPath("/member/memberEnterPW.me?check=false");
		}

		return forward;
	}
}