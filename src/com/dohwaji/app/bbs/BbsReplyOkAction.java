package com.dohwaji.app.bbs;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.app.bbs.dao.BbsDAO;
import com.dohwaji.app.bbs.dao.BbsFilesBean;
import com.dohwaji.app.bbs.dao.BbsFilesDAO;
import com.dohwaji.app.bbs.dao.BbsReplyBean;
import com.dohwaji.app.bbs.dao.BbsReplyDAO;

public class BbsReplyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("BbsReplyOkAction ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ start");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsFilesBean bf_bean = new BbsFilesBean();
		BbsFilesDAO bf_dao = new BbsFilesDAO();
		BbsReplyBean bbsReplyBean = new BbsReplyBean();
		BbsReplyDAO br_dao = new BbsReplyDAO();

		ActionForward forward = new ActionForward();
		boolean br_result = false;

		String user_id = (String) request.getSession().getAttribute("session_id");
		System.out.println("[ user_id ] = " + user_id);

		int bbs_num = Integer.parseInt(request.getParameter("bbs_num"));
		System.out.println("[ bbs_num ] = " + bbs_num);

		String reply_write = request.getParameter("reply_write");
		System.out.println("[ reply_write ] = " + reply_write);

		int reply_point = Integer.parseInt(request.getParameter("reply_point"));
		System.out.println("[ reply_point ] = " + reply_point);
		
		
		
		String reply_stars = "☆☆☆☆☆";
		if (reply_point == 5) {
			reply_stars = "★★★★★";
			bbsReplyBean.setReply_stars(reply_stars);
		} else if (reply_point == 4) {
			reply_stars = "★★★★☆";
			bbsReplyBean.setReply_stars(reply_stars);

		} else if (reply_point == 3) {
			reply_stars = "★★★☆☆";
			bbsReplyBean.setReply_stars(reply_stars);

		} else if (reply_point == 2) {
			reply_stars = "★★☆☆☆";
			bbsReplyBean.setReply_stars(reply_stars);

		} else if (reply_point == 1) {
			reply_stars = "★☆☆☆☆";
			bbsReplyBean.setReply_stars(reply_stars);


		} else if (reply_point == 0) {
			reply_stars = "☆☆☆☆☆";
			bbsReplyBean.setReply_stars(reply_stars);
		}
		
		
		
		

		bbsReplyBean.setBbs_num(bbs_num);
		bbsReplyBean.setUser_id(user_id);
		bbsReplyBean.setReply_write(reply_write);
		bbsReplyBean.setReply_point(reply_point);

		System.out.println("[ bbsReplyBean ] = " + bbsReplyBean);
		
		
		
		
		
		
		
		
		
		// 로그인 
		if(user_id == null || user_id.equals("") || user_id == "") {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('로그인 해주세요');history.back();");
			out.println("</script>");
			out.close();
			return null;
			
			
		}
		
		
		// 공백
		if(reply_write == null || reply_write == "") {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('댓글  글자 수 제한 있습니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
			
		}
		
		// 댓글 글자수 제한
		if(reply_write.length() > 200 && reply_write.length() > 0) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('댓글  글자 수 제한 있습니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
	
		}
		
		

		
		
		br_result = br_dao.insertBbsReply(bbsReplyBean);

		if (!br_result) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert(다시요.')");
			out.println("</script>");
			out.close();
			return null;
		}

		System.out.println("BbsReplyOkAction ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ end");
		request.setAttribute("bbs_num", bbs_num);
		
		
//		forward.setRedirect(true);
//		forward.setPath(request.getContextPath() + "/bbs/BbsView.bb?bbs_num="+bbs_num);
	
		forward.setRedirect(false);
		forward.setPath("/bbs/BbsView.bb?bbs_num="+bbs_num);

		return forward;

	}
}