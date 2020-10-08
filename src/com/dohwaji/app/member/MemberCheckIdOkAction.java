package com.dohwaji.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberDAO;

public class MemberCheckIdOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		MemberDAO m_dao = new MemberDAO();
		
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		if(m_dao.checkId(id)) {
			out.println("not-ok");
		}else {
			out.println("ok");
		}
		out.close();
		return null;
	}
}
