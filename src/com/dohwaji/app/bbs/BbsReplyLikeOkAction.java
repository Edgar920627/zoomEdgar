package com.dohwaji.app.bbs;

import java.util.HashMap;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.app.bbs.dao.BbsDAO;
import com.dohwaji.app.bbs.dao.BbsFilesDAO;
import com.dohwaji.app.bbs.dao.BbsReplyBean;
import com.dohwaji.app.bbs.dao.BbsReplyDAO;


public class BbsReplyLikeOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");


		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();

		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsFilesDAO bf_dao = new BbsFilesDAO();
		BbsReplyBean br_bean = new BbsReplyBean();
		BbsReplyDAO br_dao = new BbsReplyDAO();

		int bbs_num = Integer.parseInt(request.getParameter("bbs_num"));
		int reply_num = Integer.parseInt(request.getParameter("reply_num"));
		String user_id = request.getParameter("user_id");
		String login_ip = request.getParameter("login_ip");
		

	
		
		// no와 id값을 map에 저장
		Map<String, Object> m = new HashMap<>();
		m.put("bbs_num", bbs_num);
		m.put("reply_num", reply_num);
		m.put("login_ip", login_ip);
		
		

		System.out.println("1. BbsReplyLikeOkAction bbs_num =" + bbs_num);
		System.out.println("2. BbsReplyLikeOkAction user_id =" + user_id);
		System.out.println("3. BbsReplyLikeOkAction reply_num =" + reply_num);
		System.out.println("4. BbsReplyLikeOkAction login_ip =" + login_ip);

	
		// 동일 게시글에 대한 이전 추천 여부 검색
		int result = br_dao.like_check(m);

		System.out.println("4. BbsReplyLikeOkAction result =" + result);

		if (result == 0) { // 추천하지 않았다면 추천 추가

			br_dao.like_update(m);

		} else { // 추천을 하였다면 추천 삭제

			br_dao.like_delete(m);
		}

		
		
		// 해당 댓글 추천 갯수  bbsReply 테이블  'reply_likeCnt' 에 저장
		int reply_likeCnt = br_dao.like_count(reply_num);
		
		System.out.println("reply_likeCnt = " + reply_likeCnt);

		br_bean.setReply_num(reply_num);
		br_bean.setReply_likeCnt(reply_likeCnt);
	
		br_dao.likeCnt(br_bean); 

		
		
		
		
//		forward.setRedirect(false);
//		forward.setPath("/blue/admin/product_detail.jsp");
//		return forward;

		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/bbs/BbsView.bb?bbs_num=" + bbs_num);
		return forward;
	}
}
