package com.dohwaji.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;

public class MemberLogOutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		
		session.invalidate();
		
		

		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/index.jsp");
		
		return forward;
	}
}
