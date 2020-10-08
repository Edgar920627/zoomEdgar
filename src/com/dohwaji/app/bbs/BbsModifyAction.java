package com.dohwaji.app.bbs;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.app.bbs.dao.BbsDAO;
import com.dohwaji.app.bbs.dao.BbsFilesBean;
import com.dohwaji.app.bbs.dao.BbsFilesDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BbsModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsFilesBean bf_bean = new BbsFilesBean();
		BbsFilesDAO bf_dao = new BbsFilesDAO();
		ActionForward forward = new ActionForward();
		
		
		
		int bbs_num = Integer.parseInt(request.getParameter("bbs_num"));
		String bbs_maindiv = request.getParameter("bbs_maindiv");
		String bbs_smalldiv = request.getParameter("bbs_smalldiv");
		
		
		b_bean = b_dao.getBbsDetail(bbs_num);
		request.setAttribute("bbsBean", b_bean);
		request.setAttribute("bbs_num", bbs_num);
		request.setAttribute("bbs_maindiv", bbs_maindiv);
		request.setAttribute("bbs_smalldiv", bbs_smalldiv);
		
		forward.setRedirect(false);
		forward.setPath("/app/bbs/bbsModify.jsp");
		
		return forward;
	}
}






