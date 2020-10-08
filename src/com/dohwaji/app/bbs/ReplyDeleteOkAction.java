package com.dohwaji.app.bbs;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.app.bbs.dao.BbsDAO;
import com.dohwaji.app.bbs.dao.BbsFilesBean;
import com.dohwaji.app.bbs.dao.BbsFilesDAO;
import com.dohwaji.app.bbs.dao.BbsReplyBean;
import com.dohwaji.app.bbs.dao.BbsReplyDAO;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;

import com.dohwaji.config.ProjectConfig;

public class ReplyDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberBean m_bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();
		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsFilesBean bf_bean = new BbsFilesBean();
		BbsFilesDAO bf_dao = new BbsFilesDAO();
		BbsReplyDAO br_dao = new BbsReplyDAO();
		BbsReplyBean br_bean = new BbsReplyBean();
		

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		ActionForward forward = new ActionForward();

		int bbs_num = Integer.parseInt(request.getParameter("bbs_num"));
		int reply_num = Integer.parseInt(request.getParameter("reply_num"));

		
		// no와 id값을 map에 저장
		Map<String, Object> m = new HashMap<>();
		m.put("bbs_num", bbs_num);
		m.put("reply_num", reply_num);

		
		// 댓글 추천 전체 삭제
		br_dao.reply_delete(m);
		
		
		// 댓글 1개 삭제
		br_dao.deleteOneReply(reply_num);
		

		
		// 상세보기
		b_bean = b_dao.getBbsDetail(bbs_num);


		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/bbs/BbsView.bb?bbs_num="+bbs_num);


		return forward;
	}

}